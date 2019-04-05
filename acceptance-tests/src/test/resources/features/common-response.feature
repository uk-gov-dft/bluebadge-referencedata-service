@common-response
Feature: Verify ref data retrieval

  Background:
    * url baseUrl
    * def result = callonce read('./oauth2.feature')
    * header Authorization = 'Bearer ' + result.accessToken
    * header Accept = jsonVersionHeader

  Scenario: Verify bean validation gives common response wrapped error
    Given path '/reference-data/authorities/DELETE_1'
    And request {"description": null, "postcode": "ABC123", "nation": "invalid", "country": "United Kingdom2", contactUrl:"invalid", "differentServiceSignpostUrl": "invalid", "badgeCost":"1000"}
    When method PUT
    Then status 400
    And match $.error.errors contains {field:"description", reason:"#notnull", message:"NotBlank.localAuthority.description", location:"#null", locationType:"#null"}
    And match $.error.errors contains {field:"nation", reason:"#notnull", message:"#notnull", location:"#null", locationType:"#null"}
    And match $.error.errors contains {field:"contactUrl", reason:"#notnull", message:"#notnull", location:"#null", locationType:"#null"}
    And match $.error.errors contains {field:"differentServiceSignpostUrl", reason:"#notnull", message:"#notnull", location:"#null", locationType:"#null"}
    And match $.error.errors contains {field:"badgeCost", reason:"#notnull", message:"#notnull", location:"#null", locationType:"#null"}