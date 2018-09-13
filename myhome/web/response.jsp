<%-- Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/6/18
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.io.PrintWriter" contentType="text/html; charset=utf-8" %>

<%
    response.setContentType("text/html;charset=utf-8");//设置响应的MIME类型

    out.println("<h1>response内置对象</h1>");
    out.println("<hr>");
    //out.flush(); //与后面的重定向有冲突

    PrintWriter outer = response.getWriter();//获得输出流对象
    outer.println("大家好，我是response对象生成的输出流outer对象");

//    response.sendRedirect("register.jsp");//请求重定向
//    response.sendRedirect("request.jsp");
    request.getRequestDispatcher("request.jsp").forward(request, response);
%>
