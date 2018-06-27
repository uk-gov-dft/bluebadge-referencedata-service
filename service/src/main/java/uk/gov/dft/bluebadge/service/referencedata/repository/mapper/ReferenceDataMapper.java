package uk.gov.dft.bluebadge.service.referencedata.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

@SuppressWarnings("unused")
@Mapper
public interface ReferenceDataMapper {
  List<ReferenceDataEntity> findByDomain(String domainId);
}
