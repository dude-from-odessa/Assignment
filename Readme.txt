1.	When the code was cloned to IDE working directory, the POM.xml file was checked for errors in the dependencies. Pushing the reload button for Maven to download all the jar files
2.	Finding the error in POM.xml
3.	<groupId>org.apache.maven.plugins</groupId>
Was missed from maven failsafe plugin
4.	I have made new package “runners” in order to keep all runners classes in this package
5.	in pom.xml I have modified the configuration of “maven-surefire-plugin” to include all Runners classes with “Runner” name, what we have in our project.
6.      failsafe plugin was set to <skip>true</skip> instead of surefire plugin
7.      I have created the APIRunner class for API testing, modified cucumber options to locate our step definitions and make the reports for the future usage of framework we need to separate the steps for API testing and UI testing. Tags were added to cucumber options
8.	Starter package was deleted
9.	“utils” package was created
10.	APIsteps package was created to hold all steps for api testing. SearchStepDefenintions class was modified to use APIConstants class (holds all end points and BaseURI for API testing

To create new tests first need to describe user acceptance criteria in post_product.feature with Gherking words, then implement them in SearchStepDefinitions, APIRunner class will
be used as runner for API testing (cucumber options can be modified for specific tags to be executed)
For end points APIConstants to be used, in future aditional class APIPayloadConstants which can be used for storing of body in Json format in order to prepare API requests.
