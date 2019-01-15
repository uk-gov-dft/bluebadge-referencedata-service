package uk.gov.dft.bluebadge.service.referencedata.repository;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.gov.dft.bluebadge.common.service.exception.BadRequestException;
import uk.gov.dft.bluebadge.service.referencedata.ReferenceDataFixture;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.LocalAuthorityEntity;

public class ReferenceDataRepositoryTest extends ReferenceDataFixture {

  @Mock SqlSession session;

  @Test
  public void findByDomain() {
    MockitoAnnotations.initMocks(this);
    when(session.selectList(any(), any())).thenReturn(Collections.singletonList(sampleEntity));
    ReferenceDataRepository repository = new ReferenceDataRepository(session);

    assertEquals(
        sampleEntityList.get(0).getShortCode(),
        repository.findByDomain("ABC").get(0).getShortCode());
    verify(session, times(1)).selectList("findByDomain", "ABC");
  }

  @Test
  public void updateLASuccess() {
    MockitoAnnotations.initMocks(this);
    when(session.update(any(), any())).thenReturn(1);
    ReferenceDataRepository repository = new ReferenceDataRepository(session);

    LocalAuthorityEntity la =
        LocalAuthorityEntity.builder()
            .shortCode("ABC")
            .differentServiceSignpostUrl("http://different_url.com")
            .build();
    repository.update(la);
    verify(session, times(1)).update("updateLAMetaData", la);
  }

  @Test(expected = BadRequestException.class)
  public void updateLAFail() {
    MockitoAnnotations.initMocks(this);
    when(session.update(any(), any())).thenReturn(0);
    ReferenceDataRepository repository = new ReferenceDataRepository(session);

    LocalAuthorityEntity la =
        LocalAuthorityEntity.builder()
            .shortCode("ABC")
            .differentServiceSignpostUrl("http://different_url.com")
            .build();
    repository.update(la);
    verify(session, times(1)).update("updateLAMetaData", la);
  }
}
