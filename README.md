# automation_tesing_account# Calley Teams Automation Test Suite

![Selenium](https://img.shields.io/badge/Selenium-4.10.0-43B02A?logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7.8.0-DD2233)
![Java](https://img.shields.io/badge/Java-17-007396?logo=java)

This repository contains an automated test suite for Calley Teams' web application, covering critical user flows including registration, login, agent management, and CSV upload functionality.

## 📌 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Prerequisites](#-prerequisites)
- [Setup Guide](#-setup-guide)
- [Running Tests](#-running-tests)
- [Test Cases](#-test-cases)
- [Project Structure](#-project-structure)
- [Troubleshooting](#-troubleshooting)
- [Best Practices](#-best-practices)
- [Contributing](#-contributing)

## 🚀 Features

- **End-to-End Test Coverage**:
  - User registration workflow
  - Login authentication
  - Agent creation and management
  - Bulk contact list import via CSV
  
- **Advanced Automation**:
  - Page Object Model (POM) design pattern
  - Data-driven testing with properties files
  - Explicit waits for dynamic content
  - Parallel test execution

## 🛠 Tech Stack

| Component               | Technology                          |
|-------------------------|-------------------------------------|
| Test Framework          | TestNG 7.8.0                       |
| Browser Automation       | Selenium WebDriver 4.10.0          |
| Language                | Java 17                            |
| Build Tool              | Maven                              |
| Dependency Management   | WebDriverManager                   |
| IDE Support            | VS Code with Java Extension Pack   |

## 📋 Prerequisites

Before running the tests, ensure you have:

1. **Java Development Kit (JDK) 17**
   ```bash
   java -version
Apache Maven

bash
mvn -v
VS Code Extensions (if using VS Code):

Java Extension Pack

TestNG for Java

Maven for Java

🛠 Setup Guide
Clone the repository

bash
git clone https://github.com/yourusername/calley-teams-automation.git
cd calley-teams-automation
Configure test data
Edit src/main/resources/data.properties:

properties
registration.url=https://app.getcalley.com/registration.aspx
login.url=https://app.getcalley.com/Login.aspx
valid.email=your_test_email@example.com
valid.password=YourSecurePassword123
csv.path=src/test/resources/SampleFile.csv
Place your test CSV in:

src/test/resources/SampleFile.csv
▶ Running Tests
Run all tests
bash
mvn clean test
Run specific test suite
bash
mvn test -DsuiteXmlFile=testng.xml
Run with different browser
Edit BaseClass.java:

java
// Change to Firefox or Edge if needed
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
📝 Test Cases
Registration Test
Valid registration with Calley Teams plan

Invalid email format validation

Password complexity requirements

Existing email detection

Login Test
Successful login with valid credentials

Authentication failure with invalid credentials

Session persistence validation

Agent Management
Add new agent with valid details

Duplicate agent prevention

Agent list pagination

CSV Import
Standard CSV file upload

Field mapping validation

Large file handling (2000+ records)

📂 Project Structure
calley-teams-automation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/               # Test base classes
│   │   │   └── pompages/           # Page object classes
│   │   └── resources/              # Configuration files
│   └── test/
│       ├── java/                   # Test classes
│       └── resources/              # Test data files
├── target/
│   └── surefire-reports/           # Test reports
├── pom.xml                         # Maven configuration
└── testng.xml                      # TestNG suite config
🐛 Troubleshooting
Common Issues:

Element not found errors:

Verify element locators match current UI

Add explicit waits for dynamic content

Browser compatibility:

java
// In BaseClass.java
WebDriverManager.chromedriver().browserVersion("136").setup();
CSV upload failures:

Verify file path in data.properties

Check CSV column headers match expected format

Debugging Tips:

bash
# Run with debug output
mvn test -X

# Generate HTML report
mvn surefire-report:report
🏆 Best Practices
Locator Strategy:

Prefer relative XPath/CSS over absolute paths

Use semantic attributes like data-testid

Test Design:

java
// Example of data-driven test
@DataProvider(name = "loginData")
public Object[][] loginData() {
  return new Object[][] {
    {"valid@email.com", "ValidPass123", true},
    {"invalid@email.com", "WrongPass", false}
  };
}
Reporting:

Integrated with TestNG reporting

Screenshot on failure capability

🤝 Contributing
Fork the repository

Create your feature branch (git checkout -b feature/your-feature)

Commit your changes (git commit -am 'Add some feature')

Push to the branch (git push origin feature/your-feature)

Open a Pull Request
