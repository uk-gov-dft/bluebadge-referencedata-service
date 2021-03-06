package uk.gov.dft.bluebadge.service.referencedata.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.gov.dft.bluebadge.common.service.exception.BadRequestException;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalCouncil;
import uk.gov.dft.bluebadge.service.referencedata.ReferenceDataFixture;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.LocalAuthorityEntityUpdateParams;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.LocalCouncilEntityUpdateParams;

public class ReferenceDataRepositoryTest extends ReferenceDataFixture {

  @Mock SqlSession sqlSessionMock;
  @Mock ObjectMapper objectMapperMock;

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
  @SneakyThrows
  public void updateLocalAuthority_shouldReturnTrue_whenMandatoryValuesAreValid() {
    when(sqlSessionMock.update(any(), any())).thenReturn(1);
    repository.updateLocalAuthority(
        SHORTCODE, LOCAL_AUTHORITY_DESCRIPTION, getLocalAuthorityEntityMandatoryValues());

    String body =
        objectMapper.writer().writeValueAsString(getLocalAuthorityEntityMandatoryValues());
    LocalAuthorityEntityUpdateParams updateParams =
        LocalAuthorityEntityUpdateParams.builder()
            .shortCode(SHORTCODE)
            .description(LOCAL_AUTHORITY_DESCRIPTION)
            .localAuthorityInJson(body)
            .build();

    verify(sqlSessionMock, times(1)).update("updateLAMetaData", updateParams);
  }

  @Test
  @SneakyThrows
  public void updateLocalAuthority_shouldReturnTrue_whenAllValuesAreValid() {
    when(sqlSessionMock.update(any(), any())).thenReturn(1);
    repository.updateLocalAuthority(
        SHORTCODE, LOCAL_AUTHORITY_DESCRIPTION, getLocalAuthorityEntityAllValues());

    String body = objectMapper.writer().writeValueAsString(getLocalAuthorityEntityAllValues());
    LocalAuthorityEntityUpdateParams updateParams =
        LocalAuthorityEntityUpdateParams.builder()
            .shortCode(SHORTCODE)
            .description(LOCAL_AUTHORITY_DESCRIPTION)
            .localAuthorityInJson(body)
            .build();

    verify(sqlSessionMock, times(1)).update("updateLAMetaData", updateParams);
  }

  @SneakyThrows
  @Test(expected = BadRequestException.class)
  public void updateLocalAuthority_shouldThrowBadRequestException_whenUpdateIsNotSuccessful() {

    ReferenceDataRepository repository =
        new ReferenceDataRepository(sqlSessionMock, objectMapperMock);
    when(objectMapperMock.writeValueAsString(any())).thenThrow(JsonProcessingException.class);

    repository.updateLocalAuthority(
        SHORTCODE, LOCAL_AUTHORITY_DESCRIPTION, getLocalAuthorityEntityMandatoryValues());

    String body =
        objectMapper.writer().writeValueAsString(getLocalAuthorityEntityMandatoryValues());
    LocalAuthorityEntityUpdateParams updateParams =
        LocalAuthorityEntityUpdateParams.builder()
            .shortCode(SHORTCODE)
            .description(LOCAL_AUTHORITY_DESCRIPTION)
            .localAuthorityInJson(body)
            .build();

    verify(sqlSessionMock, never()).update(eq("updateLAMetaData"), any());
  }

  @Test
  public void updateLocalCouncil_success() {
    when(sqlSessionMock.update(eq("updateLCMetaData"), any())).thenReturn(1);

    LocalCouncilEntityUpdateParams params =
        LocalCouncilEntityUpdateParams.builder()
            .shortCode("ANGL")
            .description("Not sent to db!")
            .json("{\"welshDescription\":\"Welsh\"}")
            .build();

    LocalCouncil lc = new LocalCouncil();
    lc.setWelshDescription("Welsh");
    lc.setDescription("Not sent to db!");
    repository.updateLocalCouncil("ANGL", lc);

    verify(sqlSessionMock, times(1)).update("updateLCMetaData", params);
  }

  @SneakyThrows
  @Test(expected = BadRequestException.class)
  public void updateLocalCouncil_serialisationError() {
    ReferenceDataRepository repository =
        new ReferenceDataRepository(sqlSessionMock, objectMapperMock);
    when(objectMapperMock.writeValueAsString(any())).thenThrow(JsonProcessingException.class);

    repository.updateLocalCouncil("ANGL", new LocalCouncil());
  }

  @Test
  public void updateLocalCouncil_nullWelshDescription() {
    when(sqlSessionMock.update(eq("updateLCMetaData"), any())).thenReturn(1);

    LocalCouncilEntityUpdateParams params =
        LocalCouncilEntityUpdateParams.builder()
            .shortCode("ANGL")
            .description("Not sent to db!")
            .json("{\"welshDescription\":null}")
            .build();

    LocalCouncil lc = new LocalCouncil();
    lc.setWelshDescription(null);
    lc.setDescription("Not sent to db!");
    repository.updateLocalCouncil("ANGL", lc);

    verify(sqlSessionMock, times(1)).update("updateLCMetaData", params);
  }
}
