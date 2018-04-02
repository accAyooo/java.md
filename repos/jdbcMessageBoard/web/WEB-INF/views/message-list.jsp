<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ayooo
  Date: 2018/3/31
  Time: 下午7:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>

<%@include file="/WEB-INF/views/common/login_info.jsp"%>

<table align="center" border="1">
    <tbody>
        <tr>
            <th>id</th>
            <th>用户</th>
            <th>标题</th>
            <th>内容</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${messages}" var="item">
            <tr>
                <td>${item.getId()}</td>
                <td>${item.getUsername()}</td>
                <td>${item.getTitle()}</td>
                <td>${item.getContent()}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div class="add-message" style="text-align: center">
    <a href="/message/add">添加</a>
</div>


<div class="pagination" style="text-align: center">
    <c:forEach var="list" begin="1" end="${last}" varStatus="status">
        <c:if test="${status.count == page}"><span>${status.count}</span></c:if>
        <c:if test="${status.count != page}">
            <a href="/message/list?page=${status.count}">${status.count}</a>
        </c:if>
    </c:forEach>
</div>
</body>
</html>
