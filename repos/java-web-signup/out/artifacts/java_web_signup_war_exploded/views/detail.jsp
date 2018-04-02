<%@ page import="com.study.model.User" %><%--
  Created by IntelliJ IDEA.
  User: ayooo
  Date: 2018/3/10
  Time: 上午9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>detail</title>
</head>
<%
    User user = (User) request.getSession().getAttribute("LOGIN_USER");
    String name = user.getUsername();
    String headUrl = user.getHeadUrl();
%>
<body>
    <table>
        <tr>
            <td>用户名：</td>
            <td><%= name%>></td>
        </tr>
        <tr>
            <td><img src="<%= headUrl%>" alt=""></td>
        </tr>
    </table>
</body>
</html>
