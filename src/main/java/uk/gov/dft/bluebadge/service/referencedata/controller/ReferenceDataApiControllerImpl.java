package uk.gov.dft.bluebadge.service.referencedata.controller;

import io.swagger.annotations.ApiParam;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import uk.gov.dft.bluebadge.common.controller.AbstractController;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceDataResponse;
import uk.gov.dft.bluebadge.service.referencedata.converter.ReferenceDataConverter;
import uk.gov.dft.bluebadge.service.referencedata.generated.controller.ReferenceDataApi;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;
import uk.gov.dft.bluebadge.service.referencedata.service.ReferenceDataService;

@Controller
public class ReferenceDataApiControllerImpl extends AbstractController implements ReferenceDataApi {

  private ReferenceDataService service;
  private ReferenceDataConverter converter = new ReferenceDataConverter();

  @SuppressWarnings("unused")
  @Autowired
  public ReferenceDataApiControllerImpl(ReferenceDataService service) {
    this.service = service;
  }

  /**
   * Return a list of all reference data items by domain.
   *
   * @param domain e.g. BADGE, APP
   * @return List wrapped by CommonResponse
   */
  @Override
  public ResponseEntity<ReferenceDataResponse> findByDomain(
      @ApiParam(value = "Domain to retrieve data for", required = true) @PathVariable("domain")
          String domain) {
    Assert.notNull(StringUtils.trimToNull(domain), "domain required");

    ReferenceDataResponse response = new ReferenceDataResponse();
    List<ReferenceDataEntity> dataList = service.findByDomain(domain);
    response.setData(converter.convertToModelList(dataList));
    return ResponseEntity.ok(response);
  }
}
