<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>sign up</title>
</head>
<body>

<a href="login.jsp">back</a>

<br>
<br>

<form action="/signUp">
    Login:<br>
    <input name="login" minlength="4"><br>
    Name:<br>
    <input name="name" minlength="4"><br>
    Password:<br>
    <input type="password" name="password" minlength="4"><br>
    Role id:<br>
    <input name="role" minlength="4"><br>
    <input type="submit" value="send">
</form>

</body>
</html>
