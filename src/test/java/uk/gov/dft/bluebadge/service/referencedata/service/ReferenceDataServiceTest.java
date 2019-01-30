package uk.gov.dft.bluebadge.service.referencedata.service;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalCouncil;
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
  public void updateLocalAuthority_shouldReturnTrue_WhenUpdateIsSuccessful() {
    when(repositoryMock.updateLocalAuthority(
            SHORTCODE, DESCRIPTION, LOCAL_AUTHORITY_ENTITY_MANDATORY_VALUES_ONLY))
        .thenReturn(1);
    Assert.assertTrue(
        service.updateLocalAuthority(SHORTCODE, LOCAL_AUTHORITY_MANDATORY_VALUES_ONLY));
  }

  @Test
  public void updateLocalAuthority_shouldReturn0_whenUpdateFails() {
    when(repositoryMock.updateLocalAuthority(
            SHORTCODE, null, LOCAL_AUTHORITY_ENTITY_MANDATORY_VALUES_ONLY))
        .thenReturn(0);
    Assert.assertFalse(
        service.updateLocalAuthority(SHORTCODE, LOCAL_AUTHORITY_MANDATORY_VALUES_ONLY));
  }

  @Test
  public void updateLocalCouncil() {
    // Success path
    when(repositoryMock.updateLocalCouncil(any(), any())).thenReturn(1);
    assertThat(service.updateLocalCouncil("ANGL", new LocalCouncil())).isTrue();

    // Fail path
    when(repositoryMock.updateLocalCouncil(any(), any())).thenReturn(0);
    assertThat(service.updateLocalCouncil("ANGL", new LocalCouncil())).isFalse();
  }
}
