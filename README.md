# Employee Ledger Application in Java with Angular frontend.

This project illustrates CRUD operations on an Employee entity using mySQL database for storing of data and a frontend created using Angular.

I. Steps for setting up mySQL. Follow the below steps in mySQL client.
1. Create a mySQL database named employeerepository.

        create database employeerepository;

2. Create a user named springuser.

        create user 'springuser'@'%' identified by 'ThePassword';

3. Grant permissions to springuser. 

        grant all on employeerepository.* to 'springuser'@'%';

All permissions are granted so that relations can be created if they dont exist initially. Fewer permissions can be given if relations already exist.

II. To run the Project, follow following steps:
1. Start mySQL server, if not already running.

2. Launch the Java Project, by running following command from command prompt (from project directory). This will start our backend.

        mvnw spring-boot:run
        
3. Launch the angular frontend.

   (i) Change directory:
        
        cd Angular\employeeledger
        
   (ii) Run the front-end
   
        ng serve --open
