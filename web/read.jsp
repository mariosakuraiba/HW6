<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enrolled Classes</title>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>My Enrolled Courses</h1>
        <%= table %>
        <br><br>
        <a href="add">Add A New Course</a><br>
        <a href="index.jsp">Return to the previous page</a>
    </body>
</html>