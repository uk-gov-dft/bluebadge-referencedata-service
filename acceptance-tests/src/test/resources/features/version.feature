@version
Feature: Verify incorrect version fails

  Background:
    * url baseUrl
    * def result = callonce read('./oauth2.feature')
    * header Authorization = 'Bearer ' + result.accessToken

  Scenario: Verify 406 when mismatched versions
    * header Accept = 'application/vnd.bluebadge-api.v0+json, application/json'
    Given path 'reference-data/postcode/M41FS'
    When method GET
    Then status 406
    And match $.apiVersion contains '#notnull'

  Scenario: Verify 406 when missing header
    Given path 'reference-data/postcode/M41FS'
    When method GET
    Then status 406
    And match $.apiVersion contains '#notnull'

  Scenario: Verify OK when matching header and version in common response
    * header Accept = jsonVersionHeader
    Given path 'reference-data/postcode/M41FS'
    When method GET
    Then status 200
    And match $.apiVersion contains '#notnull'
