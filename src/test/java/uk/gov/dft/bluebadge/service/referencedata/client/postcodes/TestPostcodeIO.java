package uk.gov.dft.bluebadge.service.referencedata.client.postcodes;

import lombok.Builder;

public class TestPostcodeIO extends PostcodeIO {
  @Builder
  public TestPostcodeIO(
      String postcode, String adminDistrict, String districtCode, String country) {
    super(postcode, adminDistrict, buildCodes(districtCode), country);
  }

  private static Codes buildCodes(String districtCode) {
    return new TestPostcodeIO.Codes(districtCode);
  }

  public static PostcodeIO full() {
    return fullBuilder().build();
  }

  public static TestPostcodeIOBuilder fullBuilder() {
    return TestPostcodeIO.builder()
        .postcode("AB1 C23")
        .adminDistrict("District name")
        .districtCode("District code")
        .country("country");
  }
}
