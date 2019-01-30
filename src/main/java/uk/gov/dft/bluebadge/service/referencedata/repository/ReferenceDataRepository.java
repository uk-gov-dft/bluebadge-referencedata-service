package uk.gov.dft.bluebadge.service.referencedata.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.dft.bluebadge.common.api.model.ErrorErrors;
import uk.gov.dft.bluebadge.common.service.exception.BadRequestException;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.LocalAuthorityEntity;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.LocalAuthorityEntityUpdate;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

/** Provides CRUD operations on ReferenceDataEntity. */
@Component
@Slf4j
public class ReferenceDataRepository {
  private final SqlSession sqlSession;
  private ObjectMapper objectMapper;

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
    List<ReferenceDataEntity> referenceDataList = sqlSession.selectList("findByDomain", domainId);

    if (referenceDataList.isEmpty()) {
      log.warn("Attempt findByDomain id:{} resulted in empty list.", domainId);
    }
    return referenceDataList;
  }

  public boolean update(String shortCode, LocalAuthorityEntity la) throws JsonProcessingException {
    String body = objectMapper.writeValueAsString(la);
    LocalAuthorityEntityUpdate localAuthorityUpdateEntity = new LocalAuthorityEntityUpdate();
    localAuthorityUpdateEntity.setShortCode(shortCode);
    localAuthorityUpdateEntity.setJson(body);

    int result = sqlSession.update("updateLAMetaData", localAuthorityUpdateEntity);

    if (result == 1) {
      log.debug("Updated Local Authority with short code: {}.", shortCode);
      return true;
    }

    log.error(
        "Attempt to update Local Authority with short code: {} that does not exist.", shortCode);
    ErrorErrors error = new ErrorErrors();
    error
        .field("shortCode")
        .message("Invalid short code ")
        .reason("There is no Local Authority with given short code:" + shortCode);
    throw new BadRequestException(error);
  }
}
