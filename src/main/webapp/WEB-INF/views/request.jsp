<%@ page import = " com.abhi.project.dto.*" %>
<%@ page import = " java.lang.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FriendsRequestList</title>
</head>
<body bgcolor = "yellow">
<c:if test="${sessionScope.rqdto ne null}">
<center>
<table border=2>
<th>Name</th>
<th>Accept</th>
<th>Reject</th>
<c:forEach  items="${sessionScope.rqdto}" var="r">

<tr>
<td><c:out value="${r.name}"></c:out></td>
<td><form method="post" action ="dc">
<input type="hidden" name ="accept" value= "<c:out value="${r.combine}"></c:out>">
<input type="submit" value="Yes">
</form>
</td>
<td><form method="post" action ="dc">
<input type="hidden" name ="reject" value="<c:out value="${r.combine}"></c:out>">
<input type="submit" value="No">
</form>
</td>
</tr>
</table>
<c:if test="${sessionScope.dcmsg ne null}">
<h2>${sessionScope.dcmsg}</h2>
</c:if>
<c:if test="${sessionScope.emsg ne null}">
<h2>${sessionScope.emsg}</h2>
</c:if>
</c:forEach>
</c:if>
<a href="tlogin">Go_to_profile</a>
</center>
</body>
</html>