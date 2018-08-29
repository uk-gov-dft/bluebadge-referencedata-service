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

  Scenario: Verify retrieve all data for a Citizen domain
    Given path 'reference-data/CITIZEN'
    When method GET
    Then status 200
    And match $.data[*].groupShortCode contains ['LA', 'LC', 'NATION']
    And match $.data contains {groupShortCode:"NATION", shortCode:"ENG", metaData:"#notnull", description:"England", groupDescription:"Nation", subgroupShortCode:null, subgroupDescription:null, displayOrder:0}