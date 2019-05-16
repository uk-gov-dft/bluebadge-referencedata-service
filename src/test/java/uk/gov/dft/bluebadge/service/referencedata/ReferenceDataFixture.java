package uk.gov.dft.bluebadge.service.referencedata;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
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
  public static final String EMAIL_ADDRESS = "test123@mailinator.com";
  public static final String LOCAL_AUTHORITY_DESCRIPTION = "North Middlelandshire";
  public static final String PHONE_NUMBER = "+44 795 6 4 192 76";
  public static final String PHONE_NUMBER_TRIMMED = "+447956419276";
  public static final String WELSH_DESCRIPTION = "Cymraeg";
  public static final String NAME_LINE2 = "name line 2";
  public static final String ADDRESS_LINE1 = "address 1";
  public static final String ADDRESS_LINE2 = "address 2";
  public static final String ADDRESS_LINE3 = "address 3";
  public static final String ADDRESS_LINE4 = "address 4";
  public static final String TOWN = "London";
  public static final String COUNTY = "westminster";
  public static final boolean PAYMENTS_ENABLED = false;
  public static final String CLOCK_TYPE = "WALLET";
  public static final BigDecimal BADGE_COST = new BigDecimal(10.0);
  public static final String DIFFERENT_SERVICE_SIGNPOST_URL = "http://localhost:1111";
  public static final Boolean STREAMLINED_CITIZEN_REAPPLICATION_JOURNEY_ENABLED = Boolean.TRUE;

  // LocalAuthority
  public static LocalAuthority LOCAL_AUTHORITY_MANDATORY_VALUES_ONLY =
      new LocalAuthority()
          .description(DESCRIPTION)
          .contactUrl(CONTACT_URL)
          .nation(NATION)
          .country(COUNTRY)
          .postcode(POSTCODE);
  public static LocalAuthority LOCAL_AUTHORITY_ALL_VALUES =
      new LocalAuthority()
          .postcode(POSTCODE)
          .addressLine1(ADDRESS_LINE1)
          .addressLine2(ADDRESS_LINE2)
          .addressLine3(ADDRESS_LINE3)
          .addressLine4(ADDRESS_LINE4)
          .badgeCost(BADGE_COST)
          .badgePackType(CLOCK_TYPE)
          .contactNumber(PHONE_NUMBER)
          .contactUrl(CONTACT_URL)
          .county(COUNTY)
          .country(COUNTRY)
          .description(DESCRIPTION)
          .differentServiceSignpostUrl(DIFFERENT_SERVICE_SIGNPOST_URL)
          .emailAddress(EMAIL_ADDRESS)
          .nameLine2(NAME_LINE2)
          .nation(NATION)
          .paymentsEnabled(PAYMENTS_ENABLED)
          .streamlinedCitizenReapplicationJourneyEnabled(
              STREAMLINED_CITIZEN_REAPPLICATION_JOURNEY_ENABLED)
          .town(TOWN)
          .welshDescription(WELSH_DESCRIPTION);

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

  public static LocalAuthorityEntity LOCAL_AUTHORITY_ENTITY_ALL_VALUES =
      LocalAuthorityEntity.builder()
          .postcode(POSTCODE)
          .addressLine1(ADDRESS_LINE1)
          .addressLine2(ADDRESS_LINE2)
          .addressLine3(ADDRESS_LINE3)
          .addressLine4(ADDRESS_LINE4)
          .badgeCost(BADGE_COST)
          .clockType(CLOCK_TYPE)
          .contactNumber(PHONE_NUMBER_TRIMMED)
          .contactUrl(CONTACT_URL)
          .country(COUNTRY)
          .county(COUNTY)
          .differentServiceSignpostUrl(DIFFERENT_SERVICE_SIGNPOST_URL)
          .emailAddress(EMAIL_ADDRESS)
          .nameLine2(NAME_LINE2)
          .nation(NATION)
          .paymentsEnabled(PAYMENTS_ENABLED)
          .streamlinedCitizenReapplicationJourneyEnabled(
              STREAMLINED_CITIZEN_REAPPLICATION_JOURNEY_ENABLED)
          .town(TOWN)
          .welshDescription(WELSH_DESCRIPTION)
          .build();
}
