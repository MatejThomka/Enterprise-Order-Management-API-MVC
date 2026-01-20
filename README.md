<h2 align="center"><img src="https://img.icons8.com/fluency/24/007bff/settings.png"/> Enterprise Order Management API (MVC)</h2>

<p align="center">
  A clean, enterprise-style Spring Boot 3 MVC API with PostgreSQL & Liquibase — fully Dockerized for consistent local development environments.
</p>

---

## <img src="https://img.icons8.com/fluency/24/ffbb00/info.png"/> Overview

This project models a simplified **enterprise order management domain** to demonstrate  
real-world backend design patterns and clean Spring Boot MVC architecture.

It demonstrates a real-world backend service architecture featuring:

- **Java 21 + Spring Boot (MVC)**  
- **PostgreSQL as primary datastore**
- **Liquibase database schema migrations**
- **REST API with DTO mapping**
- **API documentation via Swagger UI / OpenAPI**
- **Containerized app (Docker + Docker Compose)**
- Cleanly separated controller → service → repository -> model layers

The goal is to showcase clean code practices, maintainability, and modern Spring Boot conventions.

---

## <img src="https://img.icons8.com/fluency/24/007bff/settings.png"/> Tech Stack

- Java 21  
- Spring Boot — MVC (blocking stack)
- Spring Data JPA
- Spring Validation
- PostgreSQL
- Liquibase migrations
- springdoc-openapi + Swagger UI
- Maven
- Docker + Docker Compose
- **Google Java Format** for code style
- **ArchUnit (optional)** for enforcing architecture rules

---

## <img src="https://img.icons8.com/fluency/24/00c853/database.png"/> Database & Migrations

### PostgreSQL
Default connection parameters:
- DB name: `enterprise_api`
- Username: `demo`
- Password: `demo`

### Liquibase
- All schema changes tracked in `src/main/resources/db/changelog`
- `db.changelog-master.xml` drives incremental migrations
- No manual DB changes required — schema evolves automatically on startup

---

## <img src="https://img.icons8.com/fluency/24/api.png"/> API Documentation (Swagger UI)

Swagger UI is automatically enabled through **springdoc-openapi**.

After startup, open:

👉 **http://localhost:8080/swagger-ui.html**

You can:
- Explore available endpoints  
- Inspect request/response models  
- Execute API calls directly in the browser  

---

## <img src="https://img.icons8.com/fluency/24/00e676/container-truck.png"/> Run with Docker

### 1️⃣ Build the application
```bash
mvn clean package -DskipTests
```
### 2️⃣ Launch with Docker Compose
```bash
docker compose up
```
This will:
- Start PostgreSQL
- Start Spring Boot app
- Apply Liquibase migrations automatically

## <img src="https://img.icons8.com/fluency/24/folder-tree.png"/> Project Structure
```text
src
 └── main
     ├── java/com/example.demo
     │     ├── controller
     │     ├── model
     │     ├── dto
     │     ├── service
     │     ├── repository
     │     └── config
     └── resources
           ├── application.yml
           └── db/changelog/** (Liquibase)
```

## <img src="https://img.icons8.com/fluency/24/test-passed.png"/> Testing

Run all Unit Tests:
```bash
mvn clean test
```
Future improvements:
- TestContainers for DB integration tests
- ArchUnit for enforcing architecture rules

## <img src="https://img.icons8.com/fluency/24/rocket.png"/> Roadmap

Exception-handling layer with unified error responses
Role-based security extension (JWT roles)
Maven module extraction demo
GitHub Actions CI

## <img src="https://img.icons8.com/fluency/24/license.png"/> License

MIT (recommended) — or omit if repository stays private.
