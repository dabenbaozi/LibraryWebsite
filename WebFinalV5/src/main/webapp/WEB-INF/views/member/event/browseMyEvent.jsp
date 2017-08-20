<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
            <c:when test="${empty requestScope.userList}">
                <h3>No Users Found !</h3>                
        </c:when>
        
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>First</th>
                    <th>Last</th>
                    <th>Email</th>
                    <th>Photo</th>
                </tr>
             <c:forEach items="${requestScope.userList}" var="user">
                 <tr>
                     <td> ${user.fname}</td>
            <td> ${user.lname}</td>
            <td> ${user.email}</td>
           <td> <img height="150" width="150" src="${user.filename}" /></td>
            </tr>
        </c:forEach>
            </table>
        </c:otherwise>
       </c:choose>



</body>
</html>