package uk.gov.dft.bluebadge.model.referencedata.generated;

import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;

/** LocalAuthority */
@Data
@Builder
@Validated
public class LocalAuthority {
  @NotBlank private String description = null;

  private String welshDescription = null;

  private String nameLine2 = null;

  private String addressLine1 = null;

  private String addressLine2 = null;

  private String addressLine3 = null;

  private String addressLine4 = null;

  private String town = null;

  private String county = null;

  @NotBlank private String postcode = null;

  @NotBlank private String country = null;

  @NotBlank
  @Pattern(regexp = "^(\\s*|ENG|SCO|WLS|NIR)$")
  private String nation = null;

  private String contactNumber = null;

  @NotBlank @URL private String contactUrl = null;

  private String emailAddress = null;

  private String badgePackType = null;

  @Valid
  @DecimalMin("0.0")
  @DecimalMax("999.99")
  private BigDecimal badgeCost = null;

  private Boolean paymentsEnabled = null;

  @URL private String differentServiceSignpostUrl = null;

  private Boolean streamlinedCitizenReapplicationJourneyEnabled = null;
}
