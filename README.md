# Example using Arquillian

## Running tests
### Via IDE
* enable container profile (wildfly-remote/managed, jboss-remote)
    * for remote adapter you need to start the server before the test
* run ContinenteBDD.java as junit test

### Via maven
 ``` mvn clean test -Pwildfly-managed ```

## Test reports
access test output in /target/cucumber-report/feature-overview.html 

 

![General report](https://github.com/rmpestano/cucumber/blob/arquillian/report1.png?raw=true)

![Detailed report](https://github.com/rmpestano/cucumber/blob/arquillian/report2.png?raw=true)

