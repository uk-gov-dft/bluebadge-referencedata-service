package uk.gov.dft.bluebadge.service.referencedata.client.postcodes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import uk.gov.dft.bluebadge.common.service.exception.BadRequestException;
import uk.gov.dft.bluebadge.common.service.exception.InternalServerException;
import uk.gov.dft.bluebadge.common.service.exception.NotFoundException;

public class PostcodesIOApiClientTest {
  public static final String TEST_URI = "http://justtesting:7878/test";

  PostcodesIOApiClient postcodesIOApiClient;
  MockRestServiceServer mockServer;
  private ClassPathResource postcodeJsonResponse;

  @Before
  public void setup() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(TEST_URI));
    restTemplate.setErrorHandler(new PostcodeIOErrorHandler(new ObjectMapper()));
    mockServer = MockRestServiceServer.bindTo(restTemplate).build();

    postcodesIOApiClient = new PostcodesIOApiClient(restTemplate);
  }

  @Test
  public void findPostcode() {
    postcodeJsonResponse = new ClassPathResource("testdata/postcode_io.json");
    mockServer
        .expect(once(), requestTo(TEST_URI + "/postcodes/CA166XX"))
        .andExpect(method(HttpMethod.GET))
        .andRespond(withSuccess(postcodeJsonResponse, MediaType.APPLICATION_JSON));

    PostcodeIO postcode = postcodesIOApiClient.findPostcode("CA166XX");

    assertThat(postcode).isNotNull();
    assertThat(postcode.getAdminDistrict()).isEqualTo("Eden");
    assertThat(postcode.getAdminDistrictCode()).isEqualTo("E07000030");
    assertThat(postcode.getCountry()).isEqualTo("England");
    assertThat(postcode.getPostcode()).isEqualTo("CA16 6XX");
  }

  @Test(expected = NotFoundException.class)
  public void findPostcode_invalid() {
    postcodeJsonResponse = new ClassPathResource("testdata/postcode_io_invalid.json");
    mockServer
        .expect(once(), requestTo(TEST_URI + "/postcodes/CA166XX"))
        .andExpect(method(HttpMethod.GET))
        .andRespond(
            withStatus(HttpStatus.NOT_FOUND)
                .body(postcodeJsonResponse)
                .contentType(MediaType.APPLICATION_JSON));

    postcodesIOApiClient.findPostcode("CA166XX");
  }

  @Test(expected = NotFoundException.class)
  public void findPostcode_notFound() {
    postcodeJsonResponse = new ClassPathResource("testdata/postcode_io_notfound.json");
    mockServer
        .expect(once(), requestTo(TEST_URI + "/postcodes/CA166XX"))
        .andExpect(method(HttpMethod.GET))
        .andRespond(
            withStatus(HttpStatus.NOT_FOUND)
                .body(postcodeJsonResponse)
                .contentType(MediaType.APPLICATION_JSON));

    postcodesIOApiClient.findPostcode("CA166XX");
  }

  @Test(expected = BadRequestException.class)
  public void findPostcode_badRequest() {
    postcodeJsonResponse = new ClassPathResource("testdata/postcode_io_bad.json");
    mockServer
        .expect(once(), requestTo(TEST_URI + "/postcodes/"))
        .andExpect(method(HttpMethod.GET))
        .andRespond(
            withStatus(HttpStatus.BAD_REQUEST)
                .body(postcodeJsonResponse)
                .contentType(MediaType.APPLICATION_JSON));

    postcodesIOApiClient.findPostcode("");
  }

  @Test(expected = InternalServerException.class)
  public void findPostcode_error() {
    postcodeJsonResponse = new ClassPathResource("testdata/postcode_io_error.json");
    mockServer
        .expect(once(), requestTo(TEST_URI + "/postcodes/CA166XX"))
        .andExpect(method(HttpMethod.GET))
        .andRespond(
            withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(postcodeJsonResponse)
                .contentType(MediaType.APPLICATION_JSON));

    postcodesIOApiClient.findPostcode("CA166XX");
  }

  @Test(expected = InternalServerException.class)
  public void findPostcode_changeToApi() {
    postcodeJsonResponse = new ClassPathResource("testdata/postcode_io_corrupt.json");
    mockServer
        .expect(once(), requestTo(TEST_URI + "/postcodes/whatever"))
        .andExpect(method(HttpMethod.GET))
        .andRespond(
            withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(postcodeJsonResponse)
                .contentType(MediaType.APPLICATION_JSON));

    postcodesIOApiClient.findPostcode("whatever");
  }
}
