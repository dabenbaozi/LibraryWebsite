<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Number OF Event To Register</title>
<style>
div {
color:#667292;
}

</style>
</head>
<body>
      <div class = "container"  align = "center">
        <form action='member/registerEvents.htm'  method='POST'>
       
         <h3>How many events do you want to register?</h3>
         <input type='numberEvent' name='numEvents' required />
         <br/>
         <br/>
         <input type="submit" value="Submit">            
        </form>
        </div>
</body>
</html>