package uk.gov.dft.bluebadge.service.referencedata.generated.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.gov.dft.bluebadge.common.api.model.CommonResponse;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalAuthority;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalCouncil;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceDataResponse;

@Api(value = "ReferenceData", description = "the ReferenceData API")
public interface ReferenceDataApi {

  @ApiOperation(
    value = "Retrieve all reference data for a domain",
    nickname = "findByDomain",
    response = ReferenceDataResponse.class,
    tags = {
      "ReferenceData",
    }
  )
  @ApiResponses(
    value = {
      @ApiResponse(
        code = 200,
        message = "An array of reference data",
        response = ReferenceDataResponse.class
      )
    }
  )
  @RequestMapping(
    value = "/reference-data/{domain}",
    produces = {"application/json"},
    method = RequestMethod.GET
  )
  ResponseEntity<ReferenceDataResponse> findByDomain(
      @ApiParam(value = "Domain to retrieve data for", required = true) @PathVariable("domain")
          String domain);

  @ApiOperation(
    value = "Update Local Authority data",
    nickname = "updateLocalAuthority",
    response = CommonResponse.class,
    tags = {
      "ReferenceData",
    }
  )
  @ApiResponses(
    value = {
      @ApiResponse(code = 200, message = "Ok.", response = CommonResponse.class),
      @ApiResponse(code = 400, message = "Bad request", response = CommonResponse.class),
      @ApiResponse(
        code = 404,
        message = "Local Authority not found.",
        response = CommonResponse.class
      )
    }
  )
  @RequestMapping(
    value = "/reference-data/authorities/{shortCode}",
    produces = {"application/json"},
    method = RequestMethod.PUT
  )
  ResponseEntity<CommonResponse> updateLocalAuthority(
      @ApiParam(value = "Local Authority short code", required = true) @PathVariable("shortCode")
          String shortCode,
      @ApiParam(value = "Local Authority meta info to update", required = true) @Valid @RequestBody
          LocalAuthority localAuthority);

  @ApiOperation(
    value = "Update Local Council data",
    nickname = "updateLocalCouncil",
    response = CommonResponse.class,
    tags = {
      "ReferenceData",
    }
  )
  @ApiResponses(
    value = {
      @ApiResponse(code = 200, message = "Ok.", response = CommonResponse.class),
      @ApiResponse(code = 400, message = "Bad request", response = CommonResponse.class),
      @ApiResponse(
        code = 404,
        message = "Local Authority not found.",
        response = CommonResponse.class
      )
    }
  )
  @RequestMapping(
    value = "/reference-data/councils/{shortCode}",
    produces = {"application/json"},
    method = RequestMethod.PUT
  )
  ResponseEntity<CommonResponse> updateLocalCouncil(
      @ApiParam(value = "Local Council short code", required = true) @PathVariable("shortCode")
          String shortCode,
      @ApiParam(value = "Local Council data", required = true) @Valid @RequestBody
          LocalCouncil localCouncil);
}
