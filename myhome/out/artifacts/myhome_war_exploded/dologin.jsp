<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/12/18
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:forward page="users.jsp">
        <jsp:param name="email" value="fsdfas@11.com" />
        <jsp:param name="password" value="888888" />
    </jsp:forward>
</body>
</html>
