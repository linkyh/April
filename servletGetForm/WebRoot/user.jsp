<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="java.text.*" %>

<!-- 日期的排列格式编写，提前导入 -->
<%String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style type="text/css">
	 .title{
		 width: 30%;	
		 background-color: #CCC;
		 font-weight: bold;
	 }
	 .content{
	     width:70%;
	     background-color: #CBCFE5;
	 }
	 
   </style>  
  </head>
  
  <body>
  <jsp:useBean id="UserInfo" class="entity.User" scope="session"></jsp:useBean>
 <!--  property中对应的名字是对应实体类中的 -->
    <h1>用户信息</h1>
    <hr>
    <center>
     <table width="600" cellpadding="0" cellspacing="0" border="1">
        <tr>
          <td class="title">用户名：</td>
          <td class="content">&nbsp;<jsp:getProperty name="UserInfo" property="userName"/></td>
        </tr>
        <tr>
          <td class="title">密码：</td>
          <td class="content">&nbsp;<jsp:getProperty name="UserInfo" property="passWord"/></td>
        </tr>
        <tr>
          <td class="title">性别：</td>
          <td class="content">&nbsp;<jsp:getProperty name="UserInfo" property="gender"/></td>
        </tr>
        <tr>
          <td class="title">E-mail：</td>
          <td class="content">&nbsp;<jsp:getProperty name="UserInfo" property="email"/></td>
        </tr>
        <tr>
          <td class="title">出生日期：</td>
          <td class="content">&nbsp;
          <%
          	SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
          	String date=sdf.format(UserInfo.getBirthday());
          	System.out.println(date);
           %>
           <%=date %></td>
          
        </tr>
        <tr>
          <td class="title">爱好：</td>
          <td class="content">&nbsp;
          <%
          	String[] favorites=UserInfo.getFavorites();
          	for(String f:favorites){
           %>
           <%=f %>&nbsp;&nbsp;
           <%
           	}
            %>
          	
          </td>
        </tr>
        <tr>
          <td class="title">自我介绍：</td>
          <td class="content">&nbsp;<jsp:getProperty name="UserInfo" property="interduce"/></td>
        </tr>
        <tr>
          <td class="title">是否接收协议：</td>
          <td class="content">&nbsp;<jsp:getProperty name="UserInfo" property="flg"/></td>
        </tr>
     </table>
    </center>
  </body>
</html>

