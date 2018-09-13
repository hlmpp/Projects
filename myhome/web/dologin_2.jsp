<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/10/18
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="myUsers" class="com.po.Users" scope="page"></jsp:useBean>
    <h1>setProperty动作元素</h1>
    <hr>
    <!-- 根据表单自动匹配所有的属性，主要是类的属性和表单的名字一致的话 -->
    <%--<jsp:setProperty name="myUsers" property="*"></jsp:setProperty>--%>
    <!-- 根据表单自动匹配部分的属性，主要是类的属性和表单的名字一致，不过由于密码没有指定，所有密码的值为null -->
    <%--<jsp:setProperty name="myUsers" property="username"></jsp:setProperty>--%>
    <%--跟表单无关，通过手工赋值给属性。表单上的那些填值不起作用。--%>
    <%--<jsp:setProperty name="myUsers" property="username" value="lisi" ></jsp:setProperty>--%>
    <%--<jsp:setProperty name="myUsers" property="password" value="888888"></jsp:setProperty>--%>
    <%--通过URL传参数给属性赋值--%>
    <jsp:setProperty name="myUsers" property="password" param="mypass"></jsp:setProperty>
    <jsp:setProperty name="myUsers" property="username" param="myname"></jsp:setProperty>
    <%--这种是用传统的表达式方式获取用户名和密码。--%>
    <%--用户名：<%=myUsers.getUsername() %><br>--%>
    <%--密码：<%=myUsers.getPassword() %><br>--%>
    <%--使用getProperty来获取用户名和密码--%>
    用户名：<jsp:getProperty name="myUsers" property="username"></jsp:getProperty><br>
    密码：<jsp:getProperty name="myUsers" property="password"></jsp:getProperty><br>
    <br>
    <br>
    <a href="testScope.jsp">测试javabean的四个作用域范围</a>
    <%
        request.getRequestDispatcher("testScope.jsp").forward(request, response);
    %>
</body>
</html>
