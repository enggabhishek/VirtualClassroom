<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body bgcolor="#2cd3c2">

<center>
<h1  style ="font-size:200%;">Welcome to Virtual Classroom</h1>

 <form method="post" action="lc">
                                                       
                               Username:<input type="text" name="rollno"><br>
	                                      Password:<input type="password" name="pwd"><br><br>
	                                                            
	                                                       <input type="radio" name="option"value="student">Student<input type="radio" name="option" value="teacher">Teacher<br><br>
	                                                                     <input type="submit" value="Login"><br><br><br>
                                                          
                                                             <h1 style="text-align:center;">
                                                             ${hmsg}
                                                             </h1>
                                                       
                                                                                                            																													 
 
 </form>                                                              
                                                                    <h2>Don't have an account!</h2> <br><br><br>
                                                                                                                                  
 <form method="post" action="regserv">                                                                                                               
 
	                                                               <input type="submit" value="Register as Student"><br><br><br>


</form>

<form method="post" action="tregserv">                                                                                                               
 
	                                                               <input type="submit" value="Register as Teacher">


</form>
</center>
</body>
</html>