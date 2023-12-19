# Publication Project

This project serves as a proof of concept for learning and implementing the concept of a circuit breaker using Resilience4j with Spring Boot.

## Prerequisites

- Java 17
- MongoDB
- Redis

## Technologies Used

- Spring Boot
- Spring Data MongoDB
- Spring Data Redis
- Spring Web
- Resilience4j Circuit Breaker
- Lombok

## Dependencies

This project utilizes Maven for dependency management. The main dependencies include:

- **spring-boot-starter-data-mongodb:** Provides the necessary dependencies for working with MongoDB.
- **spring-boot-starter-data-redis:** Includes the dependencies required for interacting with Redis.
- **spring-boot-starter-validation:** Adds support for validation in Spring Boot applications.
- **spring-boot-starter-web:** Includes dependencies for building web applications with Spring Boot.
- **spring-cloud-starter-circuitbreaker-resilience4j:** Integrates Resilience4j as a circuit breaker for Spring Cloud applications.
- **projectlombok:lombok:** A library that simplifies Java code by providing annotations for common tasks.
- **spring-boot-starter-test:** Contains dependencies for testing in a Spring Boot application.

## Building the Project

To build the project, ensure you have Maven installed and run the following command:

```bash
mvn clean install
```

## Running the Project

After building the project, you can run it using the following command:

```bash
java -jar target/publication-0.0.1-SNAPSHOT.jar
```

## Circuit Breaker Configuration

The project utilizes Resilience4j as the circuit breaker implementation. You can find the configuration in the application properties or YAML file. Adjust the configuration based on your requirements for handling faults and resilience.

## Contributing

Feel free to contribute to this project by opening issues or submitting pull requests.