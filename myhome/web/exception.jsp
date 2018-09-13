<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/10/18
  Time: 8:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>exception jsp</title>
</head>
<body>
    <h1>exception内置对象</h1>
    <hr>
    异常消息是：<%=exception.getMessage() %><br>
    异常的字符串描述：<%=exception.toString()%>
</body>
</html>
