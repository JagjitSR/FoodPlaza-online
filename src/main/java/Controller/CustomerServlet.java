package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Impl.CustomerDaoImpl;
import Impl.LoginDaoImpl;
import POJO.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	String msg,errmsg,Email;
	boolean flag;
	Customer c=new Customer();
	CustomerDaoImpl Cimpl=new CustomerDaoImpl();
	LoginDaoImpl Ldi=new LoginDaoImpl();
	HttpSession session;
	RequestDispatcher rd;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
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
		if(process!=null && process.equals("updateProfile")) {
			Email=(String)session.getAttribute("username");
			c=Cimpl.searchByEmailId(Email);
			session.setAttribute("profile",c);
			response.sendRedirect("Profile.jsp");
		}else if(process!=null && process.equals("changePass")) {
			String CustName=request.getParameter("custName");
			String CustPass=request.getParameter("custPassword");
			flag=Ldi.userChangePassword(CustName, CustPass);
			if(flag) {
				msg="Password Successfully Changed";
				session.setAttribute("msg", msg);
				session.removeAttribute("login");
				session.removeAttribute("username");
				session.removeAttribute("password");
				rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			else {
				errmsg="Failed to change Password";
				session.setAttribute("errmsg", errmsg);
				rd=request.getRequestDispatcher("Profile.jsp");
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
		if(process!=null && process.equals("addCustomer")) {
			String custName=request.getParameter("custName");
			String emailId=request.getParameter("emailId");
			String custPassword=request.getParameter("custPassword");
			String custAddress=request.getParameter("custAddress");
			String contactNo=request.getParameter("contactNo");
			String custLocation=request.getParameter("custLocation");
			c=new Customer(custName,emailId,custPassword,custAddress,contactNo,custLocation);
			flag=Cimpl.addCustomer(c);
			if(flag) {
				msg="You have been Successfully added";
				session.setAttribute("msg", msg);
				rd=request.getRequestDispatcher("MyIndex.jsp");
				rd.forward(request, response);
			}
			else {
				errmsg="Please Try Again";
				session.setAttribute("errmsg", errmsg);
				rd=request.getRequestDispatcher("AddCustomer.jsp");
				rd.forward(request, response);
			}
		}else if(process!=null && process.equals("updateProfile")) {
			String CustName=request.getParameter("custName");
			String CustEmail=(String)session.getAttribute("username");
			String CustPass=(String)session.getAttribute("password");
			String CustAdd=request.getParameter("custAddress");
			String CustCont=request.getParameter("contactNo");
			String CustLoc=request.getParameter("custLocation");
			c=new Customer(CustName,CustEmail,CustPass,CustAdd,CustCont,CustLoc);
			flag=Cimpl.updateCustomer(c);
			if(flag) {
				msg="Details Changed Successfully";
				session.setAttribute("msg", msg);
				c=Cimpl.searchByEmailId(Email);
				session.setAttribute("profile",c);
				rd=request.getRequestDispatcher("Profile.jsp");
				rd.forward(request, response);
			}else {
				errmsg="Failed to Change Details";
				session.setAttribute("errmsg", errmsg);
				rd=request.getRequestDispatcher("Profile.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}

}
