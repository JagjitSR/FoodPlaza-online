package DAO;

import java.util.List;

import POJO.OrderDetails;

public interface OrderDetailDao {
	boolean addToOrderDetails(String EmailId);
	public List<OrderDetails> showMyOrderDetails(int orderId);
	List<OrderDetails> showAllOrder();
}
