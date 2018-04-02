<%--
  Created by IntelliJ IDEA.
  User: ayooo
  Date: 2018/3/14
  Time: 下午9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String source = request.getParameter("source");
%>w
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" align="center" border="1" method="post">
    <input type="hidden" name="source" value="<%= source%>">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="submit">
</form>
</body>
</html>
