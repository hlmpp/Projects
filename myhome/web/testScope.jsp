<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/11/18
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.po.Users" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>java bean的四个作用域范围</h1>
    <hr>
    <jsp:useBean id="myUsers" class="com.po.Users" scope="page" />
    用户名：<jsp:getProperty name="myUsers" property="username"/><br>
    密码：<jsp:getProperty name="myUsers" property="password"/><br>
    <%--使用内置对象获取用户和密码--%>
    <hr>
    用户名：<%=((Users)application.getAttribute("myUsers")).getUsername() %> <br>
    密码：<%=(((Users) application.getAttribute("myUsers")).getPassword())%> <br>
    <hr>
    用户名：<%=((Users) session.getAttribute("myUsers")).getUsername()%><br>
    密码：<%=(((Users) session.getAttribute("myUsers")).getPassword())%><br>
    <hr>
    用户名：<%=((Users) request.getAttribute("myUsers")).getUsername()%><br>
    密码：<%=((Users) request.getAttribute("myUsers")).getPassword()%><br>

    <hr>
    <%
        String username = "";
        String password = "";
        if (pageContext.getAttribute("myUsers") != null) {
            username = ((Users) pageContext.getAttribute("myUsers")).getUsername();
            password =  ((Users) pageContext.getAttribute("myUsers")).getPassword();
        }
    %>
    用户名：<%=username%><br>
    密码：<%=password%><br>
</body>
</html>
