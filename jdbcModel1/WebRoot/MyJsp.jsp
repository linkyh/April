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
	<link href="css/main.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/lhgcore.js"></script>
    <script type="text/javascript" src="js/lhgdialog.js"></script>
	<script type="text/javascript">
	
	//数量增加和减少的js方法
      function sub()
      {
         var num = parseInt(document.getElementById("number").value);
         if(num>1)
         {
            document.getElementById("number").value = --num;
         }
         else{
         	alert("已达最小数量，无法修改！");
         }
      }
      function add(){
      	var num=parseInt(document.getElementById("number").value);
      	if(num<100){
      		document.getElementById("number").value=++num;
      	}
      	else{
         	alert("已达最大数量100，无法修改！");
         }
      }
      
      function selflog_show(id)
      { 
      	 var num =  document.getElementById("number").value;
         J.dialog.get({id: 'haoyue_creat',title: '购物成功',width: 600,height:400, link: '<%=path%>/servlet/CartServlet?id='+id+'&num='+num+'&name='+name+'&method=add', cover:true});
      /* alert(""); */
      }
	</script>

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
    <tr>
    <td>
    	<strong>购买数量：</strong><span id="sub" onclick="sub();">--</span>
    	<input type="text" id="number" name="number" value="1" size="3" />
    	<span id="add" onclick="add();">+</span>
    </td>
    <td>
    <div id="cart">
               <img src="images/buy_now.png"><a href="javascript:selflog_show(<%=item.getId()%>)"><img src="images/in_cart.png"></a><a href="servlet/CartServlet?action=show"><img src="images/view_cart.jpg"/></a>
             </div>
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
