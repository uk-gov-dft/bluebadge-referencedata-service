@update-la-metadata-unauthorized
Feature: Verify LAs metadata could be updated

  Background:
    * url baseUrl
    * def dbConfig = { username: 'developer',  ***REMOVED*** }
    * def DbUtils = Java.type('uk.gov.service.bluebadge.test.utils.DbUtils')
    * def db = new DbUtils(dbConfig)
    * def setup = callonce db.runScript('acceptance-tests-data.sql')
    * def result = callonce read('./oauth2-non-dft-admin.feature')
    * header Authorization = 'Bearer ' + result.accessToken

  Scenario: Verify update metadata for LA
    Given path '/reference-data/authorities/DELETE_1'
    And request {differentServiceSignpostUrl: "http://new_url.com"}
    When method PUT
    Then status 403
