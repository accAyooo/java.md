<%--
  Created by IntelliJ IDEA.
  User: ayooo
  Date: 2018/3/13
  Time: 下午9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  验证码： <img src="code.jsp" alt="" class="code-img">
  <a href="javascript:refresh();">refresh</a>

  <form action="/CodeServlet">
      <input type="text" name="code">
      <input type="submit">
  </form>
  <script>
      function refresh() {
          window.location.href = window.location.href;
      }
  </script>
  </body>
</html>
