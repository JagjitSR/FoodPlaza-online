package POJO;

public class Food 
{
	private int foodId;
	private String foodName;
	private String foodType;
	private String foodCategory;
	private String foodDesc;
	private double foodPrice;
	private String image;
	
	
	public Food(String foodName, String foodType, String foodCategory, String foodDesc, double foodPrice,
			String image) {
		super();
		this.foodName = foodName;
		this.foodType = foodType;
		this.foodCategory = foodCategory;
		this.foodDesc = foodDesc;
		this.foodPrice = foodPrice;
		this.image = image;
	}
	public Food()
	{
		
	}
	public Food(int foodId, String foodName, String foodType, String foodCategory, String foodDesc, double foodPrice,
			String image) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodType = foodType;
		this.foodCategory = foodCategory;
		this.foodDesc = foodDesc;
		this.foodPrice = foodPrice;
		this.image = image;
	}
	
	
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	public String getFoodDesc() {
		return foodDesc;
	}
	public void setFoodDesc(String foodDesc) {
		this.foodDesc = foodDesc;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	@Override
	public String toString() {
		return "Food Id=" + foodId + "\nFood Name=" + foodName + "\nFood Type=" + foodType + "\nFood Category="
				+ foodCategory + "\nFood Desc=" + foodDesc + "\nFood Price=" + foodPrice + "\nImage=" + image;
	}
	
	
	
	
	
}
