package uk.gov.dft.bluebadge.service.referencedata.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.gov.dft.bluebadge.service.referencedata.repository.ReferenceDataRepository;

@Service
@Transactional
@Slf4j
public class ReferenceDataService {

  private final ReferenceDataRepository repository;

  @Autowired
  public ReferenceDataService(ReferenceDataRepository repository) {
    this.repository = repository;
  }

  /*
  public UserEntity retrieveUserById(Integer userId) {
    Optional<UserEntity> userEntity = repository.retrieveUserById(userId);
    if (!userEntity.isPresent()) {
      log.info("Request to retrieve user id:{} that did not exist", userId);
      throw new NotFoundException();
    }
    return userEntity.get();
  }
  */
}
