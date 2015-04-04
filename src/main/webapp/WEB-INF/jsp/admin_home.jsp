<%-- 
    Document   : login_form
    Created on : Mar 30, 2015, 11:11:01 AM
    Author     : Vikram
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
        <link type="text/css" rel="stylesheet" href="<s:url value="/static/style.css"/>"/>
    </head>
    <body>
        <table border="1" width="80%" align="center">
            <tr>
                <td height="30px">
                    <%@include file="common/header.jsp"%>
                </td>
            </tr>
            <tr>
                <td height="20px">
                    <%@include file="common/menu.jsp" %>
                </td>
            </tr>
            <tr>
                <td height="300px" valign="top" align="center">
                    
                </td>
            </tr>
            <tr>
                <td height="20px">
                    <%@include file="common/footer.jsp" %>
                </td>
            </tr>
        </table>
    </body>
</html>
