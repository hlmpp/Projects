<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/10/18
  Time: 8:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>imooc - login</title>
</head>
<body>
    <div id="container">
        <div class="logo">
            <a href="#"><img src="assets/logo.png" alt=""></a>
        </div>
        <div id="box">
           <form action="dologin_1.jsp" method="post">
           <p class="main">
               <label>用户名：</label>
               <input name="username" value=""/>
               <label>密码：</label>
               <input type="password" name="password" value=""/>
           </p>
           <p class="space">
                <input type="submit" value="登录" class="login" style="cursor: pointer;"/>
           </p>
           </form>
        </div>
    </div>
</body>
</html>
