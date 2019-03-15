package uk.gov.dft.bluebadge.service.referencedata.controller.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import uk.gov.dft.bluebadge.common.api.model.CommonResponse;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceData;

@Builder
@Getter
@EqualsAndHashCode
public class SingleReferenceDataResponse extends CommonResponse {
  @JsonIgnore @NonNull private ReferenceData data;
}
