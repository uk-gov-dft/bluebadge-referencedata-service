@update-lc-metadata-unauthorized
Feature: Verify LCs metadata could NOT be updated

  Background:
    * url baseUrl
    * def result = callonce read('./oauth2-non-dft-admin.feature')
    * header Authorization = 'Bearer ' + result.accessToken
    * header Accept = jsonVersionHeader

  Scenario: Verify update metadata for LC
    Given path '/reference-data/councils/ABC'
    And request {"description": "ABC123"}
    When method PUT
    Then status 403
