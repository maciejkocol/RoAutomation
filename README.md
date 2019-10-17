# Ro Automation Challenge

This readme outlines how to run the Ro automation script that fills out a form and starts an online visit.

## Getting Started

These instructions will guide you on installing and executing Ro automation tests on your local machine.

### Prerequisites

- [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Homebrew](https://brew.sh) or [npm](https://nodejs.org/)

### 1. Clone the project

Locally, at the root directory of your source:

```
git clone https://github.com/maciejkocol/RoAutomation
```
### 2. Install Maven dependency management

```
npm install mvn -g
```
### 3. Install Gauge

Choose method (brew or npm)

**With brew:**

```
brew update
```

```
brew install gauge
```

```
brew install maven
```

**With npm:**

```
npm install -g npm@latest
```

```
npm install -g @getgauge/cli
```
### 4. Install java and html-report for Gauge

**Java language plugin:**

```
gauge install java
```
**Reporting plugin**

```
gauge install html-report
```

### 5. Run the tests

From command line:

```
mvn clean
```

```
mvn test-compile gauge:execute -DspecsDir="specs/StartMyVisit.spec"
```

 or run in headless mode:

```
mvn test-compile gauge:execute -DspecsDir="specs/StartMyVisit.spec" -Denv="ci"
```

From IDEA (e.g. IntelliJ):

- Right click on spec (e.g. StartMyVisit.spec)
- Select 'Run StartMyVisit.spec'

### 6. Reporting

Obtain detailed reports for the tests:

```
./reports/html-report/index.html
```

