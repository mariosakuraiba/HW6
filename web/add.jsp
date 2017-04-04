
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Course</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <h1>Add A New Course</h1>
        <table>
        <form name="addForm" action="addCourse" method="get">
            
            
            <tr>
            <td><label>Course Name:</label></td>
            <td><input type="text" name="name" size="30" value=""/></td>
            </tr><br>
            <tr>
            <td><label>Course Session:</label></td>
            <td><input type="text" name="session" size="30" value=""/></td>
            </tr><br>
            <tr>
            <td><label>Course Number:</label></td>
            <td><input type="text" name="number" size="30" value=""/></td>
            </tr><br>
            
                <td><input type="submit" name="submit" value="Submit" /></td>
              
            
               
        </table>
    </body>
</html>
