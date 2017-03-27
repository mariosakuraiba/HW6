
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Course</title>
    </head>
    <body>
        <h1>Add A New Course</h1>
        
        <form name="addForm" action="addCourse" method="get">
            
            <label>Course Name:</label>
            <input type="text" name="name" value=""/>
            <br>
            <label>Course Session:</label>
            <input type="text" name="session" value=""/>
            <br>
            <label>Course Number:</label>
            <input type="text" name="number" value=""/>
            <br>
            <input type="submit" name="submit" value="Submit" />   
        </form>
    </body>
</html>
