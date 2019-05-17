<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginPage</title>
</head>
<body bgcolor="#808000">

<pre>
	 <form method="post" action="sc">	    
		Stream     : <select name="st">
			<option value="Computer Science" selected> Computer Science </option>
			<option value="Information Technology"> Information Technology </option>
			<option value="MechanicalEngineering"> Mechanical Engineering </option>
			<option value="Civil Engineering"> Civil Engineering  </option>
			<option value="Electronics & Communications">Electronics & Communications</option>
			<option value="Chemical Engineering">Chemical Engineering </option>
			<option value="Electrical Engineering">Electrical Engineering </option>
			
		</select><br>
			     <input type="submit" value="Search">
	</form>

<c:if test="${sessionScope.teach ne null}" >
<h1 style="font-size:300%;">${sessionScope.teach}</h1>
</c:if>
</pre>
<pre>
 <form action ="lgout" method="post">
 <c:set var ="rmsg" value="You successfully logout from student's page" scope="session"></c:set>
                                                                                                                                                                               <input type="submit" value="logout">
 </form>
</pre>

<center>

<c:if test ="${sessionScope.image ne null}">
<img src = "<c:url value="/resources/${sessionScope.image}"/>" />
</c:if>
<c:if test ="${sessionScope.image == null && sessionScope.pic1 ne null}">
<img src ="<c:url value="/resources/${sessionScope.pic1}"/>"/>
</c:if>
<div id = "name">
 <h1 style="font-size:300%;">
     ${sessionScope.user}
 </h1>
</div>
      </center>
   
   <div>
   
   <h1>
    <pre>
Roll Number:- ${sessionScope.rollno}                 Gender:- ${sessionScope.gender}                         Email:-${sessionScope.email}  <br> <br> <br>                     
Date of Birth :-${sessionScope.dob}                                                                         Stream:-${sessionScope.stream}<br> <br> <br>  
10th School Name:- ${sessionScope.tsname}                   10th percentage:-${sessionScope.tper}                       Year of Passing:-${sessionScope.tpy} <br> <br> <br>          
12th School Name:- ${sessionScope.twsname}                   12th percentage:-${sessionScope.twper}                    Year of Passing:- ${sessionScope.twpy} %><br> <br> <br>    
Contact No:-${sessionScope.cno}                                                                                 Address :- ${sessionScope.address} <br><br> <br>                                                     
  </pre>
  </h1>
  </div> 
  <center>
   Upload your Resume/CV: <br>
   </center>
    
<form action="fc" modelAttribute="uploadedFile" method="post" enctype="multipart/form-data">   
      <pre> 
                                                                                        <input type="file" name="file"accept=".pdf,.docx" ><br>
                                                                                        <input type="submit" value="Upload File">
  </pre>
</form>
                                                                            <c:if test="${fmsg ne null}" >
                                                                                                                        <h3>${fmsg}</h3>
                                                                                               </c:if>
                                                                                               

<center>

Upload your image: <br>
</center>
<form  modelAttribute="uploadedFile" method="post" enctype="multipart/form-data" action="imgc">    
<pre>
                                                                                         
                                                                                       <input type="file" name="file" accept="image/*" ><br>
                                                                                        <input type="submit" value="Upload Image">
</form>                                                                                       
</pre>

                                                                                             <c:if test="${imsg ne null}" >
                                                                                         <h2>${imsg}</h2>
                                                                                         
                                                                                               </c:if>
</body>
</html>