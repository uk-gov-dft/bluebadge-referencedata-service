package uk.gov.dft.bluebadge.service.referencedata;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.mockito.MockitoAnnotations;
import uk.gov.dft.bluebadge.model.referencedata.generated.LocalAuthority;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.LocalAuthorityEntity;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

public class ReferenceDataFixture {

  protected static ObjectMapper objectMapper = new ObjectMapper();

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
  public static final String DESCRIPTION = "local authority description";
  public static final String CONTACT_URL = "http://localhost";
  public static final String NATION = "ENG";
  public static final String COUNTRY = "United Kingdom";
  public static final String POSTCODE = "ABC123";
  public static final String LOCAL_AUTHORITY_DESCRIPTION = "North Middlelandshire";
  public static final String PHONE_NUMBER = "+44 795 6 4 192 76";
  public static final String PHONE_NUMBER_TRIMMED = "+447956419276";

  // LocalAuthority
  public static LocalAuthority LOCAL_AUTHORITY_MANDATORY_VALUES_ONLY =
      new LocalAuthority()
          .description(DESCRIPTION)
          .contactUrl(CONTACT_URL)
          .nation(NATION)
          .country(COUNTRY)
          .postcode(POSTCODE);
  public static LocalAuthority LOCAL_AUTHORITY_MANDATORY_VALUES_PLUS_PHONE_NUMBER =
      new LocalAuthority()
          .description(DESCRIPTION)
          .contactUrl(CONTACT_URL)
          .nation(NATION)
          .country(COUNTRY)
          .postcode(POSTCODE)
          .contactNumber(PHONE_NUMBER);

  public static LocalAuthority LOCAL_AUTHORITY_ONE_MANDATORY_VALUE_IS_EMPTY =
      new LocalAuthority().contactUrl(CONTACT_URL).nation(NATION).country(COUNTRY).postcode("");
  public static LocalAuthority LOCAL_AUTHORITY_MANDATORY_VALUES_PLUS_INVALID_VALUE =
      new LocalAuthority()
          .description(DESCRIPTION)
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
          .build();

  public static LocalAuthorityEntity LOCAL_AUTHORITY_ENTITY_MANDATORY_VALUES_PLUS_PHONE_NUMBER =
      LocalAuthorityEntity.builder()
          .contactUrl(CONTACT_URL)
          .nation(NATION)
          .country(COUNTRY)
          .postcode(POSTCODE)
          .contactNumber(PHONE_NUMBER_TRIMMED)
          .build();
}
