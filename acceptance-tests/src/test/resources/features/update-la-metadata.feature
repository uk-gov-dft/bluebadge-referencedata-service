@update-la-metadata
Feature: Verify LAs metadata could be updated

  Background:
    * url baseUrl
    * def dbConfig = { username: 'developer',  ***REMOVED*** }
    * def DbUtils = Java.type('uk.gov.service.bluebadge.test.utils.DbUtils')
    * def db = new DbUtils(dbConfig)
    * def setup = callonce db.runScript('acceptance-tests-data.sql')
    * def result = callonce read('./oauth2-dft-admin.feature')
    * header Authorization = 'Bearer ' + result.accessToken

  Scenario: Verify update metadata for LA
    Given path '/reference-data/authorities/DELETE_1'
    And request {"description": "local authority", "postcode": "ABC123", "nation": "SCO", "country": "United Kingdom2", contactUrl:"http://localhost2", "differentServiceSignpostUrl": "http://new_url.com"}
    When method PUT
    Then status 200
 	* def updatedLA = db.readValueAsString("select meta_data from referencedata.reference_data la where la.data_group_id = 'LA' and la.code = 'DELETE_1'")
    * def updatedLADescription = db.readValueAsString("select description from referencedata.reference_data la where la.data_group_id = 'LA' and la.code = 'DELETE_1'")
    * match updatedLADescription contains 'local authority'
    * match updatedLA.differentServiceSignpostUrl contains 'http://new_url.com'
    * match updatedLA.postcode contains 'ABC123'
    * match updatedLA.nation contains 'SCO'
    * match updatedLA.country contains 'United Kingdom2'
    * match updatedLA.contactUrl contains 'http://localhost2'
    * match updatedLA.emailAddress contains ''

   Scenario: Verify upsert metadata for LA
    Given path '/reference-data/authorities/DELETE_2'
     And request {"description": "local authority", "postcode": "ABC123", "nation": "SCO", "country": "United Kingdom2", contactUrl:"http://localhost2", "differentServiceSignpostUrl": "http://new_url.com"}
    When method PUT
    Then status 200
 	* def updatedLA = db.readValueAsString("select meta_data from referencedata.reference_data la where la.data_group_id = 'LA' and la.code = 'DELETE_2'")
     * def updatedLADescription = db.readValueAsString("select description from referencedata.reference_data la where la.data_group_id = 'LA' and la.code = 'DELETE_1'")
     * match updatedLADescription contains 'local authority'
     * match updatedLA.differentServiceSignpostUrl contains 'http://new_url.com'
     * match updatedLA.postcode contains 'ABC123'
     * match updatedLA.nation contains 'SCO'
     * match updatedLA.country contains 'United Kingdom2'
     * match updatedLA.contactUrl contains 'http://localhost2'
     * match updatedLA.emailAddress contains ''

  Scenario: Verify update metadata for LA (invalid values)
    Given path '/reference-data/authorities/DELETE_1'
    And request {"description": "local authority", "postcode": "ABC123", "nation": "invalid", "country": "United Kingdom2", contactUrl:"invalid", "differentServiceSignpostUrl": "invalid", "badgeCost":"1000"}
    When method PUT
    Then status 400
    And match $.error.errors contains {field:"nation", reason:"#notnull", message:"#notnull", location:"#null", locationType:"#null"}
    And match $.error.errors contains {field:"contactUrl", reason:"#notnull", message:"#notnull", location:"#null", locationType:"#null"}
    And match $.error.errors contains {field:"differentServiceSignpostUrl", reason:"#notnull", message:"#notnull", location:"#null", locationType:"#null"}
    And match $.error.errors contains {field:"badgeCost", reason:"#notnull", message:"#notnull", location:"#null", locationType:"#null"}

  Scenario: Verify update metadata for LA (empty values in mandatory values)
    Given path '/reference-data/authorities/DELETE_1'
    And request {"description": "", "postcode": "", "nation": "", "country": "", contactUrl:"", "differentServiceSignpostUrl": "http://localhost", "badgeCost":"999"}
    When method PUT
    Then status 400
    And match $.error.errors contains {field:"description", reason:"#notnull", message:"#notnull", location:"#null", locationType:"#null"}
    And match $.error.errors contains {field:"postcode", reason:"#notnull", message:"#notnull", location:"#null", locationType:"#null"}
    And match $.error.errors contains {field:"nation", reason:"#notnull", message:"#notnull", location:"#null", locationType:"#null"}
    And match $.error.errors contains {field:"country", reason:"#notnull", message:"#notnull", location:"#null", locationType:"#null"}
    And match $.error.errors contains {field:"contactUrl", reason:"#notnull", message:"#notnull", location:"#null", locationType:"#null"}
