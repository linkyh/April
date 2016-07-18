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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  
  <body>
 
  <%
  		ItemsDAO itemsDAO=new ItemsDAO();
  		ArrayList<ItemsDB> list=itemsDAO.getAllitems();
  		for(int i=0;i<list.size();i++)
  		{
  %>
  <table>
    <tr>
    <td>
    <%
    	ItemsDB item=list.get(i);
     %>
     <a href="MyJsp.jsp?message=<%=item.getId() %>">
     <img alt="" src="images/<%=item.getPicture()%>">
     </a>
    
    </td>
    <td>
    商品名称：<%=item.getName() %>
    </td>
    <td>
    数量：<%=item.getNumber() %>
    </td>
    <td>
    价格：<%=item.getPrice() %>
    </td>
     <%
    	} 
    %>
    </tr>
    </table>
  </body>
</html>
