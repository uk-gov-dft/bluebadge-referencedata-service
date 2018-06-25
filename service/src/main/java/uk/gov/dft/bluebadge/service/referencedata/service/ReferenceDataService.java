package uk.gov.dft.bluebadge.service.referencedata.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.gov.dft.bluebadge.service.referencedata.repository.ReferenceDataRepository;
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
    return repository.findByDomain(domain);
  }
}
