package uk.gov.dft.bluebadge.service.referencedata.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.gov.dft.bluebadge.common.service.exception.BadRequestException;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalAuthority;
import uk.gov.dft.bluebadge.service.referencedata.repository.ReferenceDataRepository;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

public class ReferenceDataServiceTest {

  private ReferenceDataService service;

  @Mock private ReferenceDataRepository repository;
  private ArrayList<ReferenceDataEntity> refDataList;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    service = new ReferenceDataService(repository);
    // A perhaps pointless test as the service does nothing in find at the moment,
    // but it's a placeholder for the future.
    refDataList = new ArrayList<>();
    ReferenceDataEntity entity = new ReferenceDataEntity();
    refDataList.add(entity);

    when(repository.findByDomain("ADOMAIN")).thenReturn(refDataList);
  }

  @Test
  public void findByDomain() {
    Assert.assertEquals(refDataList, service.findByDomain("ADOMAIN"));
  }

  @Test
  public void findByLowerCaseDomain_shouldReturnResults() {
    Assert.assertEquals(refDataList, service.findByDomain("adomain"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void findByBlankDomain_shouldThrowIllegalArgumentException() {
    Assert.assertEquals(refDataList, service.findByDomain(""));
  }

  @Test
  public void updateLA_existing_shortCode() {
    when(repository.update(any())).thenReturn(true);

    LocalAuthority la = new LocalAuthority();
    la.setDifferentServiceSignpostUrl("http://dirreferent_url.com");
    Assert.assertTrue(service.update("ABC", la));
  }

  @Test(expected = BadRequestException.class)
  public void updateLA_absent_shortCode() {
    when(repository.update(any())).thenThrow(BadRequestException.class);

    LocalAuthority la = new LocalAuthority();
    la.setDifferentServiceSignpostUrl("http://dirreferent_url.com");
    Assert.assertFalse(service.update("XYZ", la));
  }
}
