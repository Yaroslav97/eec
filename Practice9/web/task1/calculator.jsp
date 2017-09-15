<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>calculator</title>
</head>
<body>
<a href="../index.jsp">main</a><br><br>
<form action="/call" method="get">
    First number:<br>
    <input name="firstN"><br>
    Second number:<br>
    <input name="secondN"><br>
    <select name="operation">
        <option selected value="+">+</option>
        <option value="-">-</option>
    </select>
    <br>
    <input type="submit" value="submit">
</form>
<h3>${result}</h3>
</body>
</html>