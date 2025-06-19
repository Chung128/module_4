<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thư điện tử</title>
</head>
<body>
<h3>Settings</h3>
<form:form action="updateEmail" method="post" modelAttribute="email">
    <table>
        <tr>
            <td><form:label path="language">Languages: </form:label></td>
            <td><form:select path="language">
                <form:option value="english"/>English
                <form:option value="vietnamese"/>Vietnamese
                <form:option value="japanese"/>Japanese
                <form:option value="chinese"/>Chinese
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td>Show<form:select path="pageSize">
                    <form:option value="5"/>5
                    <form:option value="10"/>10
                    <form:option value="15"/>15
                    <form:option value="25"/>25
                    <form:option value="50"/>50
                    <form:option value="100"/>100
                </form:select> emails per page
        </tr>
        <tr>
            <td><form:label path="filter">Spams filter: </form:label></td>
            <td><form:checkbox path="filter"/></td> enable spams filter.
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:input path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
