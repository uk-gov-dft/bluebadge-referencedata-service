package uk.gov.dft.bluebadge.service.referencedata.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import uk.gov.dft.bluebadge.common.converter.ToEntityConverter;
import uk.gov.dft.bluebadge.common.converter.ToModelConverter;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceData;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

@Slf4j
public class ReferenceDataConverter
    implements ToEntityConverter<ReferenceDataEntity, ReferenceData>,
        ToModelConverter<ReferenceDataEntity, ReferenceData> {

  @Override
  public ReferenceDataEntity convertToEntity(ReferenceData model) {
    ReferenceDataEntity entity = new ReferenceDataEntity();

    BeanUtils.copyProperties(model, entity);
    return entity;
  }

  @Override
  public ReferenceData convertToModel(ReferenceDataEntity entity) {
    ReferenceData model = new ReferenceData();
    BeanUtils.copyProperties(entity, model, "metaData");
    if (!StringUtils.isEmpty(entity.getMetaData())) {
      ObjectMapper om = new ObjectMapper();
      try {
        Map map = om.readValue(entity.getMetaData(), Map.class);
        model.setMetaData(map);
      } catch (IOException e) {
        log.warn("Failed to load meta data into a Map", e);
      }
    }
    return model;
  }
}
