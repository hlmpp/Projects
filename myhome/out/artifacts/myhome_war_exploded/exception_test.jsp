<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/7/18
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="exception.jsp" %>
<html>
<head>
    <title>exception page</title>
</head>
<body>
    <h1>测试异常的页面</h1>
    <hr>

    <%
        out.println(100/0);
    %>
</body>
</html>
