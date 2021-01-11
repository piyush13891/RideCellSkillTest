# RideCell_v1.0

# Tools and Technologies:

Build tool 				: Maven
UI Automation tool		: Selenium Webdriver
API Automation tool		: RestAssured
Programming language	: Java
Unit test framework		: TestNG
Reporting tool			: Extent reports
IDE						: Eclipse Mars

# Pre-requisite:

geckodriver should be placed in root folder.

# How to execute:

1. Extract/pull and import the Eclipse project.
2. Project is designed as Maven project and uses TestNG as testing framework.
3. param.Properties file in Data folder is a configuration file that holds few common configuration details like API base path and URIs. User can make changes according to requirement in this file.
4. Project can be executed multiple ways
	a. Right click on textng.xml file and run as TestNG test
	b. Right click POM.xml and execute as maven goal.
	c. Use cmd to execute testng or maven tests.
	d. Integrate with any CI tool like Jenkins/CircleCI and pass required commands.(Solution is CI ready and can be integrated with jobs with minimal efforts)
6. TestNG reports can be found under test-output folder. ITestListener interface of testNG is implemented here.


	

