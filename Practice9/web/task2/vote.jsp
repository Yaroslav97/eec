<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>vote</title>

    <link rel="stylesheet" type="text/css" href="brd.css">
</head>
<body>

<a href="../index.jsp">main</a><br><br>

<form action="/vote">

    <br>
    Your name:<br>
    <input name="name" minlength="4"><br>

    <select name="vote">
        <option selected value="Football">Football</option>
        <option value="Biathlon">Biathlon</option>
        <option value="Basketball">Basketball</option>
    </select>

    <br>

    <input type="submit" value="submit">

    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <div>
        <table class="brd">
            <tr>
                <td><h3>Football</h3></td>
                <td>${scoreFootball}</td>
                <td>${nameFootball}</td>
            </tr>
            <tr>
                <td><h3>Biathlon</h3></td>
                <td>${scoreBiathlon}</td>
                <td>${nameBiathlon}</td>
            </tr>
            <tr>
                <td><h3>Basketball</h3></td>
                <td>${scoreBasketball}</td>
                <td>${nameBasketball}</td>
            </tr>
        </table>
    </div>

</form>
</body>
</html>
