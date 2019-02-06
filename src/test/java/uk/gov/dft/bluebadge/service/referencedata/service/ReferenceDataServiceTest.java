package uk.gov.dft.bluebadge.service.referencedata.service;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.gov.dft.bluebadge.common.service.exception.NotFoundException;
import uk.gov.dft.bluebadge.service.referencedata.ReferenceDataFixture;
import uk.gov.dft.bluebadge.service.referencedata.repository.ReferenceDataRepository;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

public class ReferenceDataServiceTest extends ReferenceDataFixture {

  private ReferenceDataService service;

  @Mock private ReferenceDataRepository repositoryMock;

  private ArrayList<ReferenceDataEntity> refDataList;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    service = new ReferenceDataService(repositoryMock);
    // A perhaps pointless test as the service does nothing in find at the moment,
    // but it's a placeholder for the future.
    refDataList = new ArrayList<>();
    ReferenceDataEntity entity = new ReferenceDataEntity();
    refDataList.add(entity);

    when(repositoryMock.findByDomain("ADOMAIN")).thenReturn(refDataList);
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
  public void update_shouldReturnTrue_WhenUpdateIsSuccessful() throws JsonProcessingException {
    when(repositoryMock.updateLocalAuthority(
            SHORTCODE, DESCRIPTION, LOCAL_AUTHORITY_ENTITY_MANDATORY_VALUES_ONLY))
        .thenReturn(1);

    service.updateLocalAuthority(SHORTCODE, LOCAL_AUTHORITY_MANDATORY_VALUES_ONLY);
  }

  @Test(expected = NotFoundException.class)
  public void update_shouldReturnBadRequestException_whenUpdateFails() {
    when(repositoryMock.updateLocalAuthority(
            SHORTCODE, DESCRIPTION, LOCAL_AUTHORITY_ENTITY_MANDATORY_VALUES_ONLY))
        .thenReturn(0);

    service.updateLocalAuthority(SHORTCODE, LOCAL_AUTHORITY_MANDATORY_VALUES_ONLY);
  }
}
