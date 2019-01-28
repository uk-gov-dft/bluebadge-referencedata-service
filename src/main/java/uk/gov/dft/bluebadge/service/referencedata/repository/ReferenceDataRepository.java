package uk.gov.dft.bluebadge.service.referencedata.repository;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.dft.bluebadge.common.api.model.ErrorErrors;
import uk.gov.dft.bluebadge.common.service.exception.BadRequestException;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.LocalAuthorityEntity;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

/** Provides CRUD operations on ReferenceDataEntity. */
@Component
@Slf4j
public class ReferenceDataRepository {
  private final SqlSession sqlSession;

  @Autowired
  public ReferenceDataRepository(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
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

  public boolean update(LocalAuthorityEntity la) {

    int result = sqlSession.update("updateLAMetaData", la);

    if (result == 1) {
      log.debug("Updated Local Authority with short code: {}.", la.getShortCode());
      return true;
    }

    log.warn(
        "Attempt to update Local Authority with short code: {} that does not exist.",
        la.getShortCode());
    ErrorErrors error = new ErrorErrors();
    error
        .field("shortCode")
        .message("Invalid short code ")
        .reason("There is no Local Authority with given short code:" + la.getShortCode());
    throw new BadRequestException(error);
  }
}
