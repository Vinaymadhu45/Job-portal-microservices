🚀 Job Portal Backend – Spring Boot Microservices

📌 Overview
A production-oriented Job Portal backend system built using Spring Boot microservices architecture.
The application is designed with independently deployable services and demonstrates real-world backend
engineering concepts such as service discovery, centralized configuration, API gateway routing,
distributed tracing, and containerized infrastructure.
This project focuses on scalability, observability, and maintainability, rather than UI features.

🧱 System Architecture
The system follows a Spring Cloud microservices architecture with the following components:

API Gateway – Single entry point for all external client requests

Service Registry (Eureka Server) – Enables service discovery and dynamic routing

Config Server – Centralized external configuration management

Independent Microservices – Job, Company, and Review services

PostgreSQL – Relational database for persistent storage

pgAdmin – Database management and monitoring UI

Zipkin – Distributed tracing and request latency analysis

Docker Compose – Orchestration of infrastructure containers

🛠️ Tech Stack

Language: Java

Frameworks: Spring Boot, Spring Cloud

Microservices: API Gateway, Eureka Server, Config Server

Inter-service Communication: REST / OpenFeign

Database: PostgreSQL

Observability: Zipkin

Containers: Docker, Docker Compose

Build Tool: Maven

🧩 Services Overview
Service	Description
api-gateway	Routes incoming requests to appropriate microservices
jobms	Manages job postings and job-related operations
CompanyMS	Manages company profiles and company data
reviewMS	Handles company reviews
Service-Registry	Eureka Server for service discovery
Config-server	Centralized configuration management
PostgreSQL	Relational database
pgAdmin	PostgreSQL administration UI
Zipkin	Distributed tracing system
🐳 Dockerized Infrastructure

The project uses Docker Compose to run infrastructure components:

PostgreSQL database

pgAdmin for database management

Zipkin for distributed tracing

Application services connect to these containers during runtime.

▶️ How to Run the Project
✅ Prerequisites

Java 17 or above

Maven

Docker & Docker Compose

Step 1: Start Infrastructure Containers
docker-compose up -d


This starts:

PostgreSQL

pgAdmin

Zipkin

Step 2: Start Spring Boot Services (Order Matters)

Service-Registry (Eureka Server)

Config-server

jobms

CompanyMS

reviewMS

api-gateway

🌐 Access URLs

Eureka Dashboard: http://localhost:8761

API Gateway: http://localhost:8080

Zipkin UI: http://localhost:9411

pgAdmin: http://localhost:5050

🔍 Key Engineering Highlights

Implemented microservices architecture using Spring Boot and Spring Cloud

Centralized request handling via API Gateway

Enabled dynamic service discovery with Eureka

Externalized configuration using Spring Cloud Config Server

Implemented distributed tracing using Zipkin for cross-service request monitoring

Containerized database and observability tools using Docker Compose

Designed services for scalability and maintainability

🎯 Use Case

This backend system simulates a real-world Job Portal application and demonstrates how
enterprise backend systems are structured and managed in a microservices environment.

👤 Author

Vinay
