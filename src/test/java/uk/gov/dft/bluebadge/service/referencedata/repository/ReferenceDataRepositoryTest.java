package uk.gov.dft.bluebadge.service.referencedata.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.gov.dft.bluebadge.common.service.exception.BadRequestException;
import uk.gov.dft.bluebadge.service.referencedata.ReferenceDataFixture;

public class ReferenceDataRepositoryTest extends ReferenceDataFixture {

  @Mock SqlSession sessionMock;

  private ReferenceDataRepository repository;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    repository = new ReferenceDataRepository(sessionMock);
  }

  @Test
  public void findByDomain() {
    when(sessionMock.selectList(any(), any())).thenReturn(Collections.singletonList(sampleEntity));

    assertEquals(
        sampleEntityList.get(0).getShortCode(),
        repository.findByDomain("ABC").get(0).getShortCode());
    verify(sessionMock, times(1)).selectList("findByDomain", "ABC");
  }

  @Test
  public void update_shouldReturnTrue_whenUpdateIsSuccessful() {
    when(sessionMock.update(any(), any())).thenReturn(1);
    repository.update(LOCAL_AUTHORITY_ENTITY_MANDATORY_VALUES_ONLY);
    verify(sessionMock, times(1))
        .update("updateLAMetaData", LOCAL_AUTHORITY_ENTITY_MANDATORY_VALUES_ONLY);
  }

  @Test(expected = BadRequestException.class)
  public void update_shouldThrowBadRequestException_whenUpdateIsNotSuccessful() {
    when(sessionMock.update(any(), any())).thenReturn(0);
    repository.update(LOCAL_AUTHORITY_ENTITY_MANDATORY_VALUES_ONLY);
    verify(sessionMock, times(1))
        .update("updateLAMetaData", LOCAL_AUTHORITY_ENTITY_MANDATORY_VALUES_ONLY);
  }
}
