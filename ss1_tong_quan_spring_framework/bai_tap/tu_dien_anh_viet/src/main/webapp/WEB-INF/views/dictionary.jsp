<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 6/18/2025
  Time: 1:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Từ điển đơn giản</h1>
<form action="dictionarys" method="get">
    <label>Nhập từ cần dịch</label>
    <input type="text" name="word" value="${word}" required>
    <hr>
    <label>Chuyển đổi:</label>
    <select name="direction">
        <option value="vnToEnglish" ${direction == 'vnToEnglish' ? 'selected' : ''}>Việt -> Anh</option>
        <option value="englishToVn" ${direction == 'englishToVn' ? 'selected' : ''}>Anh -> Việt</option>
    </select>
    <hr>
    <button type="submit">Dịch</button>
</form>

<c:if test="${not empty result}">
    <h3>Kết quả: ${result} </h3>
</c:if>
<c:if test="${notFound}">
    <h3 style="color: red;">Không tìm thấy kết quả</h3>
</c:if>
</body>
</html>
