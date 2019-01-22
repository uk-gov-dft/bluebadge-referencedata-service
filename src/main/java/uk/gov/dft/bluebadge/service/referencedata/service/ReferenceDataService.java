package uk.gov.dft.bluebadge.service.referencedata.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalAuthority;
import uk.gov.dft.bluebadge.service.referencedata.repository.ReferenceDataRepository;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.LocalAuthorityEntity;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

@Service
@Transactional
public class ReferenceDataService {

  private final ReferenceDataRepository repository;

  @Autowired
  ReferenceDataService(ReferenceDataRepository repository) {
    this.repository = repository;
  }

  public List<ReferenceDataEntity> findByDomain(String domain) {
    Assert.hasText(domain, "Domain supplied must not be blank!");
    return repository.findByDomain(domain.toUpperCase());
  }

  public boolean update(String shortCode, LocalAuthority la) {
    LocalAuthorityEntity entity =
        LocalAuthorityEntity.builder()
            .shortCode(shortCode)
            .differentServiceSignpostUrl(la.getDifferentServiceSignpostUrl())
            .build();
    return repository.update(entity);
  }
}
