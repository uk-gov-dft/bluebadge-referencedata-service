@referencedata.get
Feature: Verify ref data retrieval

  Background:
    * url baseUrl
    * def result = callonce read('./oauth2.feature')
    * header Authorization = 'Bearer ' + result.accessToken
    * header Accept = jsonVersionHeader

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

  Scenario: Verify retrieve cancellation and replacement reasons
    Given path 'reference-data/BADGE'
    When method GET
    Then status 200
    And match $.data[*] contains {groupShortCode:'REPLACE', shortCode:'UNDELIVER', metaData:null, description:'#notnull',groupDescription:'#string', subgroupShortCode:null, subgroupDescription:null, displayOrder:'#notnull'}
    And match $.data[*] contains {groupShortCode:'REPLACE', shortCode:'STOLE', metaData:null, description:'#notnull',groupDescription:'#string', subgroupShortCode:null, subgroupDescription:null, displayOrder:'#notnull'}
    And match $.data[*] contains {groupShortCode:'REPLACE', shortCode:'LOST', metaData:null, description:'#notnull',groupDescription:'#string', subgroupShortCode:null, subgroupDescription:null, displayOrder:'#notnull'}
    And match $.data[*] contains {groupShortCode:'REPLACE', shortCode:'DAMAGED', metaData:null, description:'#notnull',groupDescription:'#string', subgroupShortCode:null, subgroupDescription:null, displayOrder:'#notnull'}
    And match $.data[*] contains {groupShortCode:'CANCEL', shortCode:'UNDELIVER', metaData:null, description:'#notnull',groupDescription:'#string', subgroupShortCode:null, subgroupDescription:null, displayOrder:'#notnull'}
    And match $.data[*] contains {groupShortCode:'CANCEL', shortCode:'DECEASE', metaData:null, description:'#notnull',groupDescription:'#string', subgroupShortCode:null, subgroupDescription:null, displayOrder:'#notnull'}
    And match $.data[*] contains {groupShortCode:'CANCEL', shortCode:'NOLONG', metaData:null, description:'#notnull',groupDescription:'#string', subgroupShortCode:null, subgroupDescription:null, displayOrder:'#notnull'}
    And match $.data[*] contains {groupShortCode:'CANCEL', shortCode:'REVOKE', metaData:null, description:'#notnull',groupDescription:'#string', subgroupShortCode:null, subgroupDescription:null, displayOrder:'#notnull'}
    And match $.data[*] contains {groupShortCode:'CANCEL', shortCode:'LOST', metaData:null, description:'#notnull',groupDescription:'#string', subgroupShortCode:null, subgroupDescription:null, displayOrder:'#notnull'}
    And match $.data[*] contains {groupShortCode:'CANCEL', shortCode:'STOLE', metaData:null, description:'#notnull',groupDescription:'#string', subgroupShortCode:null, subgroupDescription:null, displayOrder:'#notnull'}
    And match $.data[*] contains {groupShortCode:'CANCEL', shortCode:'DAMAGED', metaData:null, description:'#notnull',groupDescription:'#string', subgroupShortCode:null, subgroupDescription:null, displayOrder:'#notnull'}


