<%@ page import="com.study.jdbc.bean.User" %>
<%--
  Created by IntelliJ IDEA.
  User: ayooo
  Date: 2018/3/31
  Time: 下午10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("LOGIN_USER");
    request.setAttribute("user", user);

    if (user == null) {
%>

<div style="margin-bottom:20px;overflow: hidden;">
    <a style="float: right" href="/register">注册</a>
    <a style="margin-right: 10px;float: right" href="/login">登录</a>
</div>

<%
    } else {
%>

<div style="margin-bottom:20px;overflow: hidden;">
    <a style="float: right" href="/people">个人中心</a>
    <a style="margin-right: 10px;float: right" href="/message/add">评论</a>
</div>

<%
    }
%>
<div>

</div>
