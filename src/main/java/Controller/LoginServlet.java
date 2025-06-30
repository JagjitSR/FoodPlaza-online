package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Impl.LoginDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDaoImpl ldi=new LoginDaoImpl();
	boolean flag;
	String msg,errmsg,login=null;
	HttpSession session=null;
	RequestDispatcher rd=null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//PrintWriter out=response.getWriter();
		session=request.getSession();
		String process=request.getParameter("process");
		if(process!=null && process.equals("logout")) {
			session.removeAttribute("login");
			session.removeAttribute("username");
			session.removeAttribute("password");
			msg="Logged Out Successfully :)";
			session.setAttribute("msg", msg);
			//session.invalidate();
			rd=request.getRequestDispatcher("MyIndex.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//PrintWriter out=response.getWriter();
		session=request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("pass");
		flag=ldi.userLogin(username, password);
		if(flag){
			login="customer";
			session.setAttribute("login", login);
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			msg="LogIn Successfull :)";
			session.setAttribute("msg", msg);
			rd=request.getRequestDispatcher("MyIndex.jsp");
			rd.forward(request, response);
		}
		else {
			flag=ldi.adminLogin(username, password);
			if(flag){
				login="admin";
				session.setAttribute("login", login);
				session.setAttribute("username", username);
				msg="LogIn Successfull :)";
				session.setAttribute("msg", msg);
				rd=request.getRequestDispatcher("MyIndex.jsp");
				rd.forward(request, response);
			}else {
			errmsg="login Failed :(";
			session.setAttribute("errmsg", errmsg);
			rd=request.getRequestDispatcher("MyIndex.jsp");
			rd.forward(request, response);
			}
		}
	}

}
