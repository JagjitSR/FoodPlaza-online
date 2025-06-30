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

import Impl.FoodDaoImpl;
import POJO.Food;

/**
 * Servlet implementation class FoodServlet
 */
@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Food f=null;
	FoodDaoImpl fdi=new FoodDaoImpl();
	String msg,errmsg,login;
	List<Food> list=null;
	HttpSession session=null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet() {
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
		if(process!=null && process.equals("allFood")) {
			list=fdi.getAllFood();
			session.setAttribute("list",list);
			response.sendRedirect("FoodList.jsp");
		}
		else if(process!=null && process.equals("updateFood")) {
			int foodId=Integer.parseInt(request.getParameter("foodId"));
			f=fdi.searchFood(foodId);
			session.setAttribute("foodobj", f);
			response.sendRedirect("UpdateFood.jsp");
		}
		else if(process!=null && process.equals("deleteFood")) {
			int foodId=Integer.parseInt(request.getParameter("foodId"));
			boolean flag=fdi.deleteFood(foodId);
			if(flag) {
				msg="Food Deleted Successfully :)";
				session.setAttribute("msg", msg);
				list=fdi.getAllFood();
				session.setAttribute("list", list);
				RequestDispatcher rd=request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
			}else {
				errmsg="Failed to Deleted Food :(";
				session.setAttribute("errmsg", errmsg);
				response.sendRedirect("FoodList.jsp");
			}
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
		String process=request.getParameter("process");
		if(process!=null && process.equals("addFood")) {
			String foodName=request.getParameter("foodName");
			String foodType=request.getParameter("foodType");
			String foodCategory=request.getParameter("foodCategory");
			String foodDesc=request.getParameter("foodDesc");
			double foodPrice=Double.parseDouble(request.getParameter("foodPrice"));
			String image=request.getParameter("image");
			
			Food f=new Food(foodName,foodType,foodCategory,foodDesc,foodPrice,image);
			boolean flag=fdi.addFood(f);
			if(flag) {
				msg="New Food Added Successfully :)";
				session.setAttribute("msg", msg);
				list=fdi.getAllFood();
				session.setAttribute("list", list);
				RequestDispatcher rd=request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
			}else {
				errmsg="Failed to Add Food :(";
				session.setAttribute("msg", errmsg);
				RequestDispatcher rd=request.getRequestDispatcher("AddFood.jsp");
				rd.forward(request, response);
			}
		}else if(process!=null && process.equals("editFood")) {

			int foodId=Integer.parseInt(request.getParameter("foodId"));
			String foodName=request.getParameter("foodName");
			String foodType=request.getParameter("foodType");
			String foodCategory=request.getParameter("foodCategory");
			String foodDesc=request.getParameter("foodDesc");
			double foodPrice=Double.parseDouble(request.getParameter("foodPrice"));
			String image=request.getParameter("image");
			Food f=new Food(foodId,foodName,foodType,foodCategory,foodDesc,foodPrice,image);
			boolean flag=fdi.updateFood(f);
			if(flag) {
				msg="Updated Food Successfully :)";
				session.setAttribute("msg", msg);
				list=fdi.getAllFood();
				session.setAttribute("list", list);
				RequestDispatcher rd=request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
			}else {
				errmsg="Failed to Update Food :(";
				session.setAttribute("msg", errmsg);
				RequestDispatcher rd=request.getRequestDispatcher("UpdateFood.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}

}
