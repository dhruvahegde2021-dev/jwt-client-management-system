# Client Management Backend

A Spring Boot backend project that manages clients and their lawyers using REST APIs and PostgreSQL.

## 🚀 Features
- Add client
- Get all clients
- Get client by ID
- Update client
- Delete client

## 🛠 Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL

## 🧠 Architecture
Client → Controller → DTO → Service → Repository → Hibernate → PostgreSQL

## 📌 API Endpoints

### GET all clients
GET /client

### GET client by ID
GET /client/{id}

### POST add client
POST /client

### PUT update client
PUT /client/{id}

## ▶️ How to Run
1. Clone the repo
2. Configure PostgreSQL in application.properties
3. Run the Spring Boot application
4. Test APIs using Postman