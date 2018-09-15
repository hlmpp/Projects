<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/13/18
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一个servlet例子</title>
</head>
<body>
    <h1>第一个servlet例子</h1>
    <hr>
    <a href="servlet/HelloServlet">Get方式请求HelloServlet</a>
    <form action="servlet/HelloServlet" method="post">
        <input type="submit" value="Post方式提交HelloServlet">
    </form>
</body>
</html>
