package uk.gov.dft.bluebadge.service.referencedata.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.gov.dft.bluebadge.common.service.exception.BadRequestException;
import uk.gov.dft.bluebadge.service.referencedata.ReferenceDataFixture;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.LocalAuthorityEntityUpdate;

public class ReferenceDataRepositoryTest extends ReferenceDataFixture {

  @Mock SqlSession sqlSessionMock;

  private ReferenceDataRepository repository;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    ObjectMapper objectMapper = new ObjectMapper();
    repository = new ReferenceDataRepository(sqlSessionMock, objectMapper);
  }

  @Test
  public void findByDomain() {
    when(sqlSessionMock.selectList(any(), any()))
        .thenReturn(Collections.singletonList(sampleEntity));

    assertEquals(
        sampleEntityList.get(0).getShortCode(),
        repository.findByDomain("ABC").get(0).getShortCode());
    verify(sqlSessionMock, times(1)).selectList("findByDomain", "ABC");
  }

  @Test
  public void update_shouldReturnTrue_whenUpdateIsSuccessful() throws JsonProcessingException {
    when(sqlSessionMock.update(any(), any())).thenReturn(1);
    repository.update(SHORTCODE, LOCAL_AUTHORITY_ENTITY_MANDATORY_VALUES_ONLY);

    String body =
        objectMapper.writer().writeValueAsString(LOCAL_AUTHORITY_ENTITY_MANDATORY_VALUES_ONLY);
    LocalAuthorityEntityUpdate localAuthorityEntityUpdateMandatoryValuesOnly =
        LocalAuthorityEntityUpdate.builder()
            .shortCode(SHORTCODE)
            .localAuthorityInJson(body)
            .build();

    verify(sqlSessionMock, times(1))
        .update("updateLAMetaData", localAuthorityEntityUpdateMandatoryValuesOnly);
  }

  @Test(expected = BadRequestException.class)
  public void update_shouldThrowBadRequestException_whenUpdateIsNotSuccessful()
      throws JsonProcessingException {
    when(sqlSessionMock.update(any(), any())).thenReturn(0);
    repository.update(SHORTCODE, LOCAL_AUTHORITY_ENTITY_MANDATORY_VALUES_ONLY);

    String body =
        objectMapper.writer().writeValueAsString(LOCAL_AUTHORITY_ENTITY_MANDATORY_VALUES_ONLY);
    LocalAuthorityEntityUpdate localAuthorityEntityUpdateMandatoryValuesOnly =
        LocalAuthorityEntityUpdate.builder()
            .shortCode(SHORTCODE)
            .localAuthorityInJson(body)
            .build();

    verify(sqlSessionMock, times(1))
        .update("updateLAMetaData", localAuthorityEntityUpdateMandatoryValuesOnly);
  }
}
