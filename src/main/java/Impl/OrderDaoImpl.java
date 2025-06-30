package Impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import DAO.OrderDao;
import POJO.OrderFood;
import Utility.DButility;

public class OrderDaoImpl implements OrderDao {
	
	Connection con=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	List<OrderFood> olist=null;
	
//	private int orderId;
//	private LocalDateTime orderDate;
	private double totalBill;
//	private String emailId;
//	private String orderStatus;
	
	@Override
	public boolean placeOrder(OrderFood o,String EmailId) {
		
		LocalDateTime dt=LocalDateTime.now();//to get current date and time
		
		DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		/*
		 * We have fomatted our date according to our preference as given in the 
		 * DateTimeFormatter
		 */
		String formattedDateTime=dt.format(format); 
		
		totalBill=calculateBill(o.getEmailId());
		
		con=DButility.getConnect();
		sql="insert into OrderFood(orderDate, totalBill, cEmail, orderStatus) values (?, ?, ?, ?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setTimestamp(1, Timestamp.valueOf(formattedDateTime));//we have converted our String date into Sql type datetime
			ps.setDouble(2, totalBill);
			ps.setString(3, o.getEmailId());
			ps.setString(4, o.getOrderStatus());
			
			int i=ps.executeUpdate();
			if(i>0) {
				new OrderDetailDaoImpl().addToOrderDetails(EmailId);
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public OrderFood showOrderById(int orderId) {
		con=DButility.getConnect();
		sql="select * from OrderFood where orderId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, orderId);
			
			rs=ps.executeQuery();
			
			
			while(rs.next()) {
				
				OrderFood o=new OrderFood();
				o.setOrderId(rs.getInt(1));
				o.setOrderDate(rs.getTimestamp(2).toLocalDateTime());
				o.setTotalBill(rs.getDouble(3));
				o.setEmailId(rs.getString(4));
				o.setOrderStatus(rs.getString(5));
				
				return o;
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderFood> showAllOrder() {
		con=DButility.getConnect();
		sql="select * from OrderFood";
		
		try {
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			olist=new ArrayList<>();
			
			while(rs.next()) {
				
				OrderFood o=new OrderFood();
				o.setOrderId(rs.getInt(1));
				o.setOrderDate(rs.getTimestamp(2).toLocalDateTime());
				o.setTotalBill(rs.getDouble(3));
				o.setEmailId(rs.getString(4));
				o.setOrderStatus(rs.getString(5));
				
				olist.add(o);
			}
			
			return olist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean changeOrderStatus(String orderStatus, int orderId) {
		con=DButility.getConnect();
		sql="update OrderFood set orderStatus=? where orderId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, orderStatus);
			ps.setInt(2, orderId);
			
			int i=ps.executeUpdate();
			
			if(i>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<OrderFood> showMyOrderHistory(String emailId) {
		con=DButility.getConnect();
		sql="select * from OrderFood where cEmail=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, emailId);
			
			rs=ps.executeQuery();
			olist=new ArrayList<>();
			
			while(rs.next()) {
				
				OrderFood o=new OrderFood();
				o.setOrderId(rs.getInt(1));
				o.setOrderDate(rs.getTimestamp(2).toLocalDateTime());
				o.setTotalBill(rs.getDouble(3));
				o.setEmailId(rs.getString(4));
				o.setOrderStatus(rs.getString(5));
				
				olist.add(o);
			}
			
			return olist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public double calculateBill(String emailId) {
		con=DButility.getConnect();
		sql="select totalPrice from Cart where cEmail=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, emailId);
			
			rs=ps.executeQuery();
			totalBill=0;//320
			
			while(rs.next()) {//false
				
			totalBill+=rs.getDouble("totalPrice");//totalBill=320
			
			}
			return totalBill;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
