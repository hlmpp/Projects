<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/12/18
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="loginUser" class="com.po.Users" scope="page" />
<jsp:useBean id="userDao" class="com.dao.UsersDao" scope="page" />
<jsp:setProperty name="loginUser" property="*" />

<%
    if (userDao.usersLogin(loginUser)) {
        session.setAttribute("loginUser", loginUser.getUsername());
        request.getRequestDispatcher("login_success.jsp").forward(request, response);
    } else {
        response.sendRedirect("login_failure.jsp");
    }
%>