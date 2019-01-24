package uk.gov.dft.bluebadge.service.referencedata.repository.domain;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("LocalAuthorityEntity")
@Data
@Builder
public class LocalAuthorityEntity {
  private String shortCode;
  private String nameLine2;
  private String addressLine1;
  private String addressLine2;
  private String addressLine3;
  private String addressLine4;
  private String town;
  private String county;
  private String postcode;
  private String country;
  private String nation;
  private String contactNumber;
  private String contactUrl;
  private String emailAddress;
  private String badgePackType;
  private BigDecimal badgeCost;
  private String differentServiceSignpostUrl;
}
