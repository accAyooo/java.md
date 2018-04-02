<%--
  Created by IntelliJ IDEA.
  User: ayooo
  Date: 2018/3/31
  Time: 下午11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1 align="center">用户信息</h1>

<table align="center" border="1">
    <tbody>
    <tr>
        <td>id:</td>
        <td>${user.getId()}</td>
        <td></td>
    </tr>
    <tr>
        <td>用户名:</td>
        <td>${user.getUsername()}</td>
    </tr>
    <tr>
        <td>电话:</td>
        <td>${user.getPhoneNum()}</td>
    </tr>
    <tr>
        <td>地址:</td>
        <td>${user.getAttr()}</td>
    </tr>
    <tr>
        <td>真实姓名:</td>
        <td>${user.getRealName()}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
