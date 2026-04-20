# 🔐 JWT Client Management System (Spring Boot)

## 🚀 Overview

This is a secure backend application built using Spring Boot that implements JWT-based authentication and allows users to manage their own clients.
Tested using Postman.
The system ensures that each user can only access and modify their own data, making it a multi-user, secure backend service.

---

## ✨ Features

* 🔐 User Registration & Login
* 🔑 JWT-based Authentication
* 🔒 Protected APIs using Spring Security
* 👥 User-specific data isolation
* 📄 Pagination support for client data
* 🔄 CRUD operations for Clients
* 🧾 Clean API responses using DTOs
* ⚠️ Global Exception Handling
* 🔐 Password Encryption using BCrypt

---

## 🛠 Tech Stack

* Java
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* PostgreSQL
* Maven

---

## 🔐 Authentication Flow

1. User registers with username & password
2. Password is hashed and stored in database
3. User logs in → receives JWT token
4. Token is sent in Authorization header
5. JwtFilter validates token
6. SecurityContextHolder stores authenticated user
7. Service layer uses user info to fetch user-specific data

---

## 📌 API Endpoints

### 🔓 Public APIs

* `POST /auth/register`
* `POST /auth/login`

---

### 🔒 Protected APIs

* `GET /client` → Get clients (paginated)
* `POST /client` → Add client
* `PUT /client/{id}` → Update client
* `DELETE /client/{id}` → Delete client

---

## 📄 Pagination Support (🔥 Highlight Feature)

Clients are returned in a paginated format.

### Example Request:

GET /client?page=0&size=5

---

### Example Response:

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

### ✅ Benefits:

* Efficient data loading
* Scalable for large datasets
* Better performance

---

## 🧪 Example API Flow

### 1. Register

POST /auth/register

```json
{
  "username": "userA",
  "password": "1234"
}
```

---

### 2. Login

POST /auth/login

```json
{
  "username": "userA",
  "password": "1234"
}
```

**Response:**

```json
{
  "token": "eyJhbGciOiJIUzI1Ni..."
}
```

---

### 3. Access Protected API

GET /client

**Header:**

```
Authorization: Bearer <your_token>
```

---

## 👥 User Data Isolation

Each client is linked to a specific user.

### How it works:

* JWT → extracts username
* Backend fetches user from DB
* Client is saved with user reference
* Queries fetch only user’s clients

### Result:

✔ User A sees only their clients
✔ User B sees only their clients

---

## 🧠 Key Concepts Implemented

* JWT Authentication & Authorization
* Spring Security Filter Chain
* SecurityContextHolder usage
* Password hashing (BCrypt)
* DTO pattern for clean APIs
* Global exception handling
* Pagination with Spring Data JPA

---

## 🧱 Project Structure

```
controller/
service/
repository/
entity/
dto/
config/
exception/
```

---

## 🧪 How to Run

1. Clone the repository
2. Configure PostgreSQL in `application.properties`
3. Run the application
4. Use Postman to test APIs

---

## 🚀 Future Improvements

* Role-based access (Admin/User)
* API documentation (Swagger)
* Logging system
* Refresh tokens

---

## 🏆 What I Learned

* Building secure backend systems
* Implementing JWT authentication
* Handling multi-user data safely
* Designing clean API responses
* Structuring scalable backend applications

---
