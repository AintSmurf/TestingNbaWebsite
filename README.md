# NBA Website Testing with Java and Cucumber
This project demonstrates how to perform automated testing of the NBA website using Java, Cucumber, and JUnit. It provides a structured framework for testing various functionalities of the NBA website

# Table of Contents
* [Prerequisites](#prerequisites)
* [Project Structure](#project-structure)
* [Getting Started](#getting-started)
* [Running Tests](#running-tests)
* [Reporting](#reporting)
* [Contributing](#contributing)

# Prerequisites
Before you begin, ensure you have met the following requirements:

* Java Development Kit (JDK) installed
* Apache Maven installed
* Chrome WebDriver installed and its path configured
* Your favorite Java Integrated Development Environment (IDE)


# Project Structure
The project follows a standard Maven project structure and contains the following key directories:
* src/test/java: Java test classes
* src/test/resources: Cucumber feature files and other test-related resources
* src/main/resources: Configuration files, if needed
  
# Getting Started
Clone this repository to your local machine.

1) Open the project in your preferred Java IDE.

2) Build the project using Maven.

3) download required chrome driver version to src/test/resources/drivers/.

# Running Tests
You can run the tests using the following methods:

* Run Cucumber features directly from your IDE.
* Use Maven to run tests from the command line: mvn test

# Reporting
Test results are configured to generate in HTML format. You can find the reports in the src/test/cucumber-reports directory after running the tests.

# Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow the usual GitHub pull request process.
