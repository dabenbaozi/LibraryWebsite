<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Searching Page</title>
</head>
<body>
        <h1>Searching Movies</h1>
        <form action="search.htm" method="get">
            <label for="keyword">Keyword</label>
            <input type="text" name="keyword"/><br>
            <input type="radio" name="details" value="title">Search by Title<br>
            <input type="radio" name="details" value="actor">Search by Actor<br>
            <input type="radio" name="details" value="actress">Search by Actress<br>
            <button type="submit">Search Movies</button>
        </form>
       <!--   <form action="show.htm" method="get">
            <button type="submit">Browse Movies</button>
        </form>
        -->
    </body>
</html>