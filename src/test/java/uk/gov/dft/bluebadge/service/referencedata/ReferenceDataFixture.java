package uk.gov.dft.bluebadge.service.referencedata;

import java.util.ArrayList;
import java.util.List;
import org.mockito.MockitoAnnotations;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalAuthority;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.LocalAuthorityEntity;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

public class ReferenceDataFixture {

  protected List<ReferenceDataEntity> sampleEntityList;
  protected ReferenceDataEntity sampleEntity;

  public ReferenceDataFixture() {
    MockitoAnnotations.initMocks(this);
    sampleEntity = new ReferenceDataEntity();
    sampleEntity.setShortCode("CODE");
    sampleEntityList = new ArrayList<>();
    sampleEntityList.add(sampleEntity);
  }

  // Field constants
  public static final String SHORTCODE = "ABC";
  public static final String CONTACT_URL = "http://localhost";
  public static final String NATION = "ENG";
  public static final String COUNTRY = "United Kingdom";
  public static final String POSTCODE = "ABC123";

  // LocalAuthority
  public static LocalAuthority LOCAL_AUTHORITY_MANDATORY_VALUES_ONLY =
      new LocalAuthority()
          .contactUrl(CONTACT_URL)
          .nation(NATION)
          .country(COUNTRY)
          .postcode(POSTCODE);
  public static LocalAuthority LOCAL_AUTHORITY_ONE_MANDATORY_VALUE_IS_EMPTY =
      new LocalAuthority().contactUrl(CONTACT_URL).nation(NATION).country(COUNTRY).postcode("");
  public static LocalAuthority LOCAL_AUTHORITY_MANDATORY_VALUES_PLUS_INVALID_VALUE =
      new LocalAuthority()
          .contactUrl(CONTACT_URL)
          .nation(NATION)
          .country(COUNTRY)
          .postcode(POSTCODE)
          .differentServiceSignpostUrl("INVALID");

  // LocalAuthorityEntity
  public static LocalAuthorityEntity LOCAL_AUTHORITY_ENTITY_MANDATORY_VALUES_ONLY =
      LocalAuthorityEntity.builder()
          .contactUrl(CONTACT_URL)
          .nation(NATION)
          .country(COUNTRY)
          .postcode(POSTCODE)
          //.shortCode(SHORTCODE)
          .build();
}
