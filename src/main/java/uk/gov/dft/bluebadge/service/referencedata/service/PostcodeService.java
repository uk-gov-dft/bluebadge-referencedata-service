package uk.gov.dft.bluebadge.service.referencedata.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uk.gov.dft.bluebadge.common.service.exception.NotFoundException;
import uk.gov.dft.bluebadge.service.referencedata.client.postcodes.PostcodeIO;
import uk.gov.dft.bluebadge.service.referencedata.client.postcodes.PostcodesIOApiClient;
import uk.gov.dft.bluebadge.service.referencedata.repository.ReferenceDataRepository;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

@Service
@Slf4j
public class PostcodeService {
  private static final String LOCAL_AUTHORITY = "Local Authority";
  private final PostcodesIOApiClient postcodesClient;
  private final ReferenceDataRepository repository;

  public PostcodeService(PostcodesIOApiClient postcodesClient, ReferenceDataRepository repository) {
    this.postcodesClient = postcodesClient;
    this.repository = repository;
  }

  public ReferenceDataEntity findLAByPostcode(String postcode) {
    PostcodeIO postcodeIO = postcodesClient.findPostcode(postcode);

    if (null == postcodeIO) {
      log.debug("No postcode found for: {}", postcode);
      throw new NotFoundException(LOCAL_AUTHORITY, NotFoundException.Operation.RETRIEVE);
    }
    if (null == postcodeIO.getAdminDistrictCode()) {
      log.info("No admin district on postcode from postcodeIO: {}", postcodeIO);
      throw new NotFoundException(LOCAL_AUTHORITY, NotFoundException.Operation.RETRIEVE);
    }

    ReferenceDataEntity la =
        repository.findLAByAdminDistrictCode(postcodeIO.getAdminDistrictCode());
    if (null == la) {
      log.info("No LA found for: {}", postcodeIO);
      throw new NotFoundException(LOCAL_AUTHORITY, NotFoundException.Operation.RETRIEVE);
    }

    log.debug("Postcode {}, associated with LA:{}", postcode, la);
    return la;
  }
}
