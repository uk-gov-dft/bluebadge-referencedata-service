package uk.gov.dft.bluebadge.service.referencedata.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import uk.gov.dft.bluebadge.common.converter.ToEntityConverter;
import uk.gov.dft.bluebadge.common.converter.ToModelConverter;
import uk.gov.dft.bluebadge.common.service.exception.InternalServerException;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceData;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

@Slf4j
public class ReferenceDataConverter
    implements ToEntityConverter<ReferenceDataEntity, ReferenceData>,
        ToModelConverter<ReferenceDataEntity, ReferenceData> {

  private final ObjectMapper objectMapper;

  public ReferenceDataConverter(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public ReferenceDataEntity convertToEntity(ReferenceData model) {
    ReferenceDataEntity entity = new ReferenceDataEntity();

    BeanUtils.copyProperties(model, entity, "metaData");
    if (null != model.getMetaData()) {
      try {
        String metaData = objectMapper.writeValueAsString(model.getMetaData());
        entity.setMetaData(metaData);
      } catch (IOException e) {
        throw new InternalServerException(e);
      }
    }
    return entity;
  }

  @Override
  public ReferenceData convertToModel(ReferenceDataEntity entity) {
    ReferenceData model = new ReferenceData();
    BeanUtils.copyProperties(entity, model, "metaData");
    if (!StringUtils.isEmpty(entity.getMetaData())) {
      try {
        Map map = objectMapper.readValue(entity.getMetaData(), Map.class);
        model.setMetaData(map);
      } catch (IOException e) {
        throw new InternalServerException(e);
      }
    }
    return model;
  }
}
