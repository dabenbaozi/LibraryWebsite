<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member's Menu</title>
</head>

<style>
div{

color:#667292;

}
</style>
<div class="head" align = "center">
<table>
<th><img src="user.jpg" height= 150px; width= 150px;/></th>
<th><h1>Hello: ${signedUser.userName}</h1></th>
</table>
    <h2>Welcome to Carnegie Library</h2>
    <p>Please make your selection below:</p>
 <!--    <input type = "hidden" value=${user}> -->
</div>
<body>
<div class="body" align = "center">
  <form method='post' action='memberMenu.htm'>
        <select name='isselect'>
            <option value='Browse My Events'>Browse My Events</option>
            <option value='Browse My Book&Medias'>Browse My Book&Medias</option>
            <option value='Browse All available Events'>Browse All available Events</option>
            <option value='Browse All available Book&Medias' >Browse All available Book&Medias</option>   
        </select>
        <br /><br />

        <input type='submit' value='Submit' />
    </form>
</div>
</body>
</html>