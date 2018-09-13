<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/5/18
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request对象</title>
</head>
<body>
    <h1>request内置对象</h1>
    <%
        request.setCharacterEncoding("utf-8");
        request.setAttribute("password", "312");
    %>
    用户名：<%=request.getParameter("username") %><br>
    爱好：<%
            if (request.getParameterValues("favorite") != null) {
                String[] favorites = request.getParameterValues("favorite");
                for (int i = 0; i < favorites.length; i++) {
                    out.println(favorites[i] + "&nbsp;&nbsp;");
                }
            }
         %> <br>
    密码：<%=request.getAttribute("password") %><br>
    请求体的MIME类型：<%=request.getContentType() %><br>
    协议类型及版本号：<%=request.getProtocol() %><br>
    接受请求的服务器主机名：<%=request.getServerName() %><br>
    服务器接受此请求所用的端口号：<%=request.getServerPort() %><br>
    返回请求体的长度：<%=request.getContentLength() %>byte<br>
    发送此请求的客户端IP地址：<%=request.getRemoteAddr() %><br>
    真实路径：<%=request.getRealPath("request.jsp")%><br>
    <!-- ServletContext.getRealPath(java.lang.String)代替它。-->
    上下文路径：<%=request.getContextPath() %><br>
</body>
</html>
