package uk.gov.dft.bluebadge.service.referencedata.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalAuthority;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalCouncil;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceDataResponse;
import uk.gov.dft.bluebadge.service.referencedata.controller.model.SingleReferenceDataResponse;
import uk.gov.dft.bluebadge.service.referencedata.converter.ReferenceDataConverter;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;
import uk.gov.dft.bluebadge.service.referencedata.service.PostcodeService;
import uk.gov.dft.bluebadge.service.referencedata.service.ReferenceDataService;

@RestController
public class ReferenceDataApiController {

  private final ReferenceDataService service;
  private final ReferenceDataConverter converter;
  private final PostcodeService postcodeService;

  @SuppressWarnings("unused")
  @Autowired
  ReferenceDataApiController(ReferenceDataService service, ObjectMapper objectMapper, PostcodeService postcodeService) {
    this.service = service;
    converter = new ReferenceDataConverter(objectMapper);
    this.postcodeService = postcodeService;
  }

  /**
   * Return a list of all reference data items by domain.
   *
   * @param domain e.g. BADGE, APP
   * @return List wrapped by CommonResponse
   */
  @GetMapping(value = "/reference-data/{domain}", produces = {"application/json"})
  public ResponseEntity<ReferenceDataResponse> findByDomain(
      @ApiParam(value = "Domain to retrieve data for", required = true) @PathVariable("domain")
          String domain) {
    Assert.notNull(StringUtils.trimToNull(domain), "domain required");

    ReferenceDataResponse response = new ReferenceDataResponse();
    List<ReferenceDataEntity> dataList = service.findByDomain(domain);
    response.setData(converter.convertToModelList(dataList));
    return ResponseEntity.ok(response);
  }

  @GetMapping(value = "/reference-data/postcode/{postcode}", produces = {"application/json"})
  public ResponseEntity<SingleReferenceDataResponse> findLAByPostcode(
      @ApiParam(value = "postcode to retrieve data for", required = true) @PathVariable("postcode")
          String postcode) {
    Assert.notNull(StringUtils.trimToNull(postcode), "postcode required");

    ReferenceDataEntity laReferenceData = postcodeService.findLAByPostcode(postcode);
    SingleReferenceDataResponse response = SingleReferenceDataResponse.builder()
        .referenceData(converter.convertToModel(laReferenceData)).build();
    return ResponseEntity.ok(response);
  }

  @PreAuthorize("hasAuthority('PERM_MANAGE_LOCAL_AUTHORITIES')")
  @PutMapping(value = "/reference-data/authorities/{shortCode}", produces = {"application/json"})
  public ResponseEntity<Void> updateLocalAuthority(
      @PathVariable() String shortCode, @Valid @RequestBody LocalAuthority localAuthority) {
    service.updateLocalAuthority(shortCode, localAuthority);
    return ResponseEntity.ok().build();
  }

  @PreAuthorize("hasAuthority('PERM_MANAGE_LOCAL_AUTHORITIES')")
  @PutMapping(value = "/reference-data/councils/{shortCode}", produces = {"application/json"})
  public ResponseEntity<Void> updateLocalCouncil(
      @PathVariable("shortCode") String shortCode, @Valid @RequestBody LocalCouncil localCouncil) {
    service.updateLocalCouncil(shortCode, localCouncil);
    return ResponseEntity.ok().build();
  }
}
