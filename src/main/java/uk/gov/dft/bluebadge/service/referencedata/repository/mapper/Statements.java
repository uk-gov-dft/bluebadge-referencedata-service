package uk.gov.dft.bluebadge.service.referencedata.repository.mapper;

public enum Statements {
  UPDATE_LOCAL_COUCIL("updateLCMetaData"),
  UPDATE_LOCAL_AUTHORITY("updateLAMetaData"),
  FIND_BY_DOMAIN("findByDomain"),
  FIND_LA_BY_LC_ADMIN_DISTRICT("findLAByLCAdminDistrictCode");

  private String name;

  Statements(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
