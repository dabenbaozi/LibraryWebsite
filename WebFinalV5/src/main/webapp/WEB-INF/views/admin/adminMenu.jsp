<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin's Menu</title>
</head>
<div class = "title" align="center">
<table>
<th><img src="admin.jpg" height= 150px; width= 150px;/></th>
<th><h1>Hello Admin!</h1></th>
</table>
	
    <h2>Welcome to Carnegie Library</h2>
    <p>Please make your selection below:</p>
    
</div>    
<style>
h1 {
    padding:0;
    margin:0;
   }
   
div{

color:#667292;

}


</style>    
<body >
<div class="body" align = "center" > 
  <form method='POST' action='admin/adminMenu.htm'  >
        <select class="dropdown-menu" name='isselect' >
            <option value='BrowseUser'>Browse User</option>
            <option value='AddAUser'>Add A User</option>
            <option value='DeleteUser' >Delete a User</option>
        </select>
        <br /><br />
        <input type='submit' value='Submit'  />
    </form>
 </div>
  </body>
</html>