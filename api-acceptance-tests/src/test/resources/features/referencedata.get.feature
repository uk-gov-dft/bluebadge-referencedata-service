@users-get
Feature: Verify ref data retrieval

  Background:
    * url baseUrl

  Scenario: Verify retrieve all data for a domain
    Given path 'reference-data/BADGE'
    When method GET
    Then status 200
    And match each $.data contains {shortCode:"#notnull"}