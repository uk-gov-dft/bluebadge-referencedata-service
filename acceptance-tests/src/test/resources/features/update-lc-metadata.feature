@update-lc-metadata
Feature: Verify LCs metadata could be updated

  Background:
    * url baseUrl
    * def dbConfig = { username: 'developer',  ***REMOVED*** }
    * def DbUtils = Java.type('uk.gov.service.bluebadge.test.utils.DbUtils')
    * def db = new DbUtils(dbConfig)
    * def setup = callonce db.runScript('acceptance-tests-data.sql')
    * def result = callonce read('./oauth2-dft-admin.feature')
    * header Authorization = 'Bearer ' + result.accessToken

  Scenario: Verify update metadata for LC
    Given path '/reference-data/councils/LC_UPDATE'
    And request {"description" : "updated description", "welshDescription" : "updated welsh description"}
    When method PUT
    Then status 200
    * def updatedLCMeta = db.readValueAsString("select meta_data from referencedata.reference_data la where la.data_group_id = 'LC' and la.code = 'LC_UPDATE'")
    * match updatedLCMeta.welshDescription contains 'updated welsh description'
    * def updatedLC = db.readValueAsString("select description from referencedata.reference_data la where la.data_group_id = 'LC' and la.code = 'LC_UPDATE'")
    * assert updatedLC == 'updated description'

  Scenario: Verify add metadata for LC
    Given path '/reference-data/councils/LC_ADD'
    And request {"description" : "updated description", "welshDescription" : "new welsh description"}
    When method PUT
    Then status 200
    * def updatedLCMeta = db.readValueAsString("select meta_data from referencedata.reference_data la where la.data_group_id = 'LC' and la.code = 'LC_ADD'")
    * match updatedLCMeta.welshDescription contains 'new welsh description'
    * def updatedLC = db.readValueAsString("select description from referencedata.reference_data la where la.data_group_id = 'LC' and la.code = 'LC_ADD'")
    * assert updatedLC == 'updated description'

  Scenario: Verify remove metadata for LC
    Given path '/reference-data/councils/LC_ADD'
    And request {"description" : "updated description", "welshDescription" : null}
    When method PUT
    Then status 200
    * def updatedLCMeta = db.readValueAsString("select meta_data from referencedata.reference_data la where la.data_group_id = 'LC' and la.code = 'LC_ADD'")
    * assert updatedLCMeta.welshDescription == null
    * def updatedLC = db.readValueAsString("select description from referencedata.reference_data la where la.data_group_id = 'LC' and la.code = 'LC_ADD'")
    * assert updatedLC == 'updated description'