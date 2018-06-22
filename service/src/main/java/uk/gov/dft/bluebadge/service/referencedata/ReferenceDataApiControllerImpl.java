package uk.gov.dft.bluebadge.service.usermanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uk.gov.dft.bluebadge.service.referencedata.controller.ReferenceDataApi;
import uk.gov.dft.bluebadge.service.referencedata.service.ReferenceDataService;
import uk.gov.dft.bluebadge.service.usermanagement.service.exception.NotFoundException;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ReferenceDataApiControllerImpl implements ReferenceDataApi {

  private ReferenceDataService service;
  private ObjectMapper objectMapper;
  private HttpServletRequest request;

  @SuppressWarnings("unused")
  @Autowired
  public ReferenceDataApiControllerImpl(
      ObjectMapper objectMapper, HttpServletRequest request, ReferenceDataService service) {
    this.objectMapper = objectMapper;
    this.request = request;
    this.service = service;
  }

  @SuppressWarnings("unused")
  @ExceptionHandler
  public ResponseEntity handleNotFoundException(NotFoundException e) {
    return ResponseEntity.notFound().build();
  }

  /**
   * Retrieve a single user.
   *
   * @param authorityId Authority of user.
   * @param userId PK of user to retrieve
   * @return The User wrapped in a UserResponse
   */
  /*
    @Override
    public ResponseEntity<UserResponse> retrieveUser(
        @ApiParam(value = "ID of the authority.", required = true) @PathVariable("authorityId")
            Integer authorityId,
        @ApiParam(value = "Numeric ID of the user to get.", required = true) @PathVariable("userId")
            Integer userId) {
      UserResponse userResponse = new UserResponse();

      UserEntity userEntity = service.retrieveUserById(userId);
      userResponse.setData(userConverter.convertToData(userEntity, 1, 0, 0));

      return ResponseEntity.ok(userResponse);
    }
  */
}
