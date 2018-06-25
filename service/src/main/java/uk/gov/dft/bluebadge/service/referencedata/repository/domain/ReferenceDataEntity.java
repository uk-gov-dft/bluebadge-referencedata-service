package uk.gov.dft.bluebadge.service.referencedata.repository.domain;

import java.io.Serializable;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/** Bean to hold a ReferenceData record. */
@Alias("ReferenceDataEntity")
@Data
public class ReferenceDataEntity implements Serializable {
  private String categoryId = null;
  private String shortCode = null;
  private String description = null;
  private String subgroupShortCode = null;
  private String subgroupDescription = null;
  private Integer displayOrder = null;
}
