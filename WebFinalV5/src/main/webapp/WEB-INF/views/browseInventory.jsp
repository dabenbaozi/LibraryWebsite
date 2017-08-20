<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <style>tr:hover {
          background-color: #ffff99;
        }
        
 </style>   
 
 
   
<title>Browse Inventory</title>
</head>

<body>

<div id="HTMLtoPDF">
	<h2 style="color:#667292" >Inventory List</h2>
  <table border="1" cellpadding="5" cellspacing="5" class="table table-striped" >
            <tr>
                <td><b>Inventory Id</b></td>
                <td><b>User Holds Inventory</b></td>
                <td><b>Inventory Availability</b></td>
                <td><b>Inventory Type</b></td>
                <td><b>Inventory Name</b></td>
            </tr>
            <c:forEach var="inventory" items="${inventoryList}">
                <tr>
                    <td>${inventory.inventoryID}</td>
                    <td>${inventory.user}</td> 
                    <td>${inventory.available}</td>  
                    <td>${inventory['class']}</td>
                    <td>${inventory.title}</td>     
                </tr>
            </c:forEach>
        </table>

</div> 

<button value = "Print List" onClick="HTMLtoPDF()" class="btn btn-primary btn-lg active">Print List</button>


<script src="jspdf.js"></script>
<script src="jquery-2.1.3.js"></script>
<script src="pdfFromHTML.js"></script>
</body>
</html>