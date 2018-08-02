package uk.gov.dft.bluebadge.service.referencedata.repository;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
}
