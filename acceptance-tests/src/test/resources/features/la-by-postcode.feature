@la.postcode
Feature: Verify retrieving LA by postcode

  Background:
    * url baseUrl
    * def result = callonce read('./oauth2.feature')
    * header Authorization = 'Bearer ' + result.accessToken

  Scenario: Successful retrieval of LA by postcode
    Given path 'reference-data/postcode/M41FS'
    When method GET
    Then status 200
    And match $.data.shortCode contains 'MANC'

  Scenario: Not found when unknown postcode
    Given path 'reference-data/postcode/blah'
    When method GET
    Then status 404
    And match $ contains {error:"#notnull"}
    And match $.error contains {message:"NotFound.Postcode"}
