<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 6/19/2025
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Thông tin</title>
</head>
<body>
<h2>Submitted Employee Information</h2>
<table>
  <tr>
    <td>Name:</td>
    <td>${name}</td>
  </tr>
  <tr>
    <td>ID:</td>
    <td>${id}</td>
  </tr>
  <tr>
    <td>Contact :</td>
    <td>${contact}</td>
  </tr>
</table>
</body>
</html>
