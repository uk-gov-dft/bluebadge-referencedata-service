package uk.gov.dft.bluebadge.service.referencedata.repository.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocalCouncilEntityUpdateParams {
  String shortCode;
  String description;
  String json;
}
