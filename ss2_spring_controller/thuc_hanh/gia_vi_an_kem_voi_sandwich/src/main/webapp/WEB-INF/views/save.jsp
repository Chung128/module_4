<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 6/18/2025
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Condiment</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<hr>
<form action="condiments">
    <input name="condiment" type="checkbox" value="Lettuce"><span>Lettuce</span>
    <input name="condiment" type="checkbox" value="Tomato"><span>Tomato</span>
    <input name="condiment" type="checkbox" value="Mustard"><span>Mustard</span>
    <input name="condiment" type="checkbox" value="Sprouts"><span>Sprouts</span>
    <hr>
    <button name="action" type="submit" value="save"> Save</button>
</form>
<ul>
    <c:forEach var="item" items="${condiment}">
        <li>${item}</li>
    </c:forEach>
</ul>
<h5 style="color: red">${error}</h5>
</body>
</html>
