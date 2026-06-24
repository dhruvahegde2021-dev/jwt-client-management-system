# JWT Client Management System (Spring Boot)

## Overview

A secure backend application built with Spring Boot that implements JWT-based authentication and allows users to manage their own clients. Tested using Postman. The system ensures that each user can only access and modify their own data, making it a multi-user, secure backend service.

---

## Features

- User Registration & Login
- JWT-based Authentication
- Protected APIs using Spring Security
- User-specific data isolation
- Pagination support for client data
- CRUD operations for Clients
- Clean API responses using DTOs
- Global Exception Handling
- Password Encryption using BCrypt

---

## Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- PostgreSQL
- Maven

---

## Authentication Flow

1. User registers with username and password
2. Password is hashed and stored in the database
3. User logs in and receives a JWT token
4. Token is sent in the `Authorization` header for subsequent requests
5. `JwtFilter` validates the token on each request
6. `SecurityContextHolder` stores the authenticated user
7. Service layer uses the user info to fetch user-specific data

---

## API Endpoints

### Public

| Method | Endpoint | Description |
|---|---|---|
| POST | `/auth/register` | Register a new user |
| POST | `/auth/login` | Login and receive JWT token |

### Protected (require `Authorization: Bearer <token>`)

| Method | Endpoint | Description |
|---|---|---|
| GET | `/client` | Get all clients (paginated) |
| POST | `/client` | Add a new client |
| PUT | `/client/{id}` | Update a client |
| DELETE | `/client/{id}` | Delete a client |

---

## Pagination

Clients are returned in a paginated format for efficient data loading and scalability.

**Request:**
```
GET /client?page=0&size=5
```

**Response:**
```json
{
  "content": [
    {
      "id": 1,
      "name": "Client A1",
      "lawyers": "Harvey"
    }
  ],
  "totalPages": 1,
  "totalElements": 1
}
```

---

## Example API Flow

**1. Register**
```
POST /auth/register
```
```json
{
  "username": "userA",
  "password": "1234"
}
```

**2. Login**
```
POST /auth/login
```
```json
{
  "username": "userA",
  "password": "1234"
}
```
Response:
```json
{
  "token": "eyJhbGciOiJIUzI1Ni..."
}
```

**3. Access a Protected Endpoint**
```
GET /client
Authorization: Bearer <your_token>
```

---

## User Data Isolation

Each client is linked to a specific user in the database. When a request comes in, the backend extracts the username from the JWT, fetches the corresponding user, and scopes all queries to that user's data. This means User A and User B have completely separate client lists with no overlap.

---

## Project Structure

```
src/
├── controller/
├── service/
├── repository/
├── entity/
├── dto/
├── config/
└── exception/
```

---

## How to Run

1. Clone the repository
2. Configure PostgreSQL credentials in `application.properties`
3. Run the application via Maven or your IDE
4. Use Postman to test the API endpoints

---

## Key Concepts Implemented

- JWT Authentication and Authorization
- Spring Security Filter Chain
- `SecurityContextHolder` for storing authenticated users
- Password hashing with BCrypt
- DTO pattern for clean, decoupled API responses
- Global exception handling
- Pagination with Spring Data JPA

---

## Future Improvements

- Role-based access control (Admin / User)
- API documentation with Swagger
- Structured logging
- Refresh token support

---

## What I Learned

- Building secure backend systems from scratch
- Implementing JWT authentication end-to-end
- Handling multi-user data safely with proper isolation
- Designing clean and consistent API responses
- Structuring scalable Spring Boot applications