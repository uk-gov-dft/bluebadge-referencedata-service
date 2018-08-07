package uk.gov.dft.bluebadge.service.referencedata;

import java.util.ArrayList;
import java.util.List;
import org.mockito.MockitoAnnotations;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

public class ReferenceDataFixture {

  protected List<ReferenceDataEntity> sampleEntityList;
  protected ReferenceDataEntity sampleEntity;

  public ReferenceDataFixture() {
    MockitoAnnotations.initMocks(this);
    sampleEntity = new ReferenceDataEntity();
    sampleEntity.setShortCode("CODE");
    sampleEntityList = new ArrayList<>();
    sampleEntityList.add(sampleEntity);
  }
}
