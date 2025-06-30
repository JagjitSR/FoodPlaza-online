package POJO;

public class OrderDetails {
	private int orderDetailId;
	private int orderId;
	private int foodId;
	private String fname;
	private String fquantity;
	private double fprice;
	private double totalPrice;
	private String orderStatus;
	
	public OrderDetails() {
		super();
	}

	public OrderDetails(int orderId, int foodId, String fname, String fquantity, double fprice, double totalPrice) {
		super();
		this.orderId = orderId;
		this.foodId = foodId;
		this.fname = fname;
		this.fquantity = fquantity;
		this.fprice = fprice;
		this.totalPrice = totalPrice;
	}

	public OrderDetails(int orderId, int foodId, String fname, String fquantity, double fprice, double totalPrice,
			String orderStatus) {
		super();
		this.orderId = orderId;
		this.foodId = foodId;
		this.fname = fname;
		this.fquantity = fquantity;
		this.fprice = fprice;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFquantity() {
		return fquantity;
	}

	public void setFquantity(String fquantity) {
		this.fquantity = fquantity;
	}

	public double getFprice() {
		return fprice;
	}

	public void setFprice(double fprice) {
		this.fprice = fprice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", foodId=" + foodId
				+ ", fname=" + fname + ", fquantity=" + fquantity + ", fprice=" + fprice + ", totalPrice=" + totalPrice
				+ ", OrderStatus=" + orderStatus + "]";
	}

	
	
	
}
