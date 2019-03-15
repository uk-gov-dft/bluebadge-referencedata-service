package uk.gov.dft.bluebadge.service.referencedata.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.gov.dft.bluebadge.common.service.exception.NotFoundException;
import uk.gov.dft.bluebadge.service.referencedata.client.postcodes.PostcodeIO;
import uk.gov.dft.bluebadge.service.referencedata.client.postcodes.PostcodesIOApiClient;
import uk.gov.dft.bluebadge.service.referencedata.client.postcodes.TestPostcodeIO;
import uk.gov.dft.bluebadge.service.referencedata.repository.ReferenceDataRepository;
import uk.gov.dft.bluebadge.service.referencedata.repository.domain.ReferenceDataEntity;

public class PostcodeServiceTest {

  PostcodeService postcodeService;
  @Mock private PostcodesIOApiClient mockPostcodeIOClient;
  @Mock private ReferenceDataRepository mockRepository;
  private PostcodeIO testPostcodeIO;
  private ReferenceDataEntity laRefData;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    postcodeService = new PostcodeService(mockPostcodeIOClient, mockRepository);

    testPostcodeIO =
        TestPostcodeIO.fullBuilder().postcode("TEST PC").districtCode("D Code").build();
    laRefData = new ReferenceDataEntity();
    laRefData.setShortCode("CODE");
  }

  @Test
  public void findLAByPostcode() {
    when(mockPostcodeIOClient.findPostcode("TEST PC")).thenReturn(testPostcodeIO);
    when(mockRepository.findLAByAdminDistrictCode("D Code")).thenReturn(laRefData);

    ReferenceDataEntity la = postcodeService.findLAByPostcode("TEST PC");

    assertThat(la).isSameAs(laRefData);

    verify(mockPostcodeIOClient).findPostcode("TEST PC");
    verify(mockRepository).findLAByAdminDistrictCode("D Code");
  }

  @Test
  public void findLAByPostcode_whenPostcodeNotFound() {
    when(mockPostcodeIOClient.findPostcode("TEST PC")).thenReturn(null);

    try {
      postcodeService.findLAByPostcode("TEST PC");
      fail("No exception thrown");
    } catch (NotFoundException e) {
      // pass
    }

    verify(mockPostcodeIOClient).findPostcode("TEST PC");
    verifyZeroInteractions(mockRepository);
  }

  @Test
  public void findLAByPostcode_whenFoundPostcodeDoesNotHaveAdminDistrictCode() {
    TestPostcodeIO test_pc =
        TestPostcodeIO.fullBuilder().postcode("TEST PC").districtCode(null).build();
    when(mockPostcodeIOClient.findPostcode("TEST PC")).thenReturn(test_pc);

    try {
      postcodeService.findLAByPostcode("TEST PC");
      fail("No exception thrown");
    } catch (NotFoundException e) {
      // pass
    }

    verify(mockPostcodeIOClient).findPostcode("TEST PC");
    verifyZeroInteractions(mockRepository);
  }

  @Test
  public void findLAByPostcode_whenDistrictCodeNotFound() {
    when(mockPostcodeIOClient.findPostcode("TEST PC")).thenReturn(testPostcodeIO);
    when(mockRepository.findLAByAdminDistrictCode("D Code")).thenReturn(null);

    try {
      postcodeService.findLAByPostcode("TEST PC");
      fail("No exception thrown");
    } catch (NotFoundException e) {
      // pass
    }

    verify(mockPostcodeIOClient).findPostcode("TEST PC");
    verify(mockRepository).findLAByAdminDistrictCode("D Code");
  }
}
