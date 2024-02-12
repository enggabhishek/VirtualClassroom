# <center> Virtual Classroom </center>
In the dynamic landscape of education and technology, the integration of virtual classrooms has become increasingly pivotal, offering a flexible and accessible learning environment. Our Virtual Classroom project is a comprehensive and robust solution developed using cutting-edge technologies such as JAVA, J2EE, HTML, JSP, MySQL, Hibernate, and Spring. This project not only facilitates seamless student-teacher interactions but also incorporates various features for user registration, login, file handling, and friend requests.

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
     
3. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/FileController.java
   - This Java class is a Spring MVC controller handling file uploads, validating them, and saving to a specified location.

4. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/FileValidator.java
   - This Java class is a Spring Validator for UploadedFile, ensuring a non-empty file is selected during form submission.

5. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/FriendController.java
   - The FriendController class is a Java Spring MVC controller handling friend requests, utilizing LoginService for processing and responding to requests.
     
6. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/HomeController.java
    - This Java class defines a Spring MVC controller with methods mapping URLs to JSP views for various registration and login processes.
      
7. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/ImageController.java
    - This Java class defines a Spring MVC controller for handling image uploads, validating files, and interacting with a login service.
      
8. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/ListController.java
    - This Java Controller class handles HTTP requests, checks pending friend requests using LoginService, and displays results using ModelAndView.
      
9. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/LoginController.java
    - This Java Controller class, named LoginController, handles user login requests in a Spring MVC web application, managing session attributes.
      
10. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/LogoutController.java
    - This Java class is a Spring MVC Controller handling a logout request. It invalidates the session and redirects to "lgout.jsp".
      
11. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/RateController.java
    - This Java class is a Spring MVC controller named RateController, handling requests to save teacher ratings. It uses dependency injection.
      
12. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/RegisterController.java
    - This Java class is a Spring MVC Controller for user registration, handling HTTP requests, extracting form data, and processing registration through a service.
      
13. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/RegisterTController.java
    - This Java class is a Spring MVC controller for handling teacher registration requests, interacting with services for validation and processing.
      
14. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/StreamController.java
    - The Java class is a Spring MVC controller named StreamController, handling HTTP requests, checking teachers in a stream, and managing sessions.
      
15. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/TeacherFileController.java
    - This Java class is a Spring MVC controller handling file uploads for teacher registration. It validates, saves files, and updates records.
      
16. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/TImageController.java
    - This Java class is a Spring MVC controller handling file uploads, validating files, and interacting with a login service.
      
30. ### enggabhishek/VirtualClassroom/src/main/java/com/abhi/project/UploadedFile.java
    - Java class "UploadedFile" in package "com.abhi.project" with Spring framework, representing file uploads using MultipartFile, providing getters and setters.

## Resources:
1. ### enggabhishek/VirtualClassroom/src/main/resources/log4j.xml
   - This log4j.xml configuration sets up logging with a console appender, defines log levels for specific packages, and sets root logging to warn.
     
## AppServlet:
1. ### enggabhishek/VirtualClassroom/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml:
   - This Spring MVC servlet.xml file configures the web application, defining controllers, views, data sources, and transaction management using Spring and Hibernate.

## Views:
1. ### enggabhishek/VirtualClassroom/src/main/webapp/WEB-INF/views/home.jsp
   - This JSP file includes taglib declarations, sets session to true, and creates a login/register form for a virtual classroom web application.
     
2. ### enggabhishek/VirtualClassroom/src/main/webapp/WEB-INF/views/lgout.jsp
   - This JSP file defines a page with Java and Spring tags, displaying a logout message from the session and a Home link.
     
3. ### enggabhishek/VirtualClassroom/src/main/webapp/WEB-INF/views/login.jsp
   - This JSP file includes taglib declarations, styling, and HTML forms for a student profile page with image and file uploads.

4. ### enggabhishek/VirtualClassroom/src/main/webapp/WEB-INF/views/rate.jsp
   - This JSP file imports tag libraries, sets session attribute, and displays a page with a link and a message.
     
5. ### enggabhishek/VirtualClassroom/src/main/webapp/WEB-INF/views/register.jsp
   - This JSP file defines a registration page with form elements, utilizing JSTL and Spring tags for functionality and styling.
     
6. ### enggabhishek/VirtualClassroom/src/main/webapp/WEB-INF/views/request.jsp
   - This JSP file imports necessary Java classes and tag libraries, displays a table of friend requests, and handles user responses.
     
7. ### enggabhishek/VirtualClassroom/src/main/webapp/WEB-INF/views/subject.jsp
   - This JSP file imports necessary Java packages, defines a table displaying teacher information, includes rating and request functionalities.
     
8. ### enggabhishek/VirtualClassroom/src/main/webapp/WEB-INF/views/success.jsp
   - This JSP file sets up Java language, JSTL, and Spring tags, displays a success message from the session, and provides a home link.
     
9. ### enggabhishek/VirtualClassroom/src/main/webapp/WEB-INF/views/tlogin.jsp
   - This JSP file includes taglibs for JSTL and Spring, defines a teacher's profile page with logout, image, and file upload functionality.
     
10. ### enggabhishek/VirtualClassroom/src/main/webapp/WEB-INF/views/tregister.jsp
    - This JSP file includes tag libraries for JSTL and Spring, defines a teacher registration form with validation and displays session messages.
      
11. ### enggabhishek/VirtualClassroom/src/main/webapp/WEB-INF/views/message.js
    - The JavaScript file defines a form validation function. It checks email format, password length, and contact number validity before submission.
   
### enggabhishek/VirtualClassroom/pom.xml
- This Maven POM.xml file defines a Java web project with dependencies, plugins, and configurations including Spring, Hibernate, and testing.
