/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.1-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen Do not edit the class manually.
 */
package uk.gov.dft.bluebadge.service.referencedata.generated.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.gov.dft.bluebadge.common.api.model.CommonResponse;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalAuthority;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceDataResponse;

@Api(value = "ReferenceData")
public interface ReferenceDataApi {

  Logger log = LoggerFactory.getLogger(ReferenceDataApi.class);

  default Optional<ObjectMapper> getObjectMapper() {
    return Optional.empty();
  }

  default Optional<HttpServletRequest> getRequest() {
    return Optional.empty();
  }

  default Optional<String> getAcceptHeader() {
    return getRequest().map(r -> r.getHeader("Accept"));
  }

  @ApiOperation(
    value = "Retrieve all reference data for a domain",
    nickname = "findByDomain",
    notes = "",
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
  default ResponseEntity<ReferenceDataResponse> findByDomain(
      @ApiParam(value = "Domain to retrieve data for", required = true) @PathVariable("domain")
          String domain) {
    if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
      if (getAcceptHeader().get().contains("application/json")) {
        try {
          return new ResponseEntity<>(
              getObjectMapper().get().readValue("\"\"", ReferenceDataResponse.class),
              HttpStatus.NOT_IMPLEMENTED);
        } catch (IOException e) {
          log.error("Couldn't serialize response for content type application/json", e);
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
      }
    } else {
      log.warn(
          "ObjectMapper or HttpServletRequest not configured in default ReferenceDataApi interface so no example is generated");
    }
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  @ApiOperation(
    value = "Update Local Authority data",
    nickname = "updateLocalAuthority",
    notes = "",
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
  default ResponseEntity<CommonResponse> updateLocalAuthority(
      @ApiParam(value = "Local Authority short code", required = true) @PathVariable("shortCode")
          String shortCode,
      @ApiParam(value = "Local Authority meta info to updateLocalAuthority", required = true) @Valid @RequestBody
          LocalAuthority localAuthority) {
    if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
      if (getAcceptHeader().get().contains("application/json")) {
        try {
          return new ResponseEntity<>(
              getObjectMapper()
                  .get()
                  .readValue(
                      "{  \"apiVersion\" : \"apiVersion\",  \"method\" : \"method\",  \"context\" : \"context\",  \"id\" : \"id\",  \"error\" : {    \"code\" : 0,    \"message\" : \"message\",    \"errors\" : [ {      \"reason\" : \"reason\",      \"field\" : \"field\",      \"locationType\" : \"locationType\",      \"location\" : \"location\",      \"message\" : \"message\"    }, {      \"reason\" : \"reason\",      \"field\" : \"field\",      \"locationType\" : \"locationType\",      \"location\" : \"location\",      \"message\" : \"message\"    } ]  }}",
                      CommonResponse.class),
              HttpStatus.NOT_IMPLEMENTED);
        } catch (IOException e) {
          log.error("Couldn't serialize response for content type application/json", e);
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
      }
    } else {
      log.warn(
          "ObjectMapper or HttpServletRequest not configured in default ReferenceDataApi interface so no example is generated");
    }
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
}
