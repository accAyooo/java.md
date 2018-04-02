<%--
  Created by IntelliJ IDEA.
  User: ayooo
  Date: 2018/3/11
  Time: 下午9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% if(request.getAttribute("message") != null) {%>
<h3 style="color:red">
    <%= request.getAttribute("message")%>
</h3>
<% }%>
<form action="/user/LoginServlet" method="post">
    <h3 style="text-align: center">登录窗口</h3>
    <table align="center">

        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
