# Online Banking System

A Java-based console application simulating an online banking system. This project supports both **Administrator** and **Customer** roles, with functionalities for managing customer accounts and transactions. The application connects to a MySQL database for data persistence using JDBC.

## Features

### Admin Portal:
- Login with a username and password.
- Add new customer accounts.
- Update customer details such as address.
- View customer account details or list all customers.
- Delete customer accounts.
- Logout functionality.

### Customer Portal:
- Login with account credentials.
- View account balance.
- Deposit and withdraw money.
- Transfer funds to other customer accounts.
- Logout functionality.

### Database Integration:
- Connects to a MySQL database using JDBC.
- Database credentials are securely managed via the `DatabaseConnection` class.

## Technologies Used
- **Java** for core application logic.
- **MySQL** for database management.
- **JDBC** for database connection and operations.
- **SQL** for database queries.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) installed.
- MySQL server installed.
- MySQL JDBC driver added to your project classpath.

### Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/online-banking-system.git
2. Create a MYSQL database:
    ```bash
   CREATE DATABASE bankingsystem;
3. Update the database credentials in DatabaseConnection.java:
   ```bash
    String url = "jdbc:mysql://localhost:3306/bankingsystem";
    String username = "your_username";
    String password = "your_password";
4. Compile and run the application:
   ```bash
    javac -cp .:mysql-connector-java-8.0.XX.jar com/username/onlinebankingsystem/App.java
    java -cp .:mysql-connector-java-8.0.XX.jar com.username.onlinebankingsystem.App
