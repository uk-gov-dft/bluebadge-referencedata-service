package uk.gov.dft.bluebadge.service.referencedata.client.postcodes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostcodeIO {
  private final String postcode;
  @JsonProperty("admin_district")
  private final String adminDistrict;
  private final Codes codes;
  private final String country;

  @Data
  private static class Codes {
    @JsonProperty("admin_district")
    private final String adminDistrict;
  }

  public String getAdminDistrictCode(){
    return codes.getAdminDistrict();
  }
}
