<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/12/18
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>登录成功</h1>
    <hr>
    <br>
    <br>
    <br>
    <%
        request.setCharacterEncoding("utf-8");
        String[] isUseCookies = request.getParameterValues("isUseCookie");

        if (isUseCookies != null && isUseCookies.length > 0) {
            // 防止中文乱码，URLEncoder解决cookie中保存中文问题。
            String username = URLEncoder.encode(request.getParameter("username"), "utf-8");
            String password = URLEncoder.encode(request.getParameter("password"), "utf-8");

            Cookie usernameCookie = new Cookie("username", username);
            Cookie passwordCookie = new Cookie("password", password);

            usernameCookie.setMaxAge(864000);
            passwordCookie.setMaxAge(864000);

            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        } else {
            Cookie[] cookies = request.getCookies();

            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username") || cookie.getName().equals("password")) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
            }
        }
    %>
    <a href="users_cookie.jsp" target="_blank">查看用户信息</a>
</body>
</html>
