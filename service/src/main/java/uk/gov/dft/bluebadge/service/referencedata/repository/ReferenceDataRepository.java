package uk.gov.dft.bluebadge.service.referencedata.repository;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

/** Provides CRUD operations on ReferenceDataEntity. */
@Component
@Slf4j
public class ReferenceDataRepository {
  private final SqlSession sqlSession;

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
    List<ReferenceDataEntity> referenceDataList =
        this.sqlSession.selectList("findByDomain", domainId);

    if (referenceDataList.size() == 0) {
      log.warn("Attempt findByDomain id:{} resulted in empty list.", domainId);
    }
    return referenceDataList;
  }
}
