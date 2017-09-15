<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>part1</title>
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
        <% for (int n = 1; n <= 9; n++) { %>
            <th><%= n %></th>
        <%}%>
    </tr>
    <% for (int i = 1; i <= 9; i++) { %>
    <tr>
        <th><%= i %></th>
        <% for (int j = 1; j <= 9; j++) { %>
            <td> <%= i*j %> </td>
        <%}%>
    </tr>
    <%}%>
</table>

</body>
</html>