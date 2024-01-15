# Microservices with Spring Boot (Version 2.X)

Welcome to our Microservices project based on Spring Boot, featuring MySQL and MongoDB integration. This repository includes three core services (User, Hotel, Ratings), an API Gateway, and a Config Server, all hosted on GitHub.

## Project Structure

1. **User Service**: Manages user-related functionalities.
2. **Hotel Service**: Handles hotel-related operations.
3. **Ratings Service**: Manages user ratings for hotels.

## Infrastructure

- **API Gateway**: Directs and manages incoming requests to the appropriate services.
- **Config Server**: Centralized configuration management for the entire system.

## Service Registry

All services are registered on the Eureka Server, facilitating seamless service discovery and communication.

## GitHub Repositories

Find the source code for each service and infrastructure component on our GitHub repositories:

1. [User Service](https://github.com/Prasad-RP/Microservice-Hotel-Ratings/tree/master/user-services)
2. [Hotel Service](https://github.com/Prasad-RP/Microservice-Hotel-Ratings/tree/master/hotel-services)
3. [Ratings Service](https://github.com/Prasad-RP/Microservice-Hotel-Ratings/tree/master/rating-services)
4. [Service Registry](https://github.com/Prasad-RP/Microservice-Hotel-Ratings/tree/master/service_registry)
5. [API Gateway](https://github.com/Prasad-RP/Microservice-Hotel-Ratings/tree/master/Api-Gateway)
6. [Config Server](https://github.com/Prasad-RP/Microservice-Hotel-Ratings/tree/master/config-server)

## Getting Started

Follow these steps to set up and run the microservices locally:

1. Clone each repository.
2. Build and run the services in the following order:Service Registry, Config Server , API Gateway, User Service, Hotel Service and Ratings Service.
3. Access the services through the API Gateway.

This project provides a scalable and modular architecture for building microservices using Spring Boot and integrates well with MySQL and MongoDB databases. Explore each service's repository for more detailed instructions and documentation.

## Microservices Security Still WIP
