# googlekeeptestautomation

Test Automation framework that runs tests on basic functionalities of "https://keep.google.com/"

Prerequisites - 

1. Firefox Version -  53.0.2
2. Java  Version -  jdk1.8.0_121
3. Apache Maven - apache-maven-3.5.0
4. Gecko Driver Settings : Download "geckodriver.exe" from https://github.com/mozilla/geckodriver/releases 
                           Add GeckoDriver path in googlekeeptestautomation/src/test/java/com/test/automation/testBase/TestBase.java
                           
5. This project could be executed using testNG.xml file which has all the test execution settings.
Below are the steps to execute the testNG.xml file from an IDE or from terminal.

# From IDE:

  a. git clone Project to local
	
  b. Open the project in any Java-compatible IDE such as IntelliJ/Eclipse
	
  c. Import the dependencies using pom.xml
	
  d. Go to testNG.xml > Right-click > Run testNG.xml

# From Terminal:

  a. Git clone Project to local
	
  b. cd ProjectDirectory 
	
  c. Run command
     
     mvn clean test -DsuiteXmlFile=testng.xml