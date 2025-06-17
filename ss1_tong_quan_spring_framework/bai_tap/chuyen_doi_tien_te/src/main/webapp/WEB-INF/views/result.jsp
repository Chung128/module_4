<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 6/17/2025
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>chuyển đổi tiền tệ</title>
</head>
<body>

<form action="converts" method="get">
    Nhập số tiền USD: <input type="number" name="vnd" required/>
    <button type="submit" value="Chuyển đổi">Chuyển</button>
</form>
<p> ${usd} USD= ${vnd} VND</p>
</body>
</html>
