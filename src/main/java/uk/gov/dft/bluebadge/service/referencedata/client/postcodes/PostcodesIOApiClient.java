package uk.gov.dft.bluebadge.service.referencedata.client.postcodes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class PostcodesIOApiClient {

  private final RestTemplate restTemplate;

  @Autowired
  public PostcodesIOApiClient(
      @Qualifier("postcodeIORestTemplate") RestTemplate postcodeIORestTemplate) {
    this.restTemplate = postcodeIORestTemplate;
  }

  /**
   * Retrieve badge reference data
   *
   * @return List of reference data items.
   */
  public PostcodeIO findPostcode(String postcode) {
    log.debug("Finding postcode by postcode {}", postcode);
    PostcodeIOResult result = restTemplate
        .getForObject("/postcodes/{postcode}", PostcodeIOResult.class, postcode);
    return result.getResult();
  }
}
