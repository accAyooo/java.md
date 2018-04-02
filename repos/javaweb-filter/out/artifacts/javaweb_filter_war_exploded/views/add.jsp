<%@ page import="java.util.List" %>
<%@ page import="com.study.model.Review" %><%--
  Created by IntelliJ IDEA.
  User: ayooo
  Date: 2018/3/11
  Time: 下午10:10
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
<h3 style="text-align: center">用户名：<%out.print(request.getParameter("username"));%></h3>
<h3 style="text-align: center">添加评论</h3>
<form action="/user/AddReviewServlet" method="get">
    <table align="center">
        <tr>
            <td>添加评论标题：</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>添加评论内容：</td>
            <td><td><input type="text" name="content"></td></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>

<h3 style="text-align: center">全部评论</h3>
<table align="center" border="1">
    <%
        List<Review> reviewList = (List<Review>) request.getAttribute("reviewList");
        if (reviewList != null && reviewList.size() > 0) {
            for (int i = 0; i < reviewList.size(); i ++) {
                String content = reviewList.get(i).getContent();
                String title = reviewList.get(i).getTitle();
    %>
    <tr>
        <td><%= (i + 1)%></td>
        <td><%= title%></td>
        <td><%= content%></td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
