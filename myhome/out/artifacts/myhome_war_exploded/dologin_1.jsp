<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/5/18
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if ("admin".equals(username) && "admin".equals(password)) {
        session.setAttribute("loginUser", username);
        request.getRequestDispatcher("login_success.jsp").forward(request, response);
    } else {
        response.sendRedirect("login_failure.jsp");
    }
%>
