<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
</head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<body >
<h1 >
	Welcome to Carneigie Library Of Pittsburgh!  
</h1>

<P align= center>  The current time is ${serverTime}. </P>
<style>
input[type=text]:focus {
    border: 3px solid #555;
    background-color: lightblue;
   
}
input {
    width: 40%;
   
}
h1 {
    color: #667292;
    text-align: center;
}

h3{
 color: #8d9db6;
    text-align: center;
    margin: 0cm 0cm 0cm 0cm;
   

}


</style>


<table style="width:100%">
  <tr>
    <th><img src="logo.jpg" height= 150px; width= 200px;/></th> 
    <th><h3>Know Your Library
Carnegie Library of Pittsburgh (CLP) supports educational attainment, economic development, and cultural enrichment in Pittsburgh.</h3></th>
  </tr>
  </table>




 <h3 align= center> Please your username and password:</h3>
<form action="login.htm" method = "POST" >
<div class="form-group">
<p align= center>
<label >User Name:</label> <input type="text"   name="j_username" />
<br/><br/>
<label >Password:</label> <input  type="password"  name="j_password" />
<br/><br/>
<button type="submit" class = "btn btn-info btn-lg">log in</button> 
</p>

</div>

</form>
</body>

</html>
