<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Librarian's Menu</title>
<style>
div{

color:#667292;

}
</style>
</head>
<div class="head" align = "center">
<table>
<th><img src="librarian.jpg" height= 100px; width= 150px;/></th>
<th><h1>Hello: ${user.userName}</h1></th>
</table>
	
    <h2>Welcome to Carnegie Library</h2>
    <p>Please make your selection below:</p>
 </div>
<body>
<div class="container" align = "center">
  <form method='post' action='librarianMenu.htm'>
        <select name='isselect'>
            <option value='Browse Inventory' >Browse Inventory</option>
            <option value='Add Inventory' >Add Inventory to DataBase</option>
            <option value='Delete Inventory/Event'>Delete Inventory/Event to DataBase</option>
            <option value='Browse Event'>Browse Event</option>
            <option value='Add Event'>Add Event to DataBase</option> 
             <option value='Borrow Inventory/Event'>Help member to borrow inventory</option>
           <!--  <option value='See who wants to go Event' name='browse/participants'>Browse Event</option>    -->           
        </select>
        <br /><br />
        <input type='submit' value='Submit' />
        

    </form>
    <!-- <a href="librarian/addEvent.htm">Sign up for user</a> -->
    </div>

</body>
</html>