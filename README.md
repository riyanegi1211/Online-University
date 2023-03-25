# Online-University
Mini Project

Steps to run on local machine

Configure MySQl
1. Create new user and database
CREATE USER 'newuser'@'localhost' IDENTIFIED BY 'password';
Query OK, 0 rows affected (0.21 sec)

mysql> CREATE DATABASE database_name CHARACTER SET utf8;
Query OK, 1 row affected, 1 warning (0.05 sec)

mysql> GRANT ALL PRIVILEGES ON database_name.* TO 'newuser'@'localhost';
Query OK, 0 rows affected (0.04 sec)

2. Add the required details to application.properties
3. Run spring boot application


Credentials - admin, admin

endpoints 

POST /api/login - log in 

POST /api/register - register a new user - will get a role of GUEST

GET /api/role - get role of logged in user

POST /api/logout - will return 403 but will logout

GET /api/admin/ - verfies your authority -> return "you are an admin : {USERNAME}"

GET /api/admin/getTeacherList

GET /api/teacher/ -  verfies your authority

GET /api/student/ - verfies your authority
