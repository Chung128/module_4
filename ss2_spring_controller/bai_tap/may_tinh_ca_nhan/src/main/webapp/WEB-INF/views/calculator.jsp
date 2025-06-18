<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Máy tính cá nhân</title>
</head>
<body>
<form action="calculate" method="get">
    <h2>Máy tính</h2>
    <hr>
    <input name="number1" type="number" step="any" required><span>Số thứ nhất</span>
    <input name="number2" type="number" step="any" required><span>Số thứ hai</span>
    <select name="operation">
        <option value="add">Cộng (+)</option>
        <option value="subtract">Trừ (-)</option>
        <option value="multiply">Nhân (*)</option>
        <option value="divide">Chia (/)</option>
    </select>
    <button name="result" type="submit" value="result">Tính</button>
</form>
<c:if test="${not empty result}">
    <h2>Kết quả: ${result}</h2>
</c:if>
<c:if test="${not empty error}">
    <div class="error">
        <h3>${error}</h3>
    </div>
</c:if>
</body>
</html>