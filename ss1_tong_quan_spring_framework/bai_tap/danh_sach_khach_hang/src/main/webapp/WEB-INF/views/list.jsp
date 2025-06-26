<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 6/17/2025
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>danh sách</title>
</head>
<body>
<table>
  <tr>
    <th>stt</th>
    <th>tên</th>
    <th>email</th>
    <th>địa chỉ</th>
  </tr>
    <c:forEach items="${khachHangList}" varStatus="stt" var="khachhang">
      <tr>
        <td >${stt.count}</td>
        <td >${khachhang.name}</td>
        <td >${khachhang.email}</td>
        <td >${khachhang.address}</td>
      </tr>
    </c:forEach>
</table>
</body>
</html>
