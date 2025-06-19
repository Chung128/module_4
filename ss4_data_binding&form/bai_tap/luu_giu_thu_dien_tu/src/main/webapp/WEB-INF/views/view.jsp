<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bài tập</title>
</head>
<body>
<h2>Save</h2>
<p><strong>Language:</strong> ${email.language}</p>
<p><strong>Page Size:</strong> ${email.pageSize}</p>
<p><strong>Spams Filter:</strong> ${email.filter}</p>
<p><strong>Signature:</strong>${email.signature}</p>
</body>
</html>
