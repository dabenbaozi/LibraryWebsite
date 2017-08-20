<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a User</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script>

function f()
{
var booking_email = document.getElementById("email").value;
if(booking_email == '' || booking_email.indexOf('@') == -1 || booking_email.indexOf('.') == -1) {alert("invalid email");}
else{
	document.getElementById("deleteConfirmed").disabled=false;}

	
}

	



</script>

<style>
.form-control-inline {
    min-width: 0;
    width: 30%;
    display: inline;
}


 
</style>

</head>
<body>

<div class="container" align = "center">
<form action="admin/addUser.htm" method="post" class="form-inline" >
<!-- required="required" pattern="[A-Za-z0-9]{1,20}" -->
<br/>
User Name: <input name="userName"   /><br/>
<br/>
Password: <input name="userPassword"  /><br/>
<br/>
First Name: <input name="firstName" /><br/>
<br/>
Last Name: <input name="lastName" /><br/>
<br/>
Email: <input name="email" id = "email"/><br/>


<br/>
Role:  <select name='roleSelected' class="form-control  form-control-inline" >
            <option value='Admin'>Admin</option>
            <option value='Librarian'>Librarian</option>
            <option value='LibraryMember' >Library Member</option>
       </select>
<br/><br/>
<button type="button" class="btn btn-primary btn-lg active" onClick="f()" name = 'btnSubmit'>Check e-mail validation</button>
<button type = 'submit' ID = "deleteConfirmed"  class="btn btn-primary btn-lg" disabled="disabled">Create User</button>
</form>
</div>
</body>

</html>