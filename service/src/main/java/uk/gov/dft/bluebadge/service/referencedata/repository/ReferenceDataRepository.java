package uk.gov.dft.bluebadge.service.referencedata.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

/** Provides CRUD operations on UserEntity entity + user management. */
@SuppressWarnings("WeakerAccess")
@Component
public class ReferenceDataRepository {
  private final SqlSession sqlSession;

  public ReferenceDataRepository(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  /**
   * Retrieve a single UserEntity by id.
   *
   * @param id PK of UserEntity to select.
   * @return The retrieved UserEntity.
   */
  /*
  public Optional<UserEntity> retrieveUserById(int id) {
    UserEntity userEntity = this.sqlSession.selectOne("retrieveUserById", id);
    if (null == userEntity) {
      LOGGER.warn("Attempt to retrieve UserEntity id:{} that does not exist.", id);
    }
    return Optional.ofNullable(userEntity);
  }
  */
}
