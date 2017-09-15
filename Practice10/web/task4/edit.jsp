<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>

<a href="../index.jsp">back</a>

<br>
<br>

<form action="/edit">
    Name:<br>
    <input name="name" value="${sessionScope.name}"><br>
    <input type="submit" value="edit">
</form>

</body>
</html>