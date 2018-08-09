@referencedata.get.no.auth
Feature: Verify ref data retrieval

  Background:
    * url baseUrl

  Scenario: Verify retrieve all data for a domain
    Given path 'reference-data/BADGE'
    When method GET
    Then status 401