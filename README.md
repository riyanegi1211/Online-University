# Online-University
Mini Project
Micro Branch
Steps to run on local machine

Configure MySQl
1. add new database name in the following command in place of {DATABASE_NAME}

mysql> CREATE DATABASE {DATABASE_NAME};

2. add previously created username in {USERNAME}. previous user maybe 'newuser'

mysql> GRANT ALL PRIVILEGES ON {DATABASE_NAME}.* TO '{USERNAME}'@'localhost';


3. Add/Change the required details to application.properties in 3 projects in the backend - user, course, enrollment

4. Use spring boot extension to run gateway, user, course, enrollment

5. Authentication and Authorisation is not working in microservices. 

Static credential values are - "admin,admin", "prof,prof", "abc,abc"

Try to dynamically get values from the backend.if getting error, whatsapp.

6. To run the code
```
cd frontend
npm install
ng serve --open
```

```
Open spring boot extension and run 4 microservices - gateway, user, course, enrollment
```

# Current Architecture

![mermaid-diagram-2023-04-03-155201](https://user-images.githubusercontent.com/34604329/229562399-16f5095d-2b83-47f0-b70a-92600cb0b0d2.svg)
