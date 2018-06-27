package uk.gov.dft.bluebadge.service.referencedata.converter;

import org.springframework.beans.BeanUtils;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceData;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

public class ReferenceDataConverter implements BiConverter<ReferenceDataEntity, ReferenceData> {

  @Override
  public ReferenceDataEntity convertToEntity(ReferenceData model) {
    ReferenceDataEntity entity = new ReferenceDataEntity();
    BeanUtils.copyProperties(model, entity);
    return entity;
  }

  @Override
  public ReferenceData convertToModel(ReferenceDataEntity entity) {
    ReferenceData model = new ReferenceData();
    BeanUtils.copyProperties(entity, model);
    return model;
  }
}
