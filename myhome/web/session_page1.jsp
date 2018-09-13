<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/6/18
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session_page1</title>
</head>
<body>
    <h1>session对象</h1>
    <hr>
    <%
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

        Date date = new Date(session.getCreationTime());

        session.setAttribute("username", "admin");

        session.setAttribute("password", "312");

        session.setAttribute("age", 20);

        //该session的生存周期
//        session.setMaxInactiveInterval(10);
//        session.invalidate();// 销毁当前会话
    %>j
    session当前创建时间：<%=simpleDateFormat.format(date) %><br>
    session的ID编号：<%=session.getId() %><br>
    <%--从session中获取用户名：<%=session.getAttribute("username") %><br>--%>
    <a href="session_page2.jsp" target="_blank">跳转到session_page2</a> <!-- 打开新的窗口_blank -->

</body>
</html>
