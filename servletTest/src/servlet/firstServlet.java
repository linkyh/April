package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class firstServlet extends HttpServlet {

	//重写doGet方法
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("处理doGet方法");
		PrintWriter out =response.getWriter();
		out.print("调用doGet方法成功");
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	
	//重写doPost方法
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("处理doPost方法");
		PrintWriter out =response.getWriter();
		out.print("调用doPost方法成功");
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}
	
}
