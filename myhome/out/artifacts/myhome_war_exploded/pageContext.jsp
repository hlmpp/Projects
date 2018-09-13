<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/7/18
  Time: 8:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext page</title>
</head>
<body>
    <h1>pageContext 内置对象</h1>
    用户名是：<%=pageContext.getSession().getAttribute("username")%><br>
    <%
//        pageContext.forward("register.jsp");
        pageContext.include("include.jsp");
    %>
</body>
</html>
