@referencedata.get
Feature: Verify ref data retrieval

  Background:
    * url baseUrl
    * def result = callonce read('./oauth2.feature')
    * header Authorization = 'Bearer ' + result.accessToken

  Scenario: Verify retrieve all data for a domain
    Given path 'reference-data/BADGE'
    When method GET
    Then status 200
    And match $.data[*].shortCode contains ['PIP', 'PAPER']