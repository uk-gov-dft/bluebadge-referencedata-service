package uk.gov.dft.bluebadge.service.referencedata.converter;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceData;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

public class ReferenceDataConverterTest {

  private ObjectMapper objectMapper = new ObjectMapper();
  private ReferenceDataConverter converter = new ReferenceDataConverter(objectMapper);

  @Test
  public void convertToEntity() throws IllegalAccessException {
    ReferenceData model = new ReferenceData();
    // Given a fully populated Entity
    model.setShortCode("CODE");
    model.setDescription("DESC");
    model.setMetaData(ImmutableMap.of("bob", "jane"));
    model.setGroupShortCode("CAT");
    model.setGroupDescription("Group Desc");
    model.setSubgroupDescription("SUBDESC");
    model.setSubgroupShortCode("SUB");
    model.setDisplayOrder(1);

    // When entity populates a model object
    ReferenceDataEntity entity = converter.convertToEntity(model);

    // Then the model object is fully populated
    assertThat(entity).hasNoNullFieldsOrProperties();
  }

  @Test
  public void convertToModel() throws IllegalAccessException {
    ReferenceDataEntity entity = new ReferenceDataEntity();
    // Given a fully populated Entity
    entity.setShortCode("CODE");
    entity.setDescription("DESC");
    entity.setMetaData(("{\"bob\": \"jane\"}"));
    entity.setGroupShortCode("CAT");
    entity.setGroupDescription("Group Desc");
    entity.setSubgroupDescription("SUBDESC");
    entity.setSubgroupShortCode("SUB");
    entity.setDisplayOrder(1);

    // When entity populates a model object
    ReferenceData model = converter.convertToModel(entity);

    assertThat(model).hasNoNullFieldsOrProperties();
  }
}
