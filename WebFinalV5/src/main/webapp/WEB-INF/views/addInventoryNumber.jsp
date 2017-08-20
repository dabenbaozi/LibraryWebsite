<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Inventory</title>
    </head>
    <body>
        <form action='addSuccessfully.htm' method='POST'><!-- /HW5_P2/addSuccessfully.htm -->
        <h1>Add Book Info:</h1>
        <table border=1  class="table table-hover">
        <tr>
            <th width=100>ISBN</th>
            <th width=100>Book Title</th>
            <th width=100>Authors</th>
        </tr>
       
     
        
        <c:forEach var="i" begin="1" end= "${numberAdd[0]}">
            <tr><td><input type='text' name='isbn'></td>
                <td><input type='text' name='title'></td>
                <td><input type='text' name='authors'></td>
            </tr>
        </c:forEach>
            </table><br /><br />
        
        
        
           <h1>Add Movie Info:</h1>
         <table border=1  class="table table-hover">
        <tr>
            <th width=100>Movie title</th>
            <th width=100>Actor</th>
            <th width=100>Actress</th>
            <th width=100>Genre</th>
            <th width=100>year</th>
            <th width=100>description</th>
        </tr>
       
  
        <c:forEach var="i" begin="1" end= "${numberAdd[1]}">
            <tr><td><input type='text' name='movietitle'></td>
                <td><input type='text' name='movieactor'></td>
                <td><input type='text' name='movieactress'></td>
                <td><input type='text' name='movieGenre'></td>
                <td><input type='text' name='movieyear'></td>
                <td><input type='text' name='moviedescription'></td>
            </tr>
        </c:forEach>
            </table><br /><br />
        
        
        
        
        
        
        <h1>Add Music Info:</h1>
         <table border=1  class="table table-hover">
        <tr>
            <th width=100>Title</th>
            <th width=100>Authors</th>
            <th width=100>Genre</th>
        </tr>
       
       
        <c:forEach var="i" begin="1" end= "${numberAdd[2]}">
            <tr><td><input type='text' name='musictitle'></td>
                <td><input type='text' name='musicauthor'></td>
                <td><input type='text' name='musicgenre'></td>
            </tr>
        </c:forEach>
            </table><br /><br />

            <input type = "hidden" name="numBook" value = "${numberAdd[0]}" >
            <input type = "hidden" name="numMusic" value = "${numberAdd[2]}" >
            <input type = "hidden" name="numMovies" value = "${numberAdd[1]}" >
            <input type='submit' value='Submit'>
        </form>
    </body>
</html>