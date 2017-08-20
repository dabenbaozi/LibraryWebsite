<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <style> tr:hover {
          background-color: #ffff99;
        }
        
 </style> 
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>      
<tr>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Searched Result</title>
</head>
<body>

		<h2 style="color:#667292" >Event List</h2>
        <table border="1" cellpadding="5" cellspacing="5" class="table table-striped">
            <tr>
                <td><b>eventID </b></td>
                <td><b>FileName </b></td>
                <td><b>poster</b></td>
                <td><b>location</b></td>
                
            </tr>
            <c:forEach var="event" items="${events}">
                <tr>
                    <td>${event.eventID}</td>
                    <td>${event.filename}</td>
                     <td><img height="150" width="150" src="${event.description}" /></td>
                    <td>${event.location}</td>
                </tr>
            </c:forEach>
        </table>
 
</body>
</html>