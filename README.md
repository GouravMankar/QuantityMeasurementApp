#  Quantity Measurement Application

A scalable, object-oriented Java application designed to perform 
**measurement comparison, conversion, and arithmetic operations** 
across multiple unit categories such as Length and Weight.

---

##  Project Objective

This project demonstrates how to build a clean, extensible, and type-safe 
measurement system using strong OOP principles and architectural best practices.

The system supports:

-  Equality comparison across compatible units  
-  Unit-to-unit conversion with base unit normalization  
-  Arithmetic operations (addition) across mixed units  
-  Multi-category support (Length, Weight)  
-  Generic architecture using Java Generics and Interfaces  

---

##  Architectural Evolution

The project evolves incrementally across multiple use cases (UC1–UC10), 
starting from basic equality checks and progressing toward a fully 
generic, reusable `Quantity<U>` design.

Key architectural milestones include:

- Encapsulation & Immutability
- DRY (Don't Repeat Yourself) Refactoring
- Enum-based Unit Abstraction
- Separation of Concerns
- Single Responsibility Principle
- Open-Closed Principle
- Interface-driven Generic Design
- Multi-Category Type Safety

---

##  Core Technical Concepts Demonstrated

- Value Objects in Java  
- Overriding `equals()` 
- Floating-point precision handling (`Double.compare`, epsilon tolerance)  
- Enum as behavior carrier  
- Generic programming with bounded type parameters  
- Interface-based abstraction (`IMeasurable`)  
- Compile-time and runtime type safety  
- Immutable domain modeling  

---

## Supported Measurement Categories

### Length Units
- Feet  
- Inches  
- Yards  
- Centimeters  

###  Weight Units
- Kilogram  
- Gram  
- Pound  

---

## Testing Strategy

The application includes comprehensive test using JUnit. 


## Branch-Based Learning Structure

Each branch in this repository represents a focused learning milestone 
progressively improving design, architecture, and scalability.


# UC1 – Feet Measurement Equality

**Date:** 2026-02-20 

## Overview
Implemented value-based equality comparison for `Feet` measurements.

## What Was Added
- `Feet` inner class with immutable `double value`
- Proper `equals()` override using `Double.compare()`
- Null and type safety checks
- Basic test coverage for equality contract

## Principles Followed
- Object-Oriented Design
- Encapsulation
- Immutability
- Unit Testing Best Practices


# UC2 – Feet and Inches Measurement Equality

**Date:** 2026-02-20 

## Overview
Extended equality logic to support `Inches` alongside `Feet`.

## What Was Added
- Separate `Inches` class
- Equality logic for both units
- Static helper methods to reduce `main()` dependency
- Test cases for both classes

## Principles Followed
- Equality Contract
- Type Safety
- DRY awareness (identified violation)
- Clean Test Design


# UC3 – Generic Quantity Class (DRY Refactor)

**Date:** 2026-02-22 

## Overview
Refactored duplicate classes into a single `QuantityLength` class.

## What Was Added
- `LengthUnit` enum
- Base-unit normalization (feet)
- Cross-unit equality and conversion
- Removal of duplicated logic

## Principles Followed
- DRY (Don't Repeat Yourself)
- Single Responsibility Principle
- Encapsulation
- Backward Compatibility


# UC4 – Extended Unit Support

**Date:** 2026-02-22

## Overview
Extended system to support Yards and Centimeters.

## What Was Added
- `YARDS` and `CENTIMETERS` in `LengthUnit`
- New conversion factors
- Multi-unit equality validation
- Additional cross-unit test cases

## Principles Followed
- Open-Closed Principle
- DRY Validation
- Enum Extensibility
- Backward Compatibility


# UC5 – Explicit Unit-to-Unit Conversion

**Date:** 2026-02-23  

## Overview
Introduced explicit conversion API for length units.

## What Was Added
- `convert(value, sourceUnit, targetUnit)` method
- Validation for NaN, Infinity, null units
- Precision handling with epsilon
- Overloaded demonstration methods

## Principles Followed
- API Design Best Practices
- Immutability
- Encapsulation
- Defensive Programming

# UC6 – Addition of Two Length Units

**Date:** 2026-02-23  

## Overview
Implemented arithmetic addition between length measurements.

## What Was Added
- `add()` method for same and cross-unit addition
- Base-unit normalization before addition
- Result returned in first operand’s unit
- Edge-case validations (zero, negative, large values)

## Principles Followed
- Immutability
- Reusability of conversion logic
- Mathematical correctness
- DRY compliance

# UC7 – Addition with Explicit Target Unit

**Date:** 2026-02-23  

## Overview
Enhanced addition logic to support explicit target unit specification.

## What Was Added
- Overloaded `add()` method with target unit
- Private utility method for base-unit arithmetic
- Consistent rounding logic
- Comprehensive unit combination tests

## Principles Followed
- DRY Principle
- API Consistency
- Immutability


# UC8 – Standalone LengthUnit Refactor

**Date:** 2026-02-23  

## Overview
Extracted `LengthUnit` into standalone enum with conversion responsibility.

## What Was Added
- Top-level `LengthUnit` enum
- `convertToBaseUnit()` method
- `convertFromBaseUnit()` method
- Delegation of conversion logic

## What I Learned
- Single Responsibility Principle
- Delegation pattern
- Cohesion vs coupling
- Architectural scalability preparation

## Principles Followed
- SRP
- Separation of Concerns
- Encapsulation
- Backward Compatibility


# UC9 – Weight Category Integration

**Date:** 2026-02-23  

## Overview
Introduced new measurement category: Weight.

## What Was Added
- `WeightUnit` enum (KG, GRAM, POUND)
- `QuantityWeight` class
- Equality, conversion, and addition for weight
- Category type-safety enforcement

## Principles Followed
- Scalability Pattern
- SRP across categories
- Immutability
- Type Safety Enforcement


# UC10 – Generic Quantity<U> with IMeasurable

**Date:** 2026-02-23  

## Overview
Refactored entire system into a single generic `Quantity<U>` class.

## What Was Added
- `IMeasurable` interface
- Generic `Quantity<U extends IMeasurable>` class
- Refactored LengthUnit and WeightUnit to implement interface
- Simplified QuantityMeasurementApp

## What I Learned
- Generic Programming in Java
- Interface-driven architecture
- Type erasure considerations
- Open-Closed Principle in action

## Principles Followed
- DRY (Logic implemented once)
- SRP
- OCP (Open for extension, closed for modification)
- Polymorphism and Delegation


# UC11 – Volume Category Integration

**Date:** 2026-02-24  

## Overview  
Introduced a third measurement category — **Volume** — to validate the scalability of the generic `Quantity<U>` architecture implemented in UC10.

Only a new `VolumeUnit` enum was required. No changes were made to `Quantity<U>`, proving the architecture is truly extensible.

## What Was Added  
- `VolumeUnit` enum (LITRE, MILLILITRE, GALLON)  
- Base unit: LITRE  
- Equality, conversion, and addition support via generic logic  
- Comprehensive unit tests for volume operations 

## Principles Followed  
- OCP (Open for extension, closed for modification)  
- DRY (Logic reused from generic implementation)  
- Type-Safe Generics  
- Separation of Concerns  


# UC12 – Subtraction and Division Operations

**Date:** 2026-02-24  

## Overview  
Extended the `Quantity<U>` class to support **subtraction** and **division**, completing arithmetic capabilities for all supported categories (Length, Weight, Volume).

Subtraction returns a new immutable `Quantity<U>`, while division returns a dimensionless scalar ratio.

## What Was Added  
- `subtract()` method (implicit and explicit target unit)  
- `divide()` method returning `double`  
- Division-by-zero validation  
- Cross-category arithmetic prevention   

## Principles Followed  
- Immutability  
- Defensive Programming  


# UC13 – Centralized Arithmetic Logic (DRY Refactor)

**Date:** 2026-02-24  

## Overview  
Refactored arithmetic methods (`add`, `subtract`, `divide`) to eliminate duplication and enforce the **DRY principle**.

Introduced a centralized private helper method and `ArithmeticOperation` enum to manage operation dispatch cleanly.

## What Was Added  
- `ArithmeticOperation` enum (ADD, SUBTRACT, DIVIDE)  
- `performBaseArithmetic()` helper method  
- Centralized validation method  
- Removal of duplicated validation and conversion logic  

## Principles Followed  
- DRY (Don't Repeat Yourself)  
- SRP (Clear separation of responsibilities)  
- Encapsulation of internal logic  
- Backward Compatibility (All UC12 tests passed unchanged)  


# UC14 – Temperature Category with Selective Arithmetic Support

**Date:** 2026-02-24 

## Overview  
Introduced **Temperature measurement** (Celsius, Fahrenheit) with selective operation support.

Unlike other categories, temperature supports equality and conversion but does not support standard arithmetic operations such as addition, subtraction, or division in meaningful contexts.

This required refactoring the `IMeasurable` interface to support optional arithmetic capabilities.

## What Was Added  
- `TemperatureUnit` enum (CELSIUS, FAHRENHEIT, KELVIN)  
- Non-linear conversion formulas  
- Refactored `IMeasurable` with default methods  
- `SupportsArithmetic` functional interface  
- Operation validation using `UnsupportedOperationException`  
- Arithmetic restriction enforcement in `Quantity<U>`  

## What I Learned  
- Interface Segregation Principle (ISP)  
- Capability-based design
- Backward-compatible interface evolution  

## Principles Followed  
- Interface Segregation Principle  
- Open-Closed Principle  
- Defensive Programming  
- Polymorphic behavior customization  
- Type Safety across categories  

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

# UC17 – Comprehensive Global Exception Handling and Validation  

**Date:** 2026-03-29  

## Overview  
Enhanced the robustness of the RESTful API by implementing **Global Exception Handling** and advanced **Request Validation**.  

This ensures the application returns consistent, user-friendly error responses and prevents invalid data from reaching the business logic layer.

## What Was Added  

- **Global Exception Handler (`@ControllerAdvice`):**  
  Centralized exception handling into a single component to manage errors across the entire application.  

- **Standardized Error Response (`ErrorResponseDTO`):**  
  Created a uniform error response structure including timestamp, HTTP status code, and detailed error messages.  

- **Method Argument Validation:**  
  Used `@Valid` and `@NotNull` annotations to automatically validate incoming `QuantityDTO` requests.  

- **Custom Business Exceptions:**  
  Implemented domain-specific exceptions (e.g., category mismatch) mapped to appropriate HTTP status codes like 400 Bad Request.  

- **Validation Constraint Handling:**  
  Added handling for `MethodArgumentNotValidException` to return field-level validation errors to clients.  

## What I Learned  

- **AOP Concepts:**  
  Learned how `@ControllerAdvice` works globally without adding error handling code in every controller.  

- **HTTP Status Code Mapping:**  
  Understood the importance of returning correct status codes such as 400 (Bad Request), 404 (Not Found), and 500 (Internal Server Error).  

- **Defensive API Design:**  
  Applied validation at the API entry point to ensure data integrity.  

- **Client-Centric Error Reporting:**  
  Improved API usability by providing clear and meaningful error messages instead of raw exceptions.  

## Principles Followed  

- Separation of Concerns (Error handling vs Business logic)  
- Fail-Fast Principle  
- Robustness  
- Standardized Communication Contracts  


# UC18 – Secure API with Spring Security, JWT, and OAuth2  

**Date:** 2026-04-01  

## Overview  
Transformed the application into a production-ready system by implementing a robust security layer.  

The RESTful APIs are now secured using **Spring Security**, ensuring that only authenticated and authorized users can perform operations like measurement, conversion, and accessing history.

## What Was Added  

- **Spring Security Integration:**  
  Configured a security filter chain to intercept and authorize all incoming HTTP requests.  

- **JSON Web Token (JWT):**  
  Implemented stateless authentication using signed JWTs, eliminating the need for server-side sessions.  

- **OAuth2 Authentication:**  
  Enabled third-party login support (e.g., Google, GitHub) for secure authentication using external providers.  

- **Role-Based Access Control (RBAC):**  
  Defined roles such as USER and ADMIN to restrict access to sensitive operations.  

- **Password Encoding:**  
  Used BCrypt hashing to securely store user passwords and protect against attacks.  

## What I Learned  

- **Stateless Security:**  
  Learned how token-based authentication improves scalability in REST APIs.  

- **OAuth2 Flow:**  
  Understood Authorization Code and Implicit flows for secure authentication via external providers.  

- **Security Filter Chain:**  
  Gained knowledge of how filters process requests, extract tokens, and set authentication context.  

- **Cryptographic Signing:**  
  Learned how JWT signatures ensure data integrity and prevent tampering.  

## Principles Followed  

- Principle of Least Privilege  
- Defense in Depth  
- Statelessness  
- Secure Credential Management  
- Standardized Identity Protocols (OAuth2 / OpenID Connect)  