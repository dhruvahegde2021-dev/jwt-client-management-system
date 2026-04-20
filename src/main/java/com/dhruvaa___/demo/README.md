# 🔐 Client Management System (Spring Boot)

## 🚀 Overview

This is a backend application built using Spring Boot that implements secure user authentication using JWT and allows users to manage their own clients.

---

## ✨ Features

* User Registration & Login
* Password Encryption (BCrypt)
* JWT-based Authentication
* Protected APIs
* User-specific data isolation
* CRUD operations for Clients
* Clean API responses using DTOs
* Global Exception Handling

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
2. Password is encrypted and stored
3. User logs in → receives JWT token
4. Token is sent in Authorization header
5. Backend validates token for protected routes

---

## 📌 API Endpoints

### 🔓 Public

* POST /auth/register
* POST /auth/login

### 🔒 Protected

* GET /client
* POST /client
* PUT /client/{id}
* DELETE /client/{id}

---

## 🧪 How to Run

1. Clone the repo
2. Configure database in `application.properties`
3. Run the application
4. Use Postman to test APIs

---

## 📖 What I Learned

* JWT Authentication flow
* Spring Security configuration
* Layered backend architecture
* DTO pattern for clean APIs
* Exception handling in Spring Boot

---

## 🚀 Future Improvements

* Role-based access (Admin/User)
* API documentation (Swagger)
* Logging system
* Refresh tokens

---
