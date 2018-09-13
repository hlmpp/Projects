<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/10/18
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="users" class="com.po.Users" scope="page"/>
    <h1>使用普通方式创建javabean实例</h1>
<hr>
    用户名：<%=users.getUsername() %><br>
    密码：<%=users.getPassword() %><br>
</body>
</html>
