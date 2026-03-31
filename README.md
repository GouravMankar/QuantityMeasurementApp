# UC16 – RESTful API Implementation with Spring Boot  

**Date:** 2026-03-16  

## Overview  
Transitioned the application from a standalone N-Tier Java project to a modern web application using the **Spring Boot** framework.  

By exposing the Controller layer as **RESTful endpoints**, the system now supports stateless communication over HTTP, allowing various clients (Web, Mobile, CLI) to interact with the quantity measurement service.

## What Was Added  

- **Spring Boot Integration:**  
  Leveraged Spring’s Inversion of Control (IoC) and Dependency Injection to manage the lifecycle of services and repositories.  

- **REST Controllers:**  
  Annotated the Controller layer with `@PostMapping` and `@GetMapping` to map URLs like `/api/quantities/add` and `/api/quantities/convert` to business logic.  

- **JSON Serialization:**  
  Enabled automatic conversion of `QuantityDTO` objects to and from JSON format for standardized data exchange.  

- **Standardized API Responses:**  
  Introduced a `RestResponse<T>` wrapper to maintain consistent success/error responses and HTTP status codes across all APIs.  

- **Spring Validations:**  
  Added input validation to ensure `QuantityDTO` fields (such as non-null values and valid numbers) are verified before reaching the Service Layer.  

## What I Learned  

- **REST Principles:**  
  Learned to design resource-oriented APIs using proper HTTP methods (POST for operations, GET for retrieval).  

- **Statelessness:**  
  Understood how each request contains all necessary information, making the server stateless.  

- **Annotation-Based Configuration:**  
  Gained hands-on experience using Spring annotations like `@Service`, `@Repository`, and `@Autowired` instead of manual object creation.  

- **Web Integration Testing:**  
  Learned how to test APIs using HTTP clients and validate JSON responses.  

## Principles Followed  

- Client-Server Separation  
- Stateless Communication  
- Uniform Interface Design  
- Dependency Inversion Principle (DIP)  
- Security through DTOs (exposing only required data)  