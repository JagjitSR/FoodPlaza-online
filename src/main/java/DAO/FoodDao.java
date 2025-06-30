package DAO;

import java.util.List;

import POJO.Food;

public interface FoodDao 
{
	boolean addFood(Food f);
	boolean updateFood(Food f);
	boolean deleteFood(int foodId);
	Food searchFood(int foodId);
	
	List<Food> getAllFood();
	
	List<Food> searchFoodByName(String foodName);
	
	List<Food> searchFoodByCategory(String Category);
}
