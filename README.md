# Simple Selenium BDD Framework (Java)

A **beginner-friendly** Selenium automation framework using:

- Java
- Selenium WebDriver
- Cucumber (BDD)
- JUnit 5
- WebDriverManager
- ExtentReports
- Maven

This project intentionally keeps the framework **simple and clean**.
No dependency injection, no complex driver factory, and no heavy abstractions.

---

## Project Structure

```text
src
 └── test
      ├── java
      │     ├── pages
      │     │     LoginPage.java
      │     │
      │     ├── steps
      │     │     LoginSteps.java
      │     │
      │     ├── hooks
      │     │     Hooks.java
      │     │
      │     └── runner
      │           TestRunner.java
      │
      └── resources
            ├── features
            │     login.feature
            └── extent.properties
```

---

## What This Framework Includes

- Simple Page Object Model (`LoginPage`)
- Cucumber step definitions (`LoginSteps`)
- Cucumber hooks (`Hooks`)
  - `@Before`: browser setup using WebDriverManager
  - `@After`: close browser
- Automatic failure screenshot capture:
  - Attached to Cucumber report
  - Saved in `target/screenshots/`
- Reporting output in `target/reports/`:
  - Cucumber HTML report
  - Cucumber JSON report
  - Extent HTML report
- Sample login scenario for:
  - https://practicetestautomation.com/practice-test-login/

---

## Prerequisites

Install the following on your machine:

1. **Java 17+**
2. **Maven 3.8+**
3. **Google Chrome** (for ChromeDriver)

Check versions:

```bash
java -version
mvn -version
```

---

## Configuration Steps

### 1) Clone and open project

```bash
git clone <your-repo-url>
cd BDD-simple
```

### 2) Verify `pom.xml`

`pom.xml` already contains required dependencies and plugins for Selenium, Cucumber, JUnit 5, WebDriverManager, and ExtentReports.

### 3) No manual driver setup needed

WebDriverManager downloads and manages the correct ChromeDriver automatically inside `Hooks.java`.

### 4) Report configuration

Extent report settings are stored in:

```text
src/test/resources/extent.properties
```

Reports are generated under:

```text
target/reports/
```

Screenshots (on failure) are saved under:

```text
target/screenshots/
```

---

## How to Run Tests

Run all tests with:

```bash
mvn clean test
```

This command will:

1. Start the Cucumber scenario(s)
2. Launch Chrome browser
3. Execute login automation
4. Generate reports automatically

---

## Sample Scenario Covered

Feature file: `src/test/resources/features/login.feature`

Scenario steps:

1. Open login page
2. Enter username `student`
3. Enter password `Password123`
4. Click login
5. Verify message: `Logged In Successfully`

---

## Report Locations After Execution

After `mvn clean test`, check:

- `target/reports/cucumber-report.html`
- `target/reports/cucumber-report.json`
- `target/reports/ExtentReport.html` (inside timestamped report folder when configured by adapter)

If a test fails, screenshot file is available in:

- `target/screenshots/`

---

## How to Add More Tests

### 1) Add a new page class

Create a new class in `src/test/java/pages` with locators and methods.

### 2) Add step definitions

Create a matching step class in `src/test/java/steps`.

### 3) Add new feature file

Create a new `.feature` file in `src/test/resources/features`.

### 4) Re-run

```bash
mvn clean test
```

The runner automatically picks up features from the `features` folder.

---

## Keep It Simple Principles Used

- One straightforward hook class
- One simple page object
- One simple step definition class
- No driver factory pattern
- No DI framework
- No extra service/utility layers

This keeps the framework easy to read, maintain, and extend for beginners.
