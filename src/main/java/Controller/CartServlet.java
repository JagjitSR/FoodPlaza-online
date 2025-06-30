package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Impl.CartDaoImpl;
import Impl.FoodDaoImpl;
import POJO.Cart;
import POJO.Food;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	int foodId,quantity;
	double totalPrice;
	String Email,msg,errmsg;
	boolean flag;
	Food f=null;
	FoodDaoImpl fimpl=new FoodDaoImpl();
	List<Food> list=null;
	Cart c=null;
	CartDaoImpl cimpl=new CartDaoImpl();
	List<Cart> clist=null;
	HttpSession session=null;
	RequestDispatcher rd=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		session=request.getSession();
		String process=request.getParameter("process");
		if(process!=null & process.equals("addToCart")) {
			foodId=Integer.parseInt(request.getParameter("foodId"));
			quantity=1;
			Email=(String)session.getAttribute("username");
			c=new Cart();
			c.setFoodid(foodId);
			c.setFquantity(quantity);
			c.setcEmail(Email);
			flag=cimpl.addToCart(c);
			if(flag) {
				msg="Successfully Added to your Cart";
				session.setAttribute("msg", msg);
				rd=request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
			}else {
				errmsg="Failed to Added to your Cart";
				session.setAttribute("errmsg", errmsg);
				rd=request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
			}
		}else if(process!=null && process.equals("showMyCart")){
			String cEmail=(String)session.getAttribute("username");
			clist=cimpl.searchCartByEmailId(cEmail);
			if(clist==null && clist.isEmpty()) {
				errmsg="Failed to find any items in Cart";
				session.setAttribute("errmsg", errmsg);
				list=fimpl.getAllFood();
				session.setAttribute("list", list);
				rd=request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
			}else {
				session.setAttribute("clist", clist);
				rd=request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}
		}else if(process!=null & process.equals("deleteCartItem")) {
			int cartId=Integer.parseInt(request.getParameter("cartid"));
			Email=(String)session.getAttribute("username");
			flag=cimpl.deleteCartById(cartId);
			if(flag) {
				msg="Successfully Removed 1 item from your Cart";
				session.setAttribute("msg", msg);
				clist=cimpl.searchCartByEmailId(Email);
				session.setAttribute("clist", clist);
				rd=request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}else {
				errmsg="Failed to Remove from Cart";
				session.setAttribute("errmsg", errmsg);
				rd=request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}
		}else if(process!=null & process.equals("clearCart")) {
			Email=(String)session.getAttribute("username");
			flag=cimpl.deleteCartByEmail(Email);
			if(flag) {
				msg="Successfully Cleared your Cart";
				session.setAttribute("msg", msg);
				clist=cimpl.searchCartByEmailId(Email);
				session.setAttribute("clist", clist);
				rd=request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}else {
				errmsg="Failed to Clear Cart";
				session.setAttribute("errmsg", errmsg);
				rd=request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out=response.getWriter();
		String process=request.getParameter("process");
		session=request.getSession();
		if(process!=null && process.equals("updateCartQuantity")) {
			int cartid=Integer.parseInt(request.getParameter("cartid"));
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			flag=cimpl.updateCart(cartid, quantity);
			if(flag) {
				c=cimpl.searchCartById(cartid);
				totalPrice=c.getTotalPrice();
				out.print(totalPrice);
			}
		}
	}

}
