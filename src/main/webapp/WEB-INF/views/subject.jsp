<%@ page import = " com.abhi.project.dto.*" %>
   <%@page import ="com.abhi.project.util.*" %>
   <%@page import ="java.sql.*" %>
   <%@page import ="java.util.*" %>
    <%@ page import = " java.lang.*" %>
    <%@page import = "org.hibernate.Query" %>
    <%@page import = "org.hibernate.Session" %>
    <%@page import = "org.hibernate.SessionFactory" %>
    <%@page import = "org.hibernate.Transaction" %>
    <%@page import = "org.hibernate.cfg.Configuration"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher Portal</title>
</head>
<body bgcolor="yellow">
<center>
<table border=2>
<th>Name</th>
<th>Gender</th>
<th>Subject</th>
<th>Contact No.</th>
<th>Email</th>
<th>File</th>
<th>Rate Teacher</th>
<th>Request</th>
<th>Status</th>
<th>Teacher's Rating</th>
<c:forEach  items="${trdto}" var="p">
<tr>
<td> <c:out value="${p.fname}"></c:out></td>
<td><c:out value="${p.gender}"></c:out> </td>
<td><c:out value="${p.subject}"></c:out> </td>
<td><c:out value="${p.cno}"></c:out></td>
<td><c:out value="${p.email}"></c:out></td>
<c:if test="${p.status=='accept'}">
<td><a href="<c:url value='/resources/${p.file}'/>" download>file</a></td>
<c:set var= "rollno" value= "rollno" scope="session" />
<td>	<form method="post" action="rc">
<input type= "hidden"  name = "tmail" value= "<c:out value="${p.email}"></c:out>">	    
		    <select name="numbers">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select><br>
			      <input type="submit" value="rate">
	</form>
</td>
</c:if>
<c:if test="${p.status ne'accept'}">
<td>NULL</td>
<td>NULL</td>
</c:if>
<form action ="frc" method="post">
<input type= "hidden"  name = "tmail" value= "<c:out value="${p.email}"></c:out>">
<td><input type ="submit"  value ="Send"> </td>
</form>
<td>${p.status}</td>
<td><c:out value="${p.ratings}"></c:out></td>
</c:forEach>
</tr>
</table>
</center>
<pre>
    <a href="login" style="font-size:200%;">Click_on_Profile</a>
       
</pre>
<pre>
                  <c:if test="${sessionScope.lmsg ne null}" >
                   <h2>${sessionScope.lmsg}</h2>
                                                                                         
               </c:if>
               </pre>
</body>
</html>