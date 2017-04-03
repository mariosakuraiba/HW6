
<%@page import="model.Courses"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Courses course = (Courses) request.getAttribute("course"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <title>Update Records</title>
    </head>
    <body>
        <h1>Update Existing Records</h1>
        
        <form name="updateForm" action="updateCourse" method="get">
            <table class="update">  
                <tr>
                    <td class="right">Course ID:</td>
                    <td><input type="text" name="id" value="<%= course.getCourseID() %>" readonly/></td>
                </tr>
            
            <tr>
            <td><label>Course Name:</label></td>
            <td><input type="text" name="name" size="30" value="<%= course.getCourseName() %>"/></td>
            </tr><br>
            <tr>
            <td><label>Course Session:</label></td>
            <td><input type="text" name="session" size="30" value="<%= course.getCourseSession() %>"/></td>
            </tr><br>
            <tr>
            <td><label>Course Number:</label></td>
            <td><input type="text" name="number" size="30" value="<%= course.getCourseNo() %>"/></td>
            </tr><br>
            
                <td><input type="reset" name="reset" value="Clear" /></td>
                <td><input type="submit" name="submit" value="Update" /></td>
              
            </table>
        </form>     
    </body>
</html>
