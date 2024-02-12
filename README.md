## Data Access Object (DAO):
1. ### LoginDAO.java 
   - This Java class, LoginDao, provides data access methods for a Spring-based application using Hibernate ORM for student login authentication and related functionalities.

2. ### LoginTDao.java
   - This Java class, LoginTDao, provides data access methods for a Spring-based application using Hibernate ORM for teacher login authentication and related functionalities.
     
3. ### SaveDao.java
   - The SaveDao class in Java is a Data Access Object (DAO) implementing database operations for student registration and profile updates.
     
4. ### SaveTDao.java
   - The SaveTDao class in Java is a Data Access Object (DAO) implementing database operations for teacher registration and profile updates.
       
## Data Transfer Object (DTO):
1. ### RegistrationDto.java
   - This Java class, "RegistrationDto," represents a Data Transfer Object with fields for student registration information, including personal details and dates.
    
2. ### RegistrationTDto.java
   - The Java class "RegistrationTDto" is a Data Transfer Object with fields representing teacher registration information, facilitating data exchange.

4. ### Request.java
   - This Java class represents a Data Transfer Object (DTO) for a "REQUEST" entity with fields for combining, roll number, email, ratings, and status.
     
5. ### RequestDto.java
   - The Java class "RequestDto" represents a Data Transfer Object with fields for name, email, and combined data for communication.

6. ### Student.java
   - The Java class defines a Data Transfer Object (DTO) for a Student entity with various attributes and corresponding setter/getter methods.
     
7. ### Teacher.java
   - This Java class defines a Data Transfer Object (DTO) for a teacher with fields representing personal information and methods for setting/getting them.
     
## Service:
1. ### LoginService.java
   - This Java class implements various methods for user registration, login, friend requests, image handling, and data validation.
     
## Util:
1. ### Encryption.java
   - The Java class "Encryption" provides a method to hash byte arrays using SHA-256 algorithm for secure password storage.

## Controller:
1. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/DecisionController.java
   - This Java class is a Spring MVC controller for handling decision-related requests, utilizing a 'LoginService' class for processing and managing session scope.
     
2. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/DisplayImage.java
   - This Java class is a Spring MVC controller that serves an image file in response to an HTTP GET request.
     
4. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/FileController.java
   - This Java class is a Spring MVC controller handling file uploads, validating them, and saving to a specified location.

6. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/FileValidator.java
   - This Java class is a Spring Validator for UploadedFile, ensuring a non-empty file is selected during form submission.

8. 
9. fgfg
10. g
11. 
12. 
