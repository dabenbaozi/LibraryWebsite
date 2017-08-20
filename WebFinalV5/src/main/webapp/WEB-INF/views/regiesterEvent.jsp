<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action='addSuccessfully.htm' method='POST'><!-- /HW5_P2/addSuccessfully.htm -->
        <h1>Add Book Info:</h1>
        <table border=1  class="table table-hover">
        <tr>
            <th width=40%>EventId</th>
        </tr>
       
        <c:out value=" ${numEvents}"/>
        <c:forEach var="i" begin="1" end= "${{numEvents}">
            <tr><td><input type='text' name='EventId'></td>
            </tr>
        </c:forEach>
            </table><br /><br />
            
            <button type = submit name = sumbit/>
            </form>
</body>
</html>