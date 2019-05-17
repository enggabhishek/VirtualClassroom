<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher Registration Page</title>
<script type ="text/javascript" src="message.js"></script>
</head>
<body bgcolor="#00ff40">
<c:if test="${sessionScope.msg ne null}">
<center>
<h2>
${sessionScope.msg}
</h2>
</c:if>
 </center>
  <form name="myform" method = "post" action ="regtc" onsubmit="return validateform();" >
 <pre>
         Email Id:<input type="text" name ="email" required>                                 Password:<input type="password" name ="pwd" required>                          Gender: <input type="radio" name="gender" value="male"> Male
                                                                                                                                               <input type="radio" name="gender" value="female"> Female
                                                                                                                                               <input type="radio" name="gender" value="other"> Other  
                                                                                                                                                                                       <br>
       First Name:<input type="text" name ="fname" required>                                Last Name:<input type="text" name ="lname"><br><br><br>
          Subject:<input type="text" name ="subject" required>                                   Stream:<input type="text" name ="stream" required><br><br><br>
    Date of Birth:<input type="text" name ="dob" required>                           Contact Number:<input type="text" name ="cno" requuired><br><br><br>                                    
          Address:<input type="text" name ="address" required>                      
          <br>
          <br>
          <br>	
 </pre>
      <center>
      <input type="submit" value="Register" ><br><br>
      <a href="/project/home">Goto_Home</a>
       
      </center>
      </form>
</body>
</html>