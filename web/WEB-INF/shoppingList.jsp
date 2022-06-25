<%-- 
    Document   : shoppingList
    Created on : 24-Jun-2022, 6:19:31 PM
    Author     : 18255
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <h2>Hello, ${username} 
            <a href=ShoppingList?action=logout>Logout</a></h2>
            <br>
        <h2>List</h2>
        <form method="post" action="ShoppingList">
            <label>Add item:</label>
            <input type="text" name="item" autofocus>
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Add">
        </form>
        <br>
        <c:if test="${not empty List}">
            <form method="post" action="ShoppingList">
                <c:forEach var="List" items="${List}">
                    <input type="radio" name="item" value="${List}"> ${List}<br>
                </c:forEach>
                <input type="hidden" name="action" value="delete">
                <input type="submit" value="Delete">         
            </form>
        </c:if>
        
        <p>${error}</p>
         <p>${errord}</p>
           
    </body>
</html>
