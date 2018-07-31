package uk.gov.dft.bluebadge.service.referencedata.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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

}
