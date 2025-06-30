package POJO;

import java.time.LocalDateTime;

public class OrderFood 
{
	/*
	 * 1) create String orderStatus
	 * 2) remove the parameterized constructor
	 * 3) alt+shift+s---> generate constructor using field
	 * 4) alt+shift+s---> generate getter setter
	 * 
	 * Change String orderDate to LocalDateTime orderDate
	 * 1) variable
	 * 2) parameter of constructor
	 * 3) getter return type
	 * 4) setter parameter
	 */
	private int orderId;
	private LocalDateTime orderDate;
	private double totalBill;
	private String emailId;
	private String orderStatus;
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderFood()
	{
		
	}
	
	


	public OrderFood(int orderId, LocalDateTime orderDate, double totalBill, String emailId, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalBill = totalBill;
		this.emailId = emailId;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "\nOrder Id=" + orderId + "\nDate=" + orderDate + "\nTotal Bill=" + totalBill + "\nEmailId="
				+ emailId + "\nOrder Status=" + orderStatus;
	}

	
	
}
