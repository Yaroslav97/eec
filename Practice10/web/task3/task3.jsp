<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ua.nure.poliakov.Practice10.task3</title>
</head>
<body>

<a href="/index.jsp">back</a>

<br>
<br>

<form action="/task3" method="post">
    <input name="name"><br>
    <input type="submit">
</form>

<br>

${list}

<br>
<br>

<a href="/remove">remove</a>

</body>
</html>
