package uk.gov.dft.bluebadge.model.referencedata.generated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class LocalCouncil {
  @Size(max = 100)
  @NotEmpty
  private String description = null;

  @Size(max = 100)
  private String welshDescription = null;
}
