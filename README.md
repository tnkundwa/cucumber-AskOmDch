# AskOmDch Cucumber Automation

This is a UI test automation project I built for the AskOmDch application using Cucumber and Selenium.

The project uses Cucumber feature files to describe the test scenarios and Java step definitions to automate them.

## What is covered

The current features include:

* Login
* Create Account
* Browse by Category
* Filter by Price
* Add to Cart
* Checkout

## Technologies

* Java
* Cucumber
* Gherkin
* Selenium WebDriver
* JUnit
* Maven

## Project Structure

The main test code is organized into:

```text
src/test
├── java/awesomecucumber
│   ├── context
│   ├── factory
│   ├── hooks
│   ├── pages
│   ├── runners
│   ├── stepdef
│   └── utils
│
└── resources/features
```

The feature files contain the scenarios, while the step definitions and page classes contain the automation code.

## Running the Tests

Clone the repository and run:

```bash
mvn clean test
```

## About

I built this project to practice BDD with Cucumber and browser automation with Selenium, while learning how to organize UI automation using feature files, step definitions, page objects, and reusable test components.

## Author

Toussaint Nkundwa

GitHub: https://github.com/tnkundwa
