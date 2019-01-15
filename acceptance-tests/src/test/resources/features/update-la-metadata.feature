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
    And request {differentServiceSignpostUrl: "http://new_url.com"}
    When method PUT
    Then status 200
 	* def updatedLA = db.readValueAsString("select meta_data from referencedata.reference_data la where la.data_group_id = 'LA' and la.code = 'DELETE_1'")
	* match updatedLA contains 'http://new_url.com'
 
   Scenario: Verify upsert metadata for LA
    Given path '/reference-data/authorities/DELETE_2'
    And request {differentServiceSignpostUrl: "http://new_url.com"}
    When method PUT
    Then status 200
 	* def updatedLA = db.readValueAsString("select meta_data from referencedata.reference_data la where la.data_group_id = 'LA' and la.code = 'DELETE_2'")
	* match updatedLA contains 'http://new_url.com'
 