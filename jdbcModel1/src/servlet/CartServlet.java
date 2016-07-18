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
	
	
	//添加商品进购物车的方法
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));
		int number=Integer.parseInt(request.getParameter("num"));
		ItemsDB items=iDAO.getItemById(id);
		//判断是不是第一次加入购物车，若是，则在session中创建一个购物车对象
		if(request.getSession().getAttribute("cart")==null){
			scart cart=new scart();
			request.getSession().setAttribute("cart", cart);
		}
		//若已存在购物车，则直接调用
		scart cart=(scart)request.getSession().getAttribute("cart");
		
		//再调用购物车类中的添加进购物车的方法
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
