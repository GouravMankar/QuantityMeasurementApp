# UC15 – N-Tier Architecture Refactoring  

**Date:** 2026-03-12 

## Overview  
Refactored the monolithic application into a professional **N-Tier Architecture** by separating concerns into distinct layers: Controller, Service, and Entity/Model.  

This architectural shift transforms the standalone application into a scalable system that follows SOLID principles and industry best practices.

## What Was Added  

- **Application Layer (`QuantityMeasurementApp`):**  
  Serves as the entry point of the application and initiates interaction with the controller.  

- **Controller Layer:**  
  Handles user interactions and delegates requests to the Service Layer. Designed to be easily extendable for REST APIs in future.  

- **Service Layer:**  
  Contains core business logic including comparison, conversion, and arithmetic operations. Communicates with the repository layer for data persistence.  

- **Entity/Model Layer:**  
  Defines structured data representation:  
  - `QuantityDTO` → for data transfer  
  - `QuantityModel` → for internal logic  
  - `QuantityMeasurementEntity` → for persistence  

- **Repository Layer:**  
  Introduced `IQuantityMeasurementRepository` interface with a Singleton-based `CacheRepository` implementation for in-memory storage and file persistence.  

## What I Learned  

- **Separation of Concerns:**  
  Each layer has a clearly defined responsibility, making the system easier to maintain and test.  

- **Design Patterns:**  
  - **Singleton** → Centralized data access  
  - **Factory** → Object creation  
  - **Facade** → Simplified controller interface  

- **Data Transfer Objects (DTO):**  
  Used to decouple internal business logic from external input/output representation.  

- **Interface Segregation Principle (ISP):**  
  Created specific interfaces for services and repositories to allow flexible and replaceable implementations.  

## Principles Followed  

- Single Responsibility Principle (SRP)  
- Open-Closed Principle (OCP)  
- Interface Segregation Principle (ISP)  
- Dependency Injection (DI)  
- N-Tier Layered Architecture  