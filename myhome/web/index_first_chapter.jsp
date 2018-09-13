<%--
  Created by IntelliJ IDEA.
  User: pengchen
  Date: 9/3/18
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.io.IOException" %>
<html>
  <head>
    <title>My Jsp Page</title>
  </head>
  <body>
    <h1>大家好</h1>
    <hr>
    <!-- 我是HTML注释，在客户端可见 -->
    <%-- 我是jsp注释，在客户端不可见 --%>
    <%!
      String s = "张三";
      int add(int x, int y) {
          return x + y;
      }
    %>
    <%
      // 单行注释
      /**
       * 多行注释
       */
      out.println("开发javaee");
    %>
    <br>
    你好，<%=s %><br>
    x+y=<%=add(10, 5) %><br>

    <hr>
    <%
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String s = simpleDateFormat.format(new Date());
    %>
    今天是: <%=s %>


    <%!
       String printMultiTable1() {
           String s = "";
           for (int i = 1; i <= 9; i ++) {
               for (int j= 1; j <= i; j ++) {
                   s += i + "*" + j + "=" + (i*j) + "&nbsp;&nbsp;&nbsp;&nbsp;";
               }
               s +="<br>";
           }
           return s;
       }

       void printMultiTable2(JspWriter out) {
           try {
               for (int i = 1; i <= 9; i++) {
                   for (int j = 1; j <= i; j++) {

                       out.println(i + "*" + j + "=" + (i * j) + "&nbsp;&nbsp;&nbsp;&nbsp;");

                   }
                   out.println("<br>");
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    %>

    <h1>九九乘法表</h1>
    <%=printMultiTable1() %>

    <br>
    <%
        printMultiTable2(out);
    %>
    <br>

    <br>
    <%
        int[] value = {60, 70, 80};
        for(int i : value) {
            out.print(i);
        }
    %>
    <br>
    <hr>
    <h1>out内置对象</h1>
    <%
        out.println("<h2>静夜思</h2>");
        out.println("床前明月光<br>");
        out.println("疑是地上霜<br>");
        out.flush();
        // out.clear(); 会抛出异常
        out.clearBuffer();// 不会抛出异常
        out.println("举头望明月<br>");
        out.println("低头思故乡<br>");
    %>

    缓冲区大小：<%=out.getBufferSize() %>byte。<br>
    缓冲区剩余大小：<%=out.getRemaining() %>byte。<br>
    是否自动清空缓冲区：<%=out.isAutoFlush() %>。<br>
  </body>
</html>
