# Employee Ledger Application in Java with Angular frontend.

This project illustrates CRUD operations on an Employee entity using mySQL database for storing of data and a frontend created using Angular.

Steps for setting up mySQL. Follow the below steps in mySWL client.
1. Create a mySQL database named employeerepository.
create database employeerepository;
2. Create a user named springuser.
create user 'springuser'@'%' identified by 'ThePassword';
3. Grant permissions to springuser. 
grant all on employeerepository.* to 'springuser'@'%';
All permissions are granted so that relations can be created if they dont exist initially. Fewer permissions can be given if relations already exist.
