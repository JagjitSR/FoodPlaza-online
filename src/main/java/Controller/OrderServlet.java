package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Impl.CartDaoImpl;
import Impl.OrderDaoImpl;
import Impl.OrderDetailDaoImpl;
import POJO.Cart;
import POJO.OrderDetails;
import POJO.OrderFood;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	boolean flag;
	String orderStatus,msg,errmsg;
	OrderFood o=new OrderFood();
	OrderDetailDaoImpl odimpl=new OrderDetailDaoImpl();
	OrderDaoImpl oimpl=new OrderDaoImpl();
	CartDaoImpl cimpl=new CartDaoImpl();
	List<OrderDetails> odlist;
	List<OrderFood> olist;
	List<Cart> clist;
	HttpSession session=null;
	RequestDispatcher rd=null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		if(process!=null && process.equals("myOrders")) {
			String cEmail=(String)session.getAttribute("username");
			olist=oimpl.showMyOrderHistory(cEmail);
			if(olist==null && olist.isEmpty()) {
				errmsg="You have not ordered any food till now :(";
				session.setAttribute("errmsg", errmsg);
				rd=request.getRequestDispatcher("MyIndex.jsp");
				rd.forward(request, response);
			}else {
				session.setAttribute("olist", olist);
				rd=request.getRequestDispatcher("OrderList.jsp");
				rd.forward(request, response);
			}
		}else if(process!=null && process.equals("getDetails")){
			int OrderID=Integer.parseInt(request.getParameter("orderId"));
			odlist=odimpl.showMyOrderDetails(OrderID);
			if(odlist==null && odlist.isEmpty()) {
				errmsg="You have not ordered any food till now :(";
				session.setAttribute("errmsg", errmsg);
				rd=request.getRequestDispatcher("MyIndex.jsp");
				rd.forward(request, response);
			}else {
				session.setAttribute("odlist", odlist);
				rd=request.getRequestDispatcher("OrderDetails.jsp");
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
		session=request.getSession();
		String process=request.getParameter("process");
		if(process!=null && process.equals("placeOrder")) {
			String cEmail=(String)session.getAttribute("username");
			orderStatus="Order Confirmed";
			o.setEmailId(cEmail);
			o.setOrderStatus(orderStatus);
			flag=oimpl.placeOrder(o, cEmail);
			if(flag) {
				msg="Ordered Successfully";
				session.setAttribute("msg", msg);
				olist=oimpl.showMyOrderHistory(cEmail);
				session.setAttribute("olist", olist);
				rd=request.getRequestDispatcher("OrderList.jsp");
				rd.forward(request, response);				
			}else {
				errmsg="Failed to Order Food";
				session.setAttribute("errmsg", errmsg);
				rd=request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);				
			}
		}
		
		
	}

}
