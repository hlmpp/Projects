<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/5/18
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>用户登录</h1>
    <br>
    <form action="dologin_1.jsp" name="loginForm" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="登录"></td>
            </tr>
        </table>
    </form>
</body>
</html>
