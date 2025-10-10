# SwiftBank

Learning project that simulates a banking REST API where employees can manage clients and current accounts.

## Technologies

- Java 17
- Spring Boot 3.3.1
- Spring Security with JWT
- Spring Data JPA
- MySQL
- Flyway (database migration)
- Docker Compose

## Features

- **Authentication**: JWT-based login
- **Client Management**: Complete CRUD for account holders
- **Account Management**: CRUD for current accounts
- **Banking Operations**: Deposit, withdrawal and transfer between accounts

## Database Structure

- **holder**: Personal data and address of clients
- **current_account**: Current accounts linked to clients
- **user**: System users for authentication

## How to run

1. Clone the repository
2. Configure MySQL or use Docker Compose
3. Run migrations with Flyway
4. Start the application with `./mvnw spring-boot:run`

## Main endpoints

- `POST /login` - Authentication
- `GET/POST/PUT/DELETE /holder` - Client management
- `GET/POST/PUT/DELETE /current-account` - Account management
- `POST /current-account/{id}/deposit` - Deposit
- `POST /current-account/{id}/withdraw` - Withdrawal
- `POST /current-account/{id}/transfer` - Transfer