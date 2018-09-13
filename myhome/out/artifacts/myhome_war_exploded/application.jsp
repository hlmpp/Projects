<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/7/18
  Time: 8:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>application jsp</title>
</head>
<body>
    <h1>application 内置对象</h1>
    <%
        application.setAttribute("city", "北京");
        application.setAttribute("postcode", "10000");
        application.setAttribute("email", "lisi@126.com");
    %>

    所在的城市：<%=application.getAttribute("city")%><br>
    application的属性有：<%
        Enumeration attributeNames = application.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            out.println(attributeNames.nextElement() + "&nbsp;&nbsp;");
        }
    %><br>

    jsp或者servlet引擎名和版本号：<%=application.getServerInfo()%><br>

</body>
</html>
