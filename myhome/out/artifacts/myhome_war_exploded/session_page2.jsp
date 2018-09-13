<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/6/18
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session page2</title>
</head>
<body>
    <h1>session对象</h1>
    session的ID编号：<%=session.getId() %><br>
    从session中获取用户名：<%=session.getAttribute("username") %><br>
    session中保存的属性有：<%
        String[] names = session.getValueNames();// 不推荐使用，被getAttributeNames()代替
        for (int i = 0; i < names.length; i ++) {
            out.println(names[i] + "&nbsp;&nbsp;");
        }
    %><br>
</body>
</html>
