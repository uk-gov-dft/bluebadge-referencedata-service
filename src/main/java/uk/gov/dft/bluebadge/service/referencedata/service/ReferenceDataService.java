package uk.gov.dft.bluebadge.service.referencedata.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalAuthority;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalCouncil;
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

  public boolean updateLocalAuthority(String shortCode, LocalAuthority la) throws JsonProcessingException {
    LocalAuthorityEntity entity =
        LocalAuthorityEntity.builder()
            .welshDescription(la.getWelshDescription())
            .nameLine2(la.getNameLine2())
            .addressLine1(la.getAddressLine1())
            .addressLine2(la.getAddressLine2())
            .addressLine3(la.getAddressLine3())
            .addressLine4(la.getAddressLine4())
            .town(la.getTown())
            .county(la.getCounty())
            .country(la.getCountry())
            .postcode(la.getPostcode())
            .nation(la.getNation())
            .contactNumber(la.getContactNumber())
            .contactUrl(la.getContactUrl())
            .emailAddress(la.getEmailAddress())
            .badgePackType(la.getBadgePackType())
            .paymentsEnabled(la.getPaymentsEnabled())
            .badgeCost(la.getBadgeCost())
            .differentServiceSignpostUrl(la.getDifferentServiceSignpostUrl())
            .build();
    return repository.update(shortCode, entity);
  }

  public boolean updateLocalCouncil(String shortCode, LocalCouncil localCouncil) {
    int result = repository.updateLocalCouncil(shortCode, localCouncil);
    return result == 1;
  }
}
