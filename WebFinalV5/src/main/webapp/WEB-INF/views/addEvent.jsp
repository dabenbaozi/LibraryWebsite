<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<style>
.form-control-inline {
    min-width: 0;
    width: 50%;
    display: inline;
}

.btn-file {
    position: relative;
    overflow: hidden;
}
.btn-file input[type=file] {
    position: absolute;
    top: 0;
    right: 0;
    min-width: 100%;
    min-height: 100%;
    font-size: 100px;
    text-align: right;
    filter: alpha(opacity=0);
    opacity: 0;
    outline: none;
    background: white;
    cursor: inherit;
    display: block;
}

</style>
<title>Add Event</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="container" align = "center">
<%-- <form:form  action = 'librarian/addEvent.htm' commandName="event" method="get" enctype="multipart/form-data" modelAttribute="event"  class="form-inline">
<!-- Start Date: <input type="date" name="startDate"/><br/>
<br/>
End Date: <input  type = "date" name="endDate"/><br/>
<br/> -->
<h2 style="color:#667292">Add Event</h2>
Description: <input name="description"/><br/>
<br/>
Event Location: <input type="text" name="location"/><br/>
<br/>
Create Album:<input type="text" name="filename" /><br/>
<br/>
Select Event poster: 
<span class="btn btn-default btn-file">
Select poster <input type = "file" name="poster"/><br/>
</span>
<br/><br/>
<input type="submit" value="Create Event"  class="btn btn-primary btn-lg"/>
</form:form>
<br/><br/> --%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<form:form  action = '${contextPath}/librarian/addEvent.htm' commandName="event" method="post" enctype="multipart/form-data" class="form-inline">
<h2 style="color:#667292">Add Event</h2>
Description: <input name="description"/><br/>
<br/>
Event Location: <input type="text" name="location"/><br/>
<br/>
Create Album:<input type="text" name="filename" /><br/>
<br/>

Select Event poster: 
<!-- <span class="btn btn-default btn-file"> -->
Select poster <input type = "file" name="poster"/><br/>
<!-- </span>-->
<br/><br/>
<input type="submit" value="Create Event"  class="btn btn-primary btn-lg"/>
</form:form>
<br/><br/>


<form action='librarian/sendEmail.htm' method='POST'>
<input type="submit" value="Send Email Notice User"  class="btn btn-primary btn-lg"/>
</form>

</div>
</body>
</html>