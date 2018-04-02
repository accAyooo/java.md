<%@ page import="com.study.model.User" %><%--
  Created by IntelliJ IDEA.
  User: ayooo
  Date: 2018/3/10
  Time: 上午9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<%
    String username = (String) request.getSession().getAttribute("USER_INFO_NAME");
%>
<body>
<form action="/user/LoginServlet" method="post">
    <table align="center" border="1">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" value="<%= username%>>"></td>
        </tr>
        <tr>
            <td><密码></密码>：</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
