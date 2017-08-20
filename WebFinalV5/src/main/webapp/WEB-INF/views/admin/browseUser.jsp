<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Browse User</title>
 <style>tr:hover {
          background-color: #ffff99;
        }
        
 </style> 
</head>
  
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<h2 style="color:#667292" >User List</h2>
	<h3 style="color:#667292" >Browse And Search</h3>
	
	<form name="vinform">  
	<input type="text" name="name" onkeyup="searchInfo()">  
	</form>  
	 
	<span id="myUser"></span> 
	
	<br/><br/>
        <table border="1" cellpadding="5" cellspacing="5" class="table table-striped">
          <thead>
            <tr>
                <td><b>User Id</b></td>
                <td><b>User Name</b></td>
                <td><b>Last Name</b></td>
                <td><b>First Name</b></td>
                <td><b>User Role</b></td>
                <td><b>User Password</b></td>
               <!--   <td><b>User email</b></td>-->
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.userName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.firstName}</td>
                    <td>${user.userRole}</td>
                    <td>${user.userPassword}</td>
                 <!--     <td>${user.email}</td>-->
                    
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br/>

</div> 

 <form action="admin/adminMenu.htm" method = "GET">
 <br/>
<button type="submit" class="btn btn-primary btn-lg">Ajax Search Gets URL</button> 
</form>

<script>  
var request=new XMLHttpRequest();  
function searchInfo(){  
var name=document.vinform.name.value;  
var url="admin/adminMenu.htm?val="+name;  
 
try{  
request.onreadystatechange=function(){  
if(request.readyState==4){  
var val=request.responseText;  
document.getElementById('myUser').innerHTML=val;  
}  
}//end of function  
request.open("GET",url,true);  
request.send();  
}catch(e){alert("Unable to connect to server");}  
}  
</script>  
</body>
</html>