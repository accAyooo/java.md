<%--
  Created by IntelliJ IDEA.
  User: ayooo
  Date: 2018/3/31
  Time: 下午10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h3 style="text-align: center"> 登录 </h3>
<form action="/login" method="post">
    <table  align="center" border="1">
        <tbody>
            <tr>
                <td>账号：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit"></td>
                <td><a href="/register">注册</a></td>
            </tr>
        </tbody>
    </table>
</form>
<p style="color:red;text-align: center">${error}</p>
</body>
</html>
