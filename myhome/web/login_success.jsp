<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/10/18
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>imooc - login</title>
</head>
<body>
<div id="container">
    <div class="logo">
        <a href="#"><img src="assets/logo.png" alt=""></a>
    </div>
    <div id="box">
        <%
            String loginUser = "";
            if (session.getAttribute("loginUser") != null) {
                loginUser = session.getAttribute("loginUser").toString();
            }
        %>
        欢迎您<font color="red"><%=loginUser%></font>，登录成功！
    </div>
</div>
</body>
</html>
