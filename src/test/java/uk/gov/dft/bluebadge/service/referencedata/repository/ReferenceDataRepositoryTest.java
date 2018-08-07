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
import uk.gov.dft.bluebadge.service.referencedata.ReferenceDataFixture;

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
}
