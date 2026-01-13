

# App: Spring Boot + MySQL Demo

This project is a **Spring Boot 3.2.2** application designed to demonstrate the integration of **Spring Data JPA** with a **MySQL** database, using **Thymeleaf** for server-side rendering.

---

## 🚀 Technologies Used

* **Java 21**: Configured as the source version for the project.
* **Spring Boot 3.2.2**: The core framework for the application.
* **Spring Data JPA**: For database ORM and repository management.
* **MySQL Connector**: Runtime driver for MySQL connectivity.
* **Thymeleaf**: Server-side template engine for web rendering.
* **Spring Web**: Used for building RESTful APIs and MVC controllers.
* **Maven Wrapper**: Includes scripts to run Maven without requiring a manual local installation.

---

## 📋 Prerequisites

Before running this project, ensure you have:

* **Java Development Kit (JDK) 21** installed.
* **MySQL Server** running on `localhost:3306` (or as configured below).

---

## 🛠️ Configuration

The application is configured to connect to a MySQL database named `mydb`. These settings are located in `src/main/resources/application.properties`:

```properties
spring.application.name=App
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root

# JPA / Hibernate Settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

```

---

## 🏃 How to Run

You can run the application using the provided Maven Wrapper scripts.

### On Windows (CMD/PowerShell):

```bash
.\mvnw.cmd spring-boot:run

```

### On Linux/macOS:

```bash
# Ensure the script is executable first
chmod +x mvnw
./mvnw spring-boot:run

```

---

## 📂 Project Structure

* **`pom.xml`**: Manages dependencies including Web, Thymeleaf, JPA, and MySQL.
* **`mvnw` / `mvnw.cmd**`: Shell and PowerShell scripts for the Maven Wrapper.
* **`.gitignore`**: Excludes build artifacts (`target/`), IDE settings (`.idea`, `.vscode`, `.settings`), and Maven Wrapper JARs from version control.
* **`.classpath` / `.project**`: Configuration files for Eclipse/STS development environments.

---

## 🧪 Development Features

* **Spring Boot DevTools**: Enabled for automatic restarts and faster development cycles.
* **SQL Logging**: `spring.jpa.show-sql=true` is enabled to log Hibernate's generated SQL queries to the console for easier debugging.

---
