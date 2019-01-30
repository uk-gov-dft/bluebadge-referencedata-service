package uk.gov.dft.bluebadge.service.referencedata.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.dft.bluebadge.common.api.model.CommonResponse;
import uk.gov.dft.bluebadge.common.controller.AbstractController;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalAuthority;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceDataResponse;
import uk.gov.dft.bluebadge.service.referencedata.converter.ReferenceDataConverter;
import uk.gov.dft.bluebadge.service.referencedata.generated.controller.ReferenceDataApi;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;
import uk.gov.dft.bluebadge.service.referencedata.service.ReferenceDataService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReferenceDataApiControllerImpl extends AbstractController implements ReferenceDataApi {

  private final ReferenceDataService service;
  private final ReferenceDataConverter converter;

  @SuppressWarnings("unused")
  @Autowired
  public ReferenceDataApiControllerImpl(ReferenceDataService service, ObjectMapper objectMapper) {
    this.service = service;
    converter = new ReferenceDataConverter(objectMapper);
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

  @PreAuthorize("hasAuthority('PERM_MANAGE_LOCAL_AUTHORITIES')")
  @Override
  public ResponseEntity<CommonResponse> updateLocalAuthority(
    @PathVariable(required = true) String shortCode,
    @Valid @RequestBody LocalAuthority localAuthority) {
    if (service.updateLocalAuthority(shortCode, localAuthority)) {
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
