package uk.gov.dft.bluebadge.service.referencedata.client.postcodes;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import uk.gov.dft.bluebadge.common.api.model.Error;
import uk.gov.dft.bluebadge.common.service.exception.BadRequestException;
import uk.gov.dft.bluebadge.common.service.exception.InternalServerException;
import uk.gov.dft.bluebadge.common.service.exception.NotFoundException;

@Slf4j
public class PostcodeIOErrorHandler extends DefaultResponseErrorHandler {

  private final ObjectMapper om;

  public PostcodeIOErrorHandler(ObjectMapper om) {
    this.om = om;
  }

  @Override
  public void handleError(ClientHttpResponse httpResponse) throws IOException {
    String postcodeIOMessage = extractMessage(httpResponse);

    if (httpResponse.getStatusCode().equals(NOT_FOUND)) {
      log.info("Not found from Postcodes.io. Msg:{}", postcodeIOMessage);
      throw new NotFoundException("Postcode", NotFoundException.Operation.RETRIEVE);
    } else if (httpResponse.getStatusCode().equals(BAD_REQUEST)) {
      log.info("Bad request from Postcodes.io. Msg:{}", postcodeIOMessage);
      throw new BadRequestException("Postcode", "Failed to find postcode", "Invalid postcode");
    }

    log.error(
        "Error from Postcodes.io. Status:{} Msg:{}",
        httpResponse.getStatusCode(),
        postcodeIOMessage);
    throw new InternalServerException(
        new Error().message("Failed to retrieve postcode from Postcode.io"));
  }

  private String extractMessage(ClientHttpResponse httpResponse) {
    try {
      Map map = om.readValue(httpResponse.getBody(), Map.class);
      if (map.containsKey("error")) {
        return (String) map.get("error");
      }
      log.warn(
          "Unable to extract error message from the Postcode. Field 'error' not found. Error body:{}",
          map);
    } catch (IOException e) {
      log.warn("Failed to extract error message from PostcodeIO response. {}", e.getMessage());
    }

    return null;
  }
}
