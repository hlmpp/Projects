<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/14/18
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Servlet路径跳转</h1>
    <hr>
    <%--以下是相对路径--%>
    <%--如果虚拟路径不是根/，那么以下必须是相对路径，否则无法访问的。所以/servlet/HelloServlet的第一个斜线
    表示服务器的根目录--%>
    <a href="servlet/HelloServlet">访问HelloServlet！</a><br>
    <%--以下是决定路径--%>
    <a href="servlet/testServlet">visit TestServlet, jump to Test.jsp.</a>
</body>
</html>
