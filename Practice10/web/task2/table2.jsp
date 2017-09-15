<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>part2</title>
    <link rel="stylesheet" type="text/css" href="brd.css">
</head>
<body>

<a href="../index.jsp">back</a>

<br>
<br>
<br>

<table class="brd">
    <tr>
        <th> </th>
        <c:forEach var="n" begin="1" end="9">
            <th>${n}</th>
        </c:forEach>
    </tr>

    <c:forEach var="i" begin="1" end="9">
        <tr>
            <th>${i}</th>
            <c:forEach var="j" begin="1" end="9">
                <td>${i*j}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

</body>
</html>