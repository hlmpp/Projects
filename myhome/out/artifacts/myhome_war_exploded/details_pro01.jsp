<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDao" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'details.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
	   div{
	      float:left;
	      margin-left: 30px;
	      margin-right:30px;
	      margin-top: 5px;
	      margin-bottom: 5px;
	   }
	   div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_city
	   {
	      color:#000;
	   }
	</style>
  </head>
  
  <body>
    <h1>商品详情</h1>
    <hr>
    <center>
      <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
          <!-- 商品详情 -->
            <%
                ItemsDao itemsDao = new ItemsDao();
                Items item = itemsDao.getItemsById(Integer.parseInt(request.getParameter("id")));
                if (item != null) {
            %>
          <td width="70%" valign="top">
             <table>
               <tr>
                 <td rowspan="4"><img src="images/<%=item.getPicture()%>" width="200" height="160"/></td>
               </tr>
               <tr>
                 <td><B><%=item.getName() %></B></td> 
               </tr>
               <tr>
                 <td>产地：<%=item.getCity()%></td>
               </tr>
               <tr>
                 <td>价格：<%=item.getPrice() %>￥</td>
               </tr> 
             </table>
          </td>
            <%
                }
            %>

          <!-- 浏览过的商品 -->
            <%
                String list = "";
                Cookie[] cookies = request.getCookies();
                if (cookies != null && cookies.length >= 0) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("listViewCookie")) {
                            list = cookie.getValue();
                        }
                    }
                }

                list += request.getParameter("id") + ",";
                String[] arr = list.split(",");
                if (arr.length >= 1000) {
                    list = "";
                }

                Cookie cookie = new Cookie("listViewCookie", list);
                response.addCookie(cookie);
            %>
          <td width="30%" bgcolor="#EEE" align="center">
             <br>
             <b>您浏览过的商品</b><br>
             <!-- 循环开始 -->
              <%
                  List<Items> itemsList = itemsDao.getViewList(list);
                  if (itemsList != null && itemsList.size() > 0) {
                      for (Items items : itemsList) {

              %>
             <div>
             <dl>
               <dt>
                 <a href="details_pro01.jsp?id=<%=items.getId()%>"><img src="images/<%=items.getPicture() %>" width="120" height="90" border="1"/></a>
               </dt>
               <dd class="dd_name"><%=items.getName() %></dd>
               <dd class="dd_city">产地:<%=items.getCity() %>&nbsp;&nbsp;价格:<%=items.getPrice() %> ￥ </dd>
             </dl>
             </div>
              <%
                      }
                  }
              %>
             <!-- 循环结束 -->
          </td>
        </tr>
      </table>
    </center>
  </body>
</html>
