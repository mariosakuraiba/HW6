<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Courses</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        
        <div class = "wrap">
            <%@ include file="includes/header.jsp" %>
            
            <%@ include file="includes/main.jsp" %>
            <div class="main">
            <h1>My Enrolled Courses Database</h1>
            <a href="read">View All Courses</a>
            <br><br>
            <a href="search.jsp">Search Courses</a>
            </div>
		
                    
		
		
            <%@ include file="includes/footer.jsp" %>    
	</div>
        
    </body>
</html>
