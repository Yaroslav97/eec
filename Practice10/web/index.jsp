<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
  <head>
    <title>main</title>
  </head>
  <body>

  <c:if test="${empty sessionScope.login}">
      <c:redirect url="task4/login.jsp"/>
  </c:if>

  <h3><p align="right">you are logged as ${sessionScope.group} ${sessionScope.login}</p></h3>

  <a href="task1/task1.jsp">part1</a><br>
  <a href="task2/table2.jsp">part2</a><br>
  <a href="task3/task3.jsp">part3</a><br>
  <a href="task4/edit.jsp">part4</a><br>

  <form action="/signIn">

  </form>
  </body>
</html>