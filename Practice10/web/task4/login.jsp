<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<form action="/signIn">
    Login:<br>
    <input name="login" minlength="4"><br>
    Password:<br>
    <input type="password" name="password" minlength="4"><br>
    <input type="submit" value="sign in">
</form>

<br>

<a href="task4.jsp">sign up</a>

</body>
</html>
