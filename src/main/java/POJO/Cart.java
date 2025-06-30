package POJO;

public class Cart 
{
	private int cartid;
	private int foodid;
	private String cEmail;
	private int fquantity;
	private String fname;
	private double fprice;
	private double totalPrice;
	
	

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	//Constructor using fields
	public Cart(int cartid, int foodid, String cEmail, int fquantity, String fname, double fprice) {
		super();
		this.cartid = cartid;
		this.foodid = foodid;
		this.cEmail = cEmail;
		this.fquantity = fquantity;
		this.fname = fname;
		this.fprice = fprice;
	}

	//Constructor 
	public Cart()
	{

	}

	public Cart(int foodid, String cEmail, int fquantity) 
	{
		super();
		this.foodid = foodid;
		this.cEmail = cEmail;
		this.fquantity = fquantity;

	}

	//Getter & Setter
	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getFoodid() {
		return foodid;
	}

	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public int getFquantity() {
		return fquantity;
	}

	public void setFquantity(int fquantity) {
		this.fquantity = fquantity;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public double getFprice() {
		return fprice;
	}

	public void setFprice(double fprice) {
		this.fprice = fprice;
	}

	//ToString Method
	@Override
	public String toString() {
		return "Cart id= " + cartid + "\nFood id= " + foodid + "\nEmail= " + cEmail + "\nQuantity= " + fquantity
				+ "\nFood name= " + fname + "\nPrice of single item= " + fprice + "\nTotal price= "+totalPrice;
	}




	/*
	public Cart() {

	}
	public Cart(int foodId, int cartId, double foodPrice, int foodQuantity, double totalPrice, String emailId,
			String foodName) {
		super();
		this.foodId = foodId;
		this.cartId = cartId;
		this.foodPrice = foodPrice;
		this.foodQuantity = foodQuantity;
		this.totalPrice = totalPrice;
		this.emailId = emailId;
		this.foodName = foodName;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public int getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}


	@Override
	public String toString() {
		return "Cart [foodId=" + foodId + ", cartId=" + cartId + ", foodPrice=" + foodPrice + ", foodQuantity="
				+ foodQuantity + ", totalPrice=" + totalPrice + ", emailId=" + emailId + ", foodName=" + foodName + "]";
	}
	 */


}
