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
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
  <%
  	ItemsDAO itemsDAO=new ItemsDAO();
  	ItemsDB item=itemsDAO.getItemById(Integer.parseInt(request.getParameter("message")));
  	if(item!=null){
   %>
    <table>
  <tr>
  <td>
    <table>
    <tr>
    <td>
    <img alt="" src="images/<%=item.getPicture()%>">
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
    <td>
    细节描述：<%=item.getDelite() %>
    </td>
    </tr>
    </table>
    <%} %>
     </td>
     <td style="width:300px">
     </td>
  <td style="width:300px">
  <%
  	String list="";
  	Cookie[] cookies=request.getCookies();
  	//System.out.print("cookie长度："+cookies.length);
  	if(cookies!=null&&cookies.length>0){
  	for(Cookie c:cookies){
  		if(c.getName().equals("listViewCookie")){
  			list=c.getValue();
  		}
  	}
  	}
  	list+=request.getParameter("message")+",";
  	
  	//当浏览记录过多时进行清零处理
  	String[] arr=list.split(",");
  	if(arr!=null&&arr.length>0){
  		if(arr.length>=1000){
  			list="";
  		}
  	}
  	
  	Cookie cookie=new Cookie("listViewCookie",list);
  	response.addCookie(cookie);
   %>
  <h1>浏览过的商品列表:</h1> 
  <hr>
  <%
  	ArrayList<ItemsDB> itemList=itemsDAO.getViewList(list);
  	//System.out.print(itemList);
  	if(itemList!=null&itemList.size()>0){
  	
  		for(ItemsDB i:itemList){
  		
   %>
  <dl>
  	<dd>
  	<img alt="" src="images/<%=i.getPicture()%>">
  	
  	</dd>
  	<dd>
  	商品名称：<%=i.getName() %>
  	</dd>
  	<dd>
  	商品价格：<%=i.getPrice() %>
  	</dd>
  	<dd>
  	商品数量：<%=i.getNumber() %>
  	</dd>
  </dl>
  <%
  		}
  	}
   %>
  <!-- <table>
  <tr>
  
  </tr>
  </table> -->
  </td>
  </tr>
   </table>
  </body>
</html>
