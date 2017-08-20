<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>  
<%  
String name=request.getParameter("val");  
if(name==null||name.trim().equals("")){  
out.print("<p>Please enter name!</p>");  
}else{  
try{  
    Class.forName("com.mysql.jdbc.Driver"); 
    String user = "root";
    String password = "54lilygl";
    String url = "jdbc:mysql://localhost:3306/webfinalv2";
    Connection con=DriverManager.getConnection(url,user,password);  
    PreparedStatement ps=con.prepareStatement("select * from user_table where userName like '"+name+"%'");  
    ResultSet rs=ps.executeQuery();  
  
if(!rs.isBeforeFirst()) {      
 out.println("<p>No Record Found!</p>");   
}else{  
out.print("<table border='1' cellpadding='2' width='100%'>");  
out.print("<tr><td><b>User Id</b></td><td><b>User Name</b></td><td><b>Last Name</b></td></tr>");  
while(rs.next()){  
out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td></tr>");  
}  
out.print("</table>");  
}//end of else for rs.isBeforeFirst  
con.close();  
}catch(Exception e){out.print(e);}  
}//end of else  
%>  
</body>
</html>