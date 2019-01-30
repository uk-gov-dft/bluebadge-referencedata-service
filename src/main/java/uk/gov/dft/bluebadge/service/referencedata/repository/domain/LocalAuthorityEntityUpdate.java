package uk.gov.dft.bluebadge.service.referencedata.repository.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocalAuthorityEntityUpdate {
  String shortCode;
  String localAuthorityInJson;
}
