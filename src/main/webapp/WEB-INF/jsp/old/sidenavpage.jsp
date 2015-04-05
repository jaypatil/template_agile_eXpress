<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="common/metatag.jspf"%>
        <%@include file="common/stylesheet.jspf"%>
        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">

        <title>Template for Bootstrap</title>
    </head>


    <body>
        <%@include file="common/navbar.jspf"%>

        <div class="bodycontent">

            <div class="clearfix">
                <%@include file="common/side-navebar.jspf"%>
                <%@include file="common/contentwithsidemenu.jspf"%>
            </div> 
            <!-- Wrap the rest of the page in another container to center all the content. -->
        </div>

        <%@include file="common/javascript.jspf"%>
    </body>
</html>
