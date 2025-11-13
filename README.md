# Order Management System - Spring Boot Application

A demo project to show usages of Copilot Agent - This is damn cool!!

## Overview

This is a **Java Spring Boot** web application for managing orders. It uses an **H2 in-memory database** for data persistence and provides RESTful APIs for CRUD operations on orders.

## Technology Stack

- **Java**: 17
- **Spring Boot**: 3.2.0
- **Build Tool**: Gradle 8.5
- **Database**: H2 (in-memory)
- **Dependencies**:
  - Spring Web
  - Spring Data JPA
  - Spring Boot Actuator (Health endpoints)
  - Lombok
  - Swagger/OpenAPI (springdoc-openapi)
  - H2 Database

## Features

- ✅ RESTful API for order management (Create, Read, Update, Delete)
- ✅ H2 in-memory database with JPA/Hibernate
- ✅ Swagger UI for API documentation
- ✅ Health check endpoints via Spring Actuator
- ✅ H2 Console for database inspection
- ✅ Lombok for reducing boilerplate code

## Prerequisites

- Java 17 or higher
- Gradle 8.5 or higher (or use included Gradle wrapper)

## Building the Project

```bash
# Using Gradle wrapper (recommended)
./gradlew build

# Or using system Gradle
gradle build
```

## Running the Application

```bash
# Using Gradle wrapper
./gradlew bootRun

# Or using system Gradle
gradle bootRun

# Or run the JAR file
java -jar build/libs/order-management-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

## API Endpoints

### Order Management

- **GET** `/api/orders` - Get all orders
- **GET** `/api/orders/{id}` - Get order by ID
- **GET** `/api/orders/status/{status}` - Get orders by status
- **GET** `/api/orders/customer/{customerName}` - Get orders by customer name
- **POST** `/api/orders` - Create a new order
- **PUT** `/api/orders/{id}` - Update an order
- **DELETE** `/api/orders/{id}` - Delete an order

### Example Order JSON

```json
{
  "customerName": "John Doe",
  "productName": "Laptop",
  "quantity": 1,
  "price": 999.99,
  "status": "PENDING"
}
```

## Accessing the Application

### Swagger UI (API Documentation)
- URL: `http://localhost:8080/swagger-ui.html`
- Interactive API documentation and testing interface

### Health Endpoints (Actuator)
- Health Check: `http://localhost:8080/actuator/health`
- Info: `http://localhost:8080/actuator/info`

### H2 Database Console
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:orderdb`
- Username: `sa`
- Password: (leave empty)

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/ordermanagement/
│   │       ├── OrderManagementApplication.java
│   │       ├── controller/
│   │       │   └── OrderController.java
│   │       ├── model/
│   │       │   └── Order.java
│   │       ├── repository/
│   │       │   └── OrderRepository.java
│   │       └── service/
│   │           └── OrderService.java
│   └── resources/
│       └── application.yml
└── test/
    └── java/
        └── com/example/ordermanagement/
            └── OrderManagementApplicationTests.java
```

## Running Tests

```bash
./gradlew test
```

## Configuration

The application configuration is in `src/main/resources/application.yml`:

- Server port: 8080
- H2 database: in-memory (orderdb)
- JPA: DDL auto-update enabled
- Actuator: Health endpoints exposed
- Swagger UI: Enabled

## License

This project is created for demonstration purposes.
