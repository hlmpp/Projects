<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/12/18
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>用户信息</h1>
    <hr>
    <br>
    <br>
    <br>
    <%
        request.setCharacterEncoding("utf-8");
        String username = null;
        String password = null;
        String email = null;

        if (request.getParameter("username") != null) {
            username = request.getParameter("username");
        }

        if (request.getParameter("password") != null ) {
            password = request.getParameter("password");
        }

        if (request.getParameter("email") != null) {
            email = request.getParameter("email");
        }
    %>
    用户名：<%=username%><br>
    密码：<%=password%><br>
    邮箱：<%=email%><br>
</body>
</html>
