<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Number OF Inventory To Borrow</title>
<style>
div {
color:#667292;
}

</style>
</head>
<body>

 <div class = "container"  align = "center">
        <form action='member/borrowInventory.htm'  method='POST'>
        <h3>How many books do you want to Borrow?</h3>
         <input name='numBook' required />
         <br />
         <h3>How many movies do you want to Borrow?</h3>
         <input  name='numMovies' required />
         <br />
         <h3>How many music do you want to Borrow?</h3>
         <input  name='numMusic' required />
         <br/>
         <br/>
         <input type="submit" value="Submit">            
        </form>
    </div>
  
</body>
</html>