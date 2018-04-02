<%@ page import="com.study.code.CaptchaCode" %>
<%@ page import="com.study.code.ExpressionCode" %><%--
  Created by IntelliJ IDEA.
  User: ayooo
  Date: 2018/3/13
  Time: 下午9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 清除缓存
    response.setHeader("pragma", "no-cache");
    response.setHeader("cache-control", "no-cache");
    response.setHeader("expires", "0");

    String code = ExpressionCode.drawImage(response);
    request.getSession().setAttribute("code", code);

    // 解决outputstream异常
    out.clear();
    out = pageContext.pushBody();
%>
