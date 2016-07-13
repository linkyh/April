package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User u=new User();

		String userName = null;
		String passWord=null;
		String email=null;
		String gender=null;
		Date birthday = null;
		String[] favorites = null;
		String interduce = null;
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		
		
		try {
			userName=request.getParameter("username");
			passWord=request.getParameter("mypassword");
			email=request.getParameter("email");
			gender=request.getParameter("gender");
			birthday=sdf.parse(request.getParameter("birthday"));
			favorites=request.getParameterValues("favorite");
			interduce=request.getParameter("introduce");
			System.out.println("时间是："+birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//赋值
		u.setUserName(userName);
		u.setPassWord(passWord);
		u.setBirthday(birthday);
		u.setEmail(email);
		u.setFavorites(favorites);
		u.setInterduce(interduce);
		if(request.getParameterValues("isAccept")!=null){
			u.setFlg(true);
		}
		else{
			u.setFlg(false);
		}
		u.setGender(gender);
		
		//将注册成功的信息存入session
		request.getSession().setAttribute("UserInfo", u);
		
		//页面进行服务端跳转
		request.getRequestDispatcher("../user.jsp").forward(request, response);
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
