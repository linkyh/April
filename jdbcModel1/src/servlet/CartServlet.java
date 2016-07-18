package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ItemsDB;
import entity.scart;

import DAO.ItemsDAO;

public class CartServlet extends HttpServlet {
	private String action;
	private ItemsDAO iDAO=new ItemsDAO();

	/**
	 * Constructor of the object.
	 */
	public CartServlet() {
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

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(request.getParameter("action")!=null){
			this.action=request.getParameter("action");
			if(action.equals("add")){
				if(addToCart(request,response)){
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("/failure.jsp").forward(request, response);
				}
			}
		}
	}
	
	
	//�����Ʒ�����ﳵ�ķ���
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));
		int number=Integer.parseInt(request.getParameter("num"));
		ItemsDB items=iDAO.getItemById(id);
		//�ж��ǲ��ǵ�һ�μ��빺�ﳵ�����ǣ�����session�д���һ�����ﳵ����
		if(request.getSession().getAttribute("cart")==null){
			scart cart=new scart();
			request.getSession().setAttribute("cart", cart);
		}
		//���Ѵ��ڹ��ﳵ����ֱ�ӵ���
		scart cart=(scart)request.getSession().getAttribute("cart");
		
		//�ٵ��ù��ﳵ���е���ӽ����ﳵ�ķ���
		if(cart.addGoods(items, number)){
			return true;
		}
		else{
			return false;
		}
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
		doGet(request, response);
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
