package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class firstServlet extends HttpServlet {

	//��дdoGet����
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("����doGet����");
		PrintWriter out =response.getWriter();
		out.print("����doGet�����ɹ�");
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	
	//��дdoPost����
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("����doPost����");
		PrintWriter out =response.getWriter();
		out.print("����doPost�����ɹ�");
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}
	
}
