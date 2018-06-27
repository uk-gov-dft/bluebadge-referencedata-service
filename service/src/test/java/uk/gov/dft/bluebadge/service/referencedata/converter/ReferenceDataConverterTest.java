package uk.gov.dft.bluebadge.service.referencedata.converter;

import java.lang.reflect.Field;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.dft.bluebadge.model.referencedata.generated.ReferenceData;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

public class ReferenceDataConverterTest {

  private static final Logger log = LoggerFactory.getLogger(ReferenceDataConverterTest.class);

  private ReferenceDataConverter converter = new ReferenceDataConverter();

  @Test
  public void convertToEntity() throws IllegalAccessException {
    ReferenceData model = new ReferenceData();
    // Given a fully populated Entity
    model.setShortCode("CODE");
    model.setDescription("DESC");
    model.setGroupShortCode("CAT");
    model.setGroupDescription("Group Desc");
    model.setSubgroupDescription("SUBDESC");
    model.setSubgroupShortCode("SUB");
    model.setDisplayOrder(1);

    // When entity populates a model object
    ReferenceDataEntity entity = converter.convertToEntity(model);

    // Then the model object is fully populated
    Assert.assertTrue(checkNoNulls(entity));
  }

  @Test
  public void convertToModel() throws IllegalAccessException {
    ReferenceDataEntity entity = new ReferenceDataEntity();
    // Given a fully populated Entity
    entity.setShortCode("CODE");
    entity.setDescription("DESC");
    entity.setGroupShortCode("CAT");
    entity.setGroupDescription("Group Desc");
    entity.setSubgroupDescription("SUBDESC");
    entity.setSubgroupShortCode("SUB");
    entity.setDisplayOrder(1);

    // When entity populates a model object
    ReferenceData model = converter.convertToModel(entity);

    // Then the model object is fully populated
    Assert.assertTrue(checkNoNulls(model));
  }

  private boolean checkNoNulls(Object toCheck) throws IllegalAccessException {
    for (Field f : toCheck.getClass().getDeclaredFields()) {
      f.setAccessible(true);
      if (f.get(toCheck) == null) {
        log.error(f.getName() + " is null");
        return false;
      }
    }
    return true;
  }
}
