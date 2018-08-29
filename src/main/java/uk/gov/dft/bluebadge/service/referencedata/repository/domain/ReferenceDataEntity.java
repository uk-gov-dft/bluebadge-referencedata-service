package uk.gov.dft.bluebadge.service.referencedata.repository.domain;

import java.io.Serializable;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/** Bean to hold a ReferenceData record. */
@Alias("ReferenceDataEntity")
@Data
public class ReferenceDataEntity implements Serializable {
  private String shortCode;
  private String description;
  private String metaData;
  private String groupShortCode;
  private String groupDescription;
  private String subgroupShortCode;
  private String subgroupDescription;
  private Integer displayOrder;
}
