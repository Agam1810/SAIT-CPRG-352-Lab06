<%-- 
    Document   : register
    Created on : 24-Jun-2022, 6:19:11 PM
    Author     : prince bhagria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1><b>Shopping List</b></h1>
        
        <form action="ShoppingList" method="post">
        <label>Username:</label>
        <input type="text" name="username" value="">
        <input type="submit" name=" Register name" value="Register name" >
        <input type="hidden" name="action" value="register">
        </form>
        
        
            <p>${error}</p>
            <p>${message}</p>
        
    </body>
</html>
