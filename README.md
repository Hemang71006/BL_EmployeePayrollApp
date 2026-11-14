# Employee Payroll App

## Overview

The Employee Payroll App is a Spring Boot-based REST API application developed to manage employee payroll information.

The application provides REST endpoints to create, retrieve, update, and delete employee records. It follows a layered architecture using a Controller layer, Service layer, DTO, and Model classes.

The project is developed incrementally through five use cases (UC1–UC5).

## Use Cases Implemented

### UC1 – REST Controller
- Created REST endpoints using Spring Boot.
- Implemented GET, POST, PUT, and DELETE mappings.
- Configured a common base URL for employee payroll operations.

### UC2 – MySQL Database Connection
- Added Spring Data JPA.
- Configured MySQL database connectivity.
- Configured database properties in `application.properties`.
- Added MySQL Connector/J.

### UC3 – DTO and Model
- Created `EmployeeDTO` to receive employee information.
- Created `EmployeePayrollData` to represent employee payroll details.
- Implemented constructors, getters, and setters.
- Used DTO objects to transfer employee data between the client and application.

### UC4 – Service Layer
- Created `EmployeePayrollService`.
- Moved employee-related business logic from the controller into the service layer.
- Implemented constructor-based dependency injection.
- Used Spring's `@Service` annotation.

### UC5 – In-Memory Storage
- Implemented employee storage using Java `ArrayList`.
- Added automatic employee ID generation.
- Implemented employee creation.
- Implemented retrieval of all employees.
- Implemented retrieval of an employee by ID.
- Implemented employee updates.
- Implemented employee deletion.
- Added handling for employee IDs that do not exist.

## Technologies Used

- Java 21
- Spring Boot 4.1.2
- Spring Web MVC
- Spring Data JPA
- MySQL 8
- Maven
- JUnit 5
- Git and GitHub
- IntelliJ IDEA

## Project Structure

```text
EmployeePayrollApp
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.employeepayrollapp
│   │   │       │
│   │   │       ├── controller
│   │   │       │   └── EmployeePayrollController.java
│   │   │       │
│   │   │       ├── dto
│   │   │       │   └── EmployeeDTO.java
│   │   │       │
│   │   │       ├── model
│   │   │       │   └── EmployeePayrollData.java
│   │   │       │
│   │   │       ├── service
│   │   │       │   └── EmployeePayrollService.java
│   │   │       │
│   │   │       └── EmployeePayrollAppApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│       └── java
│           └── com.example.employeepayrollapp
│               ├── dto
│               │   └── EmployeeDTOTest.java
│               ├── model
│               │   └── EmployeePayrollDataTest.java
│               ├── service
│               │   └── EmployeePayrollServiceTest.java
│               └── EmployeePayrollAppApplicationTests.java
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## REST API Endpoints

Base URL:

```text
http://localhost:8080/employeepayrollservice
```

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/` | Retrieve all employees |
| GET | `/get/{id}` | Retrieve an employee by ID |
| POST | `/create` | Create a new employee |
| PUT | `/update/{id}` | Update an existing employee |
| DELETE | `/delete/{id}` | Delete an employee by ID |

### Sample Employee JSON

```json
{
  "name": "Hemang",
  "salary": 50000
}
```

### Sample API Requests

**Create Employee**

```http
POST /employeepayrollservice/create
Content-Type: application/json
```

**Get All Employees**

```http
GET /employeepayrollservice/
```

**Get Employee by ID**

```http
GET /employeepayrollservice/get/1
```

**Update Employee**

```http
PUT /employeepayrollservice/update/1
Content-Type: application/json
```

```json
{
  "name": "Hemang",
  "salary": 75000
}
```

**Delete Employee**

```http
DELETE /employeepayrollservice/delete/1
```

## Database Configuration

The project includes MySQL connectivity configuration.

Create the database using MySQL:

```sql
CREATE DATABASE payroll_service;
```

Configure the following properties in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/payroll_service
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Set the database credentials in PowerShell:

```powershell
$secure = Read-Host "Enter MySQL password" -AsSecureString
$env:DB_PASSWORD = [System.Net.NetworkCredential]::new("", $secure).Password
$env:DB_USERNAME = "root"
```

**Note:** UC5 currently uses in-memory `ArrayList` storage for employee records. MySQL is configured in the application, but employee CRUD operations are not yet persisted to MySQL. In-memory records are lost when the application restarts.

## Installation and Execution

### Prerequisites

- Java Development Kit (JDK) 21
- MySQL Server 8
- Git
- IntelliJ IDEA or another Java IDE

### Clone the Repository

```bash
git clone https://github.com/Hemang71006/BL_EmployeePayrollApp.git
```

### Navigate to the Project

```bash
cd BL_EmployeePayrollApp
```

### Build the Project

For Windows PowerShell:

```powershell
.\mvnw.cmd clean compile
```

### Run Tests

```powershell
.\mvnw.cmd test
```

### Start the Application

```powershell
.\mvnw.cmd spring-boot:run
```

The application runs on:

```text
http://localhost:8080
```

## Testing

The project includes unit tests for:

- EmployeeDTO constructors, getters, and setters.
- EmployeePayrollData constructors, getters, and setters.
- Employee creation.
- Employee retrieval.
- Employee updates.
- Employee deletion.
- Invalid employee ID handling.

Tests can be executed using:

```powershell
.\mvnw.cmd test
```

## Git Branching Strategy

The project follows a feature-branch development workflow.

Main branches:

- `main` – Main project branch.
- `develop` – Integration branch.

Feature branches:

- `feature/UC1-RestController`
- `feature/UC2-DatabaseConnection`
- `feature/UC3-DTOModel`
- `feature/UC4-ServiceLayer`
- `feature/UC5-InMemoryStorage`

Each use case is developed in its respective feature branch and merged into `develop`.

## Author

**Hemang**

Bridgelabz Java Training Project

## Repository

[BL_EmployeePayrollApp – GitHub](https://github.com/Hemang71006/BL_EmployeePayrollApp)