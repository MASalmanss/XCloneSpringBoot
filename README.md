# XCloneSpirngBoot

XCloneApp is a Twitter clone application that aims to provide similar functionalities to the Twitter platform.

## Features
- User authentication using JWT (JSON Web Tokens)
- Posting tweets with support for likes
- Docker Compose setup for easy PostgreSQL database management

## Technologies Used
- **Docker Compose**: For containerizing and managing PostgreSQL database.
- **JWT (JSON Web Tokens)**: For handling user authentication.
- **PostgreSQL**: The relational database used to store user and tweet data.
- **Maven**: For project management and build automation.

## Getting Started

### Prerequisites
Make sure you have the following installed on your machine:
- Docker & Docker Compose
- Java (JDK 11+)
- Maven

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/XCloneApp.git
   cd XCloneApp
   ```
   ```bash
   docker-compose up -d
   ```
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   
2. **Access the application**
Once the project is running, you can access it from your browser at:
  http://localhost:3000

3. **API Documentation**

Swagger/OpenAPI documentation is available at:
  http://localhost:3000/swagger-ui.html



   


