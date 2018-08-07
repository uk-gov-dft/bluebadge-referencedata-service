### API Acceptance tests

#### Start the referencedata service

First you need to start the referencedata service by executing following commands

From project root;
```
gradle build
gradle bootRun
```

#### How to run api acceptance tests

From project root;
```
 gradle acceptance-tests:acceptanceTests
```
From acceptance-tests project;
```
 gradle acceptanceTests
```
From IntelliJ;  Right click on AcceptanceTest.java and run as normal.
From Gradle projects in IntelliJ; Open acceptance-tests, acceptancetests and double click on acceptanceTests.
### Relevant Articles: 
- [Test a REST API with Java](http://www.baeldung.com/2011/10/13/integration-testing-a-rest-api/)
- [Introduction to WireMock](http://www.baeldung.com/introduction-to-wiremock)
- [REST API Testing with Cucumber](http://www.baeldung.com/cucumber-rest-api-testing)
- [Testing a REST API with JBehave](http://www.baeldung.com/jbehave-rest-testing)
- [REST API Testing with Karate](http://www.baeldung.com/karate-rest-api-testing)

