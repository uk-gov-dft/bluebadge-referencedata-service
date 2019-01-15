package uk.gov.dft.bluebadge.service.referencedata.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import uk.gov.dft.bluebadge.common.api.model.ErrorErrors;
import uk.gov.dft.bluebadge.common.service.exception.BadRequestException;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceDataResponse;
import uk.gov.dft.bluebadge.service.referencedata.ReferenceDataFixture;
import uk.gov.dft.bluebadge.service.referencedata.service.ReferenceDataService;

public class ReferenceDataApiControllerImplTest extends ReferenceDataFixture {

  @Mock ReferenceDataService service;
  ObjectMapper objectMapper = new ObjectMapper();

  private MockMvc mvc;

  @Before
  public void setup() {
    mvc =
        MockMvcBuilders.standaloneSetup(new ReferenceDataApiControllerImpl(service, objectMapper))
            .build();
  }

  @Test
  public void findByDomain() {

    when(service.findByDomain("DOMAIN")).thenReturn(sampleEntityList);
    ReferenceDataApiControllerImpl controller =
        new ReferenceDataApiControllerImpl(service, objectMapper);

    ResponseEntity<ReferenceDataResponse> response = controller.findByDomain("DOMAIN");
    assertEquals(1, response.getBody().getData().size());
  }

  @Test
  @SneakyThrows
  public void updateLA_success() {

    String body =
        "{\"differentServiceSignpostUrl\": \"https://bluebadge.direct.gov.uk/bluebadge/why-are-you-here\"}";
    RequestBuilder builder =
        MockMvcRequestBuilders.put("/reference-data/authorities/ABC")
            .content(body)
            .contentType(MediaType.APPLICATION_JSON);
    when(service.update(any(), any())).thenReturn(true);

    mvc.perform(builder).andExpect(status().isOk());
    verify(service, times(1)).update(any(), any());
  }

  @Test
  @SneakyThrows
  public void updateLA_malformedURL() {

    String body = "{\"differentServiceSignpostUrl\": \"new-url\"}";
    RequestBuilder builder =
        MockMvcRequestBuilders.put("/reference-data/authorities/ABC")
            .content(body)
            .contentType(MediaType.APPLICATION_JSON);

    mvc.perform(builder).andExpect(status().isBadRequest());

    verify(service, never()).update(any(), any());
  }

  @Test
  @SneakyThrows
  public void updateLA_fail() {

    String body =
        "{\"differentServiceSignpostUrl\": \"https://bluebadge.direct.gov.uk/bluebadge/why-are-you-here\"}";
    RequestBuilder builder =
        MockMvcRequestBuilders.put("/reference-data/authorities/ABC")
            .content(body)
            .contentType(MediaType.APPLICATION_JSON);

    ErrorErrors error = new ErrorErrors();
    error
        .field("shortCode")
        .message("Invalid short code ")
        .reason("There is no Local Authority with given short code: ABC");

    BadRequestException e = new BadRequestException(error);
    when(service.update(any(), any())).thenThrow(e);

    ResultActions result = mvc.perform(builder);
    result.andExpect(status().isBadRequest());

    verify(service, times(1)).update(any(), any());
  }
}
