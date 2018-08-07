package uk.gov.dft.bluebadge.service.referencedata.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceDataResponse;
import uk.gov.dft.bluebadge.service.referencedata.ReferenceDataFixture;
import uk.gov.dft.bluebadge.service.referencedata.service.ReferenceDataService;

public class ReferenceDataApiControllerImplTest extends ReferenceDataFixture {

  @Mock ReferenceDataService service;

  @Test
  public void findByDomain() {

    when(service.findByDomain("DOMAIN")).thenReturn(sampleEntityList);
    ReferenceDataApiControllerImpl controller = new ReferenceDataApiControllerImpl(service);

    ResponseEntity<ReferenceDataResponse> response = controller.findByDomain("DOMAIN");
    assertEquals(1, response.getBody().getData().size());
  }
}
