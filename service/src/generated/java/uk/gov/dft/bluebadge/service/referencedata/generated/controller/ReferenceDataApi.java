/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen Do not edit the class manually.
 */
package uk.gov.dft.bluebadge.service.referencedata.generated.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceDataResponse;

@Api(value = "ReferenceData", description = "the ReferenceData API")
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
}
