<%--
  Created by IntelliJ IDEA.
  User: ayooo
  Date: 2018/3/31
  Time: 下午11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加评论</title>
</head>
<body>
<h1 style="text-align: center">评论内容</h1>
<form action="/message/add" method="post">

    <table align="center" border="1">
        <tbody>
        <tr>
            <td>标题</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>内容</td>
            <td>
                <textarea name="content" id="" cols="30" rows="5"></textarea>
            </td>
        </tr>
        <tr>
            <td><input type="submit"></td>
        </tr>
        </tbody>
    </table>
</form>
<p align="center"><%= request.getAttribute("error") == null ? "" : request.getAttribute("error")%></p>
</body>
</html>
