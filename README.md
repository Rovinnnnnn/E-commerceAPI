# E-Commerce Backend

A simple e-commerce backend API built with **Java and Spring Boot**.

## Features

* User registration and login
* JWT authentication
* Product management
* Shopping cart
* Add and remove products from cart
* Order creation

## Technologies

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* MySQL
* Maven
* Lombok
* JWT
* BCrypt

## Structure

The project uses a layered structure:

* Controller
* Service
* Repository
* DTO
* Model

The Controller handles API requests, the Service contains the main logic, and the Repository handles database operations.

## Authentication

Users can register and log in using their email and password.

Passwords are encrypted using BCrypt.

After login, the server generates a JWT token that is used to authenticate protected requests.

## Cart

Users can add products to their cart and remove products from their cart.

The cart is associated with the logged-in user.

## Orders

Users can create orders from the products in their cart.

Orders contain the selected products and are associated with the user.

## Future Improvements

* Payment integration
* Product search and filtering
* Product quantity management
* Role-based authorization

https://roadmap.sh/projects/ecommerce-api
