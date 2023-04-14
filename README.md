# Online University

Online University is a web application that allows students to enroll in courses and view their grades. It is built with Spring Java on the backend and Angular on the frontend. The database is implemented using MySQL.

## Installation

To install the project, follow these steps:

1. Clone the repository: git clone https://github.com/riyanegi1211/Online-University.git
2. Navigate to the project directory: cd online-university
3. Install the backend dependencies: (cd backend/user && ./mvnw install); (cd backend/courses && ./mvnw install); (cd backend/enrollment && ./mvnw install)
4. Install the frontend dependencies: cd frontend && npm install

To set up the MySQL database:

5. Install MySQL if you haven't already: [link](https://dev.mysql.com/downloads/installer/) or brew install mysql
6. Log in to MySQL as the root user: sudo mysql -u root -p
7. Create a new database for the project: CREATE DATABASE online_university;
8. Create a new user for the project: CREATE USER 'wissen_test'@'localhost' IDENTIFIED BY 'password';
9. Grant the user access to the database: GRANT ALL PRIVILEGES ON online_university.* TO 'wissen_test'@'localhost';
10. Exit MySQL: exit

## Usage

To start the microservices, cd into the three microservices and run ./mvnw spring-boot:run in the directory.

To start the frontend server, run cd frontend && ng serve. The frontend server will start on http://localhost:4200.

Before running the server, you'll need to update the application.properties file in the src/main/resources directory in the three microservices with your MySQL database credentials:

    spring.datasource.url=jdbc:mysql://localhost:3306/online_university
    spring.datasource.username=wissen_test
    spring.datasource.password=password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update

You can now navigate to http://localhost:4200 in your web browser to use the application.
