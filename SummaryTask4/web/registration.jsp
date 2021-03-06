<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>registration</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<fmt:setBundle basename="i18n"/>

<fmt:message key="periodicals" var="Periodicals"/>
<fmt:message key="sign.in" var="SignIn"/>
<fmt:message key="sign.up" var="SignUp"/>
<fmt:message key="restore" var="RestoreAccess"/>
<fmt:message key="log.out" var="LogOut"/>

<fmt:message key="full.name" var="FullName"/>
<fmt:message key="login" var="Login"/>
<fmt:message key="email" var="Email"/>
<fmt:message key="password" var="Password"/>
<fmt:message key="user" var="User"/>
<fmt:message key="admin" var="Admin"/>
<fmt:message key="sign.up" var="SignUp"/>


<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/index">${Periodicals}</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/restoreAccess">${RestoreAccess}</a></li>
            <c:if test="${sessionScope.authenticatedRole == 'user'}">
                <li><a href="/userCabinet">${sessionScope.authenticatedFullName}</a></li>
            </c:if>
            <c:if test="${sessionScope.authenticatedRole == 'admin'}">
                <li><a href="/adminCabinet">${sessionScope.authenticatedFullName}</a></li>
            </c:if>
            <c:if test="${!empty sessionScope.authenticatedLogin}">
                <li><a href="/logout">${LogOut}</a></li>
            </c:if>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${empty sessionScope.authenticatedLogin}">
                <li class="active"><a href="/registration"><span class="glyphicon glyphicon-user"></span> ${SignUp}</a></li>
                <li><a href="/signIn"><span class="glyphicon glyphicon-log-in"></span> ${SignIn}</a></li>
            </c:if>
        </ul>
    </div>
</nav>

<br>
<br>
<br>

<div class="container">
    <form action="/registration" method="post" class="col-xs-6">
        <input name="fullName" pattern="^[A-zА-я]+ [A-zА-я]+$" required placeholder="${FullName}" minlength="4" maxlength="30" class="form-control"><br>
        <input name="login" pattern="^[A-zА-я0-9]+$" required placeholder="${Login}" minlength="4" maxlength="30" class="form-control"><br>
        <input type="email" pattern="^[a-z0-9]+\.?_?[a-z0-9]+@.{2,9}\..{2,3}$" name="email" required placeholder="${Email}" minlength="4" maxlength="30" class="form-control"><br>
        <input type="password" name="password" required placeholder="${Password}" minlength="4" maxlength="30" class="form-control"><br>
        <select name="role" class="form-control">
            <option selected value="user">${User}</option>
            <option value="admin">${Admin}</option>
        </select>
        <br>
        <input type="submit" value="${SignUp}"><br>
    </form>
</div>

<hr>
<br>

<div align="center" class="container">
    <h3>${requestScope.regInfo}</h3>
</div>

</body>
</html>
