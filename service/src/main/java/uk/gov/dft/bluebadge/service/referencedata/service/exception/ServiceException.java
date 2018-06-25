package uk.gov.dft.bluebadge.service.referencedata.service.exception;

import uk.gov.dft.bluebadge.model.referencedata.CommonResponse;
import uk.gov.dft.bluebadge.model.referencedata.Error;

class ServiceException extends RuntimeException {
  CommonResponse commonResponse;

  ServiceException() {
    super();
    commonResponse = new CommonResponse();
    Error error = new Error();
    commonResponse.setError(error);
  }

  public CommonResponse getCommonResponse() {
    return commonResponse;
  }
}
