<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rated Successfully</title>
</head>
<body bgcolor ="yellow">
<pre>
<a href="login" style="font-size:200%;">Click_on_Profile</a>
     <h2><c:if test="${sessionScope.msg ne null}">
                ${sessionScope.msg}
           </c:if>
           </h2>  
   </pre>
</body>
</html>