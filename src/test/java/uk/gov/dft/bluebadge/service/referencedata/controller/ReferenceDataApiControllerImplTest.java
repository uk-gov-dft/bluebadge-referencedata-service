package uk.gov.dft.bluebadge.service.referencedata.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.gov.dft.bluebadge.common.service.exception.NotFoundException;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalCouncil;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceDataResponse;
import uk.gov.dft.bluebadge.service.referencedata.ReferenceDataFixture;
import uk.gov.dft.bluebadge.service.referencedata.service.ReferenceDataService;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ReferenceDataApiControllerImplTest extends ReferenceDataFixture {

  @Mock ReferenceDataService service;
  private ObjectMapper objectMapper = new ObjectMapper();

  private MockMvc mvc;

  @Before
  public void setup() {
    mvc =
        MockMvcBuilders.standaloneSetup(new ReferenceDataApiController(service, objectMapper))
            .setControllerAdvice(CommonResponseControllerAdvice.class)
            .build();
  }

  @Test
  public void findByDomain() {

    when(service.findByDomain("DOMAIN")).thenReturn(sampleEntityList);
    ReferenceDataApiController controller = new ReferenceDataApiController(service, objectMapper);

    ResponseEntity<ReferenceDataResponse> response = controller.findByDomain("DOMAIN");
    assertEquals(1, Objects.requireNonNull(response.getBody()).getData().size());
  }

  @Test
  @SneakyThrows
  public void update_shouldBeOK_WhenPassingAllMandatoryValues() {
    String body = objectMapper.writeValueAsString(LOCAL_AUTHORITY_MANDATORY_VALUES_ONLY);

    RequestBuilder builder =
        MockMvcRequestBuilders.put("/reference-data/authorities/ABC")
            .content(body)
            .contentType(MediaType.APPLICATION_JSON);

    mvc.perform(builder).andExpect(status().isOk());
    verify(service, times(1)).updateLocalAuthority(any(), any());
  }

  @Test
  @SneakyThrows
  public void update_shouldBeBadRequest_WhenPassingAnEmptyMandatoryValue() {
    String body = objectMapper.writeValueAsString(LOCAL_AUTHORITY_ONE_MANDATORY_VALUE_IS_EMPTY);
    RequestBuilder builder =
        MockMvcRequestBuilders.put("/reference-data/authorities/ABC")
            .content(body)
            .contentType(MediaType.APPLICATION_JSON);

    mvc.perform(builder).andExpect(status().isBadRequest());

    verify(service, never()).updateLocalAuthority(any(), any());
  }

  @Test
  @SneakyThrows
  public void updateLocalAuthority_shouldBeBadRequest_WhenPassingAnInvalidValues() {
    String body =
        objectMapper.writeValueAsString(LOCAL_AUTHORITY_MANDATORY_VALUES_PLUS_INVALID_VALUE);
    RequestBuilder builder =
        MockMvcRequestBuilders.put("/reference-data/authorities/ABC")
            .content(body)
            .contentType(MediaType.APPLICATION_JSON);

    mvc.perform(builder).andExpect(status().isBadRequest());

    verify(service, never()).updateLocalAuthority(any(), any());
  }

  @Test
  @SneakyThrows
  public void updateLocalAuthority_shouldBeNotFound_whenUpdateFails() {
    String body = objectMapper.writeValueAsString(LOCAL_AUTHORITY_MANDATORY_VALUES_ONLY);

    RequestBuilder builder =
        MockMvcRequestBuilders.put("/reference-data/authorities/ABC")
            .content(body)
            .contentType(MediaType.APPLICATION_JSON);

    doThrow(new NotFoundException("", NotFoundException.Operation.UPDATE))
        .when(service)
        .updateLocalAuthority(any(), any());

    ResultActions result = mvc.perform(builder);
    result.andExpect(status().isNotFound());
  }

  @Test
  @SneakyThrows
  public void updateLocalCouncil_success() {

    LocalCouncil lc = new LocalCouncil();
    lc.setDescription("Norm description");
    lc.setWelshDescription("Welsh description");

    RequestBuilder builder =
        MockMvcRequestBuilders.put("/reference-data/councils/ABC")
            .content(objectMapper.writeValueAsString(lc))
            .contentType(MediaType.APPLICATION_JSON);

    mvc.perform(builder).andExpect(status().isOk());

    verify(service, times(1)).updateLocalCouncil("ABC", lc);
  }

  @Test
  @SneakyThrows
  public void updateLocalCouncil_notFound() {

    LocalCouncil lc = new LocalCouncil();
    lc.setDescription("Norm description");
    lc.setWelshDescription("Welsh description");
    doThrow(new NotFoundException("", NotFoundException.Operation.UPDATE))
        .when(service)
        .updateLocalCouncil("ABC", lc);

    RequestBuilder builder =
        MockMvcRequestBuilders.put("/reference-data/councils/ABC")
            .content(objectMapper.writeValueAsString(lc))
            .contentType(MediaType.APPLICATION_JSON);

    mvc.perform(builder).andExpect(status().isNotFound());
  }

  @Test
  @SneakyThrows
  public void updateLocalCouncil_badRequest() {

    LocalCouncil lc = new LocalCouncil();
    lc.setDescription(null); // A NotNull property.

    RequestBuilder builder =
        MockMvcRequestBuilders.put("/reference-data/councils/ABC")
            .content(objectMapper.writeValueAsString(lc))
            .contentType(MediaType.APPLICATION_JSON);

    mvc.perform(builder).andExpect(status().isBadRequest());

    verify(service, never()).updateLocalCouncil(any(), any());
  }
}
