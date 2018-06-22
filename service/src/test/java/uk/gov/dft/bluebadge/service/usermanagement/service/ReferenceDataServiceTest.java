package uk.gov.dft.bluebadge.service.usermanagement.service;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.gov.dft.bluebadge.service.referencedata.repository.ReferenceDataRepository;
import uk.gov.dft.bluebadge.service.referencedata.service.ReferenceDataService;

public class ReferenceDataServiceTest {

  private ReferenceDataService service;

  @Mock private ReferenceDataRepository repository;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    service = new ReferenceDataService(repository);
  }
/*
  @Test
  public void retrieveUserById_ok() {
    // Given the user exists
    UserEntity user = new UserEntity();
    when(repository.retrieveUserById(-1)).thenReturn(Optional.of(user));

    // When retrieving the user then the user is returned
    Assert.assertTrue(user.equals(service.retrieveUserById(-1)));
  }
  */

}
