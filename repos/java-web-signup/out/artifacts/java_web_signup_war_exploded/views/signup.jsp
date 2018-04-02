<%--
  Created by IntelliJ IDEA.
  User: ayooo
  Date: 2018/3/10
  Time: 上午9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signup</title>
</head>
<body>
<form enctype="multipart/form-data" action="/user/SignupServlet" method="post" >
    <h3 style="text-align: center;">用户注册</h3>
    <table align="center" border="1">
        
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password"></td>
        </tr>
        <td>性别:</td>
        <td><input type="radio" name="sex" value="0" />男
        <input type="radio" name="sex" value="1" />女</td>
        </tr>
        <tr>
            <td>上传头像：</td>
            <td><input type="file" name="headUrl"></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>
</body>
</html>
