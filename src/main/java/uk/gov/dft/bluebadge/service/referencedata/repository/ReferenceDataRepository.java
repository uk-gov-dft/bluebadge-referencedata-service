package uk.gov.dft.bluebadge.service.referencedata.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.dft.bluebadge.common.api.model.Error;
import uk.gov.dft.bluebadge.common.service.exception.BadRequestException;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalCouncil;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.LocalAuthorityEntity;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.LocalAuthorityEntityUpdateParams;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.LocalCouncilEntityUpdateParams;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;
import uk.gov.dft.bluebadge.service.referencedata.repository.mapper.Statements;

/** Provides CRUD operations on ReferenceDataEntity. */
@Component
@Slf4j
public class ReferenceDataRepository {
  private final SqlSession sqlSession;
  private final ObjectMapper objectMapper;

  @Autowired
  public ReferenceDataRepository(SqlSession sqlSession, ObjectMapper objectMapper) {
    this.sqlSession = sqlSession;
    this.objectMapper = objectMapper;
  }

  /**
   * Retrieve a List of ReferenceDataEntity for a domain, e.g. BADGE, APP.
   *
   * @param domainId PK of Domain to select for.
   * @return The retrieved List.
   */
  public List<ReferenceDataEntity> findByDomain(String domainId) {
    List<ReferenceDataEntity> referenceDataList =
        sqlSession.selectList(Statements.FIND_BY_DOMAIN.getName(), domainId);

    if (referenceDataList.isEmpty()) {
      log.warn("Attempt findByDomain id:{} resulted in empty list.", domainId);
    }
    return referenceDataList;
  }

  public int updateLocalAuthority(String shortCode, String description, LocalAuthorityEntity la) {
    try {
      String localAuthorityEntityInJson = objectMapper.writeValueAsString(la);
      LocalAuthorityEntityUpdateParams localAuthorityUpdateEntity =
          LocalAuthorityEntityUpdateParams.builder()
              .shortCode(shortCode)
              .description(description)
              .localAuthorityInJson(localAuthorityEntityInJson)
              .build();
      return sqlSession.update("updateLAMetaData", localAuthorityUpdateEntity);
    } catch (JsonProcessingException ex) {
      Error error = new Error();
      error.setMessage("There was a problem converting the request to Json");
      throw new BadRequestException(error);
    }
  }

  public int updateLocalCouncil(String shortCode, LocalCouncil localCouncil) {
    try {
      log.info("Updating local council {}.", shortCode);
      LocalCouncilEntityUpdateParams params =
          LocalCouncilEntityUpdateParams.builder()
              .description(localCouncil.getDescription())
              .shortCode(shortCode)
              .json(objectMapper.writeValueAsString(localCouncil.getWelshDescription()))
              .build();
      return sqlSession.update(Statements.UPDATE_LOCAL_COUCIL.getName(), params);
    } catch (JsonProcessingException e) {
      throw new BadRequestException(new Error().reason("Could not serialise meta data."));
    }
  }
}
