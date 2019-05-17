<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegisterPage</title>
<script type ="text/javascript" src="message.js"></script>
</head>
<body bgcolor="#00ff40">
<c:if test="${sessionScope.msg ne null}">
<div>
<center>
<h2>
${sessionScope.msg}
</h2>
</center>
</div>
</c:if>
  
 
<div>
      <form name ="myform" method = post action ="regc" onsubmit="return validateform();">
 <pre>
      Roll Number:<input type="text" name ="rollno">                                 Password:<input type="password" name ="pwd" required>                 Gender: <input type="radio" name="gender" value="male"> Male<input type="radio" name="gender" value="female"> Female<input type="radio" name="gender" value="other"> Other<br>  
                                                                                                                                                                                       
       First Name:<input type="text" name ="fname" required>                                Last Name:<input type="text" name ="lname"><br><br><br>
         Email Id:<input type="text" name ="email" required>                                   Stream:<input type="text" name ="stream" required><br><br><br>
    Date of Birth:<input type="text" name ="dob" required>                           Contact Number:<input type="text" name ="cno" required><br><br><br>
12th School Name:<input type="text" name ="twsname" required>                          12th Percentage:<input type="text" name ="twper" required>                                    12th Passout Year:<input type="text" name ="twpy" required><br><br><br>
 10th School Name:<input type="text" name ="tsname" required>                          10th Percentage:<input type="text" name ="tper" required>                              10th Passout Year:<input type="text" name ="tpy" required><br><br><br>
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
       </div>
</body>
</html>