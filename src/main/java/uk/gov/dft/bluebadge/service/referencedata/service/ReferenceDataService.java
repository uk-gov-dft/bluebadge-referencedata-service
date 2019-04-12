package uk.gov.dft.bluebadge.service.referencedata.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import uk.gov.dft.bluebadge.common.service.exception.NotFoundException;
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

  public void updateLocalAuthority(String shortCode, LocalAuthority la) {
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
            .contactNumber(StringUtils.trimAllWhitespace(la.getContactNumber()))
            .contactUrl(la.getContactUrl())
            .emailAddress(la.getEmailAddress())
            .clockType(la.getBadgePackType())
            .paymentsEnabled(la.getPaymentsEnabled())
            .badgeCost(la.getBadgeCost())
            .differentServiceSignpostUrl(la.getDifferentServiceSignpostUrl())
            .build();
    int updates = repository.updateLocalAuthority(shortCode, la.getDescription(), entity);
    if (updates == 0) {
      throw new NotFoundException("LA", NotFoundException.Operation.UPDATE);
    }
  }

  public void updateLocalCouncil(String shortCode, LocalCouncil localCouncil) {
    if (repository.updateLocalCouncil(shortCode, localCouncil) == 0) {
      throw new NotFoundException("LC", NotFoundException.Operation.UPDATE);
    }
  }
}
