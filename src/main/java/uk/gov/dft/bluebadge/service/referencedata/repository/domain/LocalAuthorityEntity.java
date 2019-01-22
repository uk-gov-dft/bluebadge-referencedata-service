package uk.gov.dft.bluebadge.service.referencedata.repository.domain;

import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("LocalAuthorityEntity")
@Data
@Builder
public class LocalAuthorityEntity {

  private String shortCode;
  private String differentServiceSignpostUrl;
}
