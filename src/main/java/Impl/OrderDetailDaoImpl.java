package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.OrderDetailDao;
import POJO.Cart;
import POJO.OrderDetails;
import Utility.DButility;

public class OrderDetailDaoImpl implements OrderDetailDao {

	Connection con = null;
	String sql = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<OrderDetails> odlist = null;
	List<Cart> clist = null;

	public boolean addToOrderDetails(String EmailId) {
		int OrderID;
		con = DButility.getConnect();
		sql = "SELECT orderId FROM OrderFood WHERE cEmail=? ORDER BY orderId DESC LIMIT 1;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, EmailId);
			rs = ps.executeQuery();
			if (rs.next()) {
				OrderID = rs.getInt("orderId");
			} else {
				System.out.println("No OrderID found");
				return false;
			}

			clist = new CartDaoImpl().searchCartByEmailId(EmailId);
			if (clist == null || clist.isEmpty()) {
				System.out.println("Clist is Empty");
				return false;
			}

			sql = "insert into OrderDetails(orderId, foodId, fname, fquantity,fprice,totalPrice) values (?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			for (Cart c : clist) {
				ps.setInt(1, OrderID);
				ps.setInt(2, c.getFoodid());
				ps.setString(3, c.getFname());
				ps.setInt(4, c.getFquantity());
				ps.setDouble(5, c.getFprice());
				ps.setDouble(6, c.getTotalPrice());
				ps.addBatch(); // Use batch to improve performance
			}

			int[] inserted = ps.executeBatch(); // Execute all inserts together

			if (inserted.length == clist.size()) {
				new CartDaoImpl().deleteCartByEmail(EmailId);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<OrderDetails> showMyOrderDetails(int orderId) {
		con=DButility.getConnect();
		sql="select * from OrderDetails where orderId=?";
		//orderId,foodId,fname,fquantity,fprice,totalPrice,OrderStatus
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, orderId);
			rs=ps.executeQuery();
			odlist=new ArrayList<>();
			
			while(rs.next()) {
				OrderDetails od=new OrderDetails();
				od.setOrderDetailId(rs.getInt(1));
				od.setOrderId(rs.getInt(2));
				od.setFoodId(rs.getInt(3));
				od.setFname(rs.getString(4));
				od.setFquantity(rs.getString(5));
				od.setFprice(rs.getInt(6));
				od.setTotalPrice(rs.getInt(7));
				od.setOrderStatus(rs.getString(8));
				odlist.add(od);
			}
			return odlist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<OrderDetails> showAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
