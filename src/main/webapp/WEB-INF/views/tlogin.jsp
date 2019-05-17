<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher Login Page</title>
</head>
<body bgcolor="#808000">
<pre>
 <form method="post" action ="lgout" >  
 <c:set var ="rmsg" value="You successfully logout from teacher's page" scope="session"></c:set>                                                                                              <input type="submit" value="logout">
 </form>
 <form method ="post" action ="lic">
                                                                                                                                        <input type="submit" value="FriendRequestList">                                                                                                                                                                                                                     
 </form>
</pre>
<center>

<c:if test="${sessionScope.image ne null}">
<img src ="<c:url value="/resources/${sessionScope.image}"/>" alt ="profile">
</c:if>

<c:if test="${ sessionScope.image == null && sessionScope.pic1 ne null }">
<img src ="<c:url value="/resources/${sessionScope.pic1}"/>" alt ="profile">
</c:if>
<center>
<div id = "name">
 <h1 style="font-size:300%;">
      ${sessionScope.user}
 </h1>
</div>
    </center>
    <div>
    <h1>
    <pre>
Email:-${sessionScope.email}            Gender:-${sessionScope.gender}            Stream:-${sessionScope.stream}<br> <br> <br>                     
 Subject:-${sessionScope.subject}           Ratings:-${sessionScope.rates}                  Contact Number:-${sessionScope.cno} <br> <br> <br>
    </pre>
    </h1>
    </div>
  <center>

Upload your image: <br>
</center>

    <form action="tic" modelAttribute="uploadedFile" method="post" enctype="multipart/form-data">    

     <pre>                                                                                    
                        <input type="file" name="file" accept="image/*" required ><br>
  <input type="submit" value="Upload Image" >
</form>                                                                                       
</pre>
<pre>
                   <c:if test="${imsg ne null}">
                  <h3>${imsg}</h3>
       </c:if>            
</pre>
<center>
Upload your files: <br>
 </center>
<form action="tfc" modelAttribute="uploadedFile" method="post" enctype="multipart/form-data">   
        <pre>
                        <input type="file" name="file" required><br>
 <input type="submit" value="Upload File">
</form>
                                                                             <c:if test= "${fmsg ne null}"> 
                                                                                <h3>${fmsg}</h3>
                                                                                       </c:if>        
</pre>
</body>
</html>