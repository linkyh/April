<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@page import="DAO.ItemsDAO" %>
<%@page import="entity.ItemsDB" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center>
      <img src="images/add_cart_success.jpg"/>
      <hr>
      <% 
      System.out.println("商品名称：");
         String id = request.getParameter("id");
         String num = request.getParameter("num");
         ItemsDAO itemsDAO=new ItemsDAO();
  			ItemsDB item=itemsDAO.getItemById(Integer.parseInt(request.getParameter("id")));
         
      %>
             您成功购买了<%=num%>件的<%=item.getName() %>商品&nbsp;&nbsp;&nbsp;&nbsp;
      <br>
      <br>
      <br>
      
    </center>
  </body>
</html>
