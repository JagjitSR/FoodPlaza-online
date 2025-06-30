package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.FoodDao;
import POJO.Food;
import Utility.DButility;

public class FoodDaoImpl implements FoodDao{

	@Override
	public boolean addFood(Food f) 
	{
		try
		{
			Connection con=DButility.getConnect();

			String sql= "insert into Food(foodName,foodType,foodCategory,foodDesc,foodPrice,image) values(?,?,?,?,?,?)";
			//insert into Food_ctol18(foodName,foodType,foodCategory,foodDesc,foodPrice,image) values(Jalebi, Veg , Sweet,?)
			PreparedStatement ps=con.prepareStatement(sql);

			//ps.setInt(1, f.getFoodId()); 
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getFoodType());
			ps.setString(3, f.getFoodCategory());
			ps.setString(4, f.getFoodDesc());
			ps.setDouble(5, f.getFoodPrice());
			ps.setString(6, f.getImage());

			int i=ps.executeUpdate();//will execute the sql query in the mysql database
			if(i>0)
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteFood(int foodId)
	{
		try
		{
			Connection con =DButility.getConnect();

			String sql="delete from Food where foodId=?";
			PreparedStatement ps=con.prepareStatement(sql);

			ps.setInt(1, foodId);

			int i=ps.executeUpdate();
			if(i>0)
				return true;
			else 
				return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean updateFood(Food f) 
	{
		try 
		{
			Connection con=DButility.getConnect();

			String sql="update Food set foodName=?,foodType=?,foodCategory=?,foodDesc=?,foodPrice=?,image=? where foodId=?";

			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, f.getFoodName());
			ps.setString(2,f.getFoodType());
			ps.setString(3,f.getFoodCategory());
			ps.setString(4,f.getFoodDesc());
			ps.setDouble(5, f.getFoodPrice());
			ps.setString(6, f.getImage());
			ps.setInt(7,f.getFoodId());

			int i=ps.executeUpdate();
			if(i>0)
				return true;
			else 
				return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Food searchFood(int foodId) 
	{
		Food f1=null;
		try
		{
			Connection con=DButility.getConnect();
			String sql="select * from Food where foodId=?";
			PreparedStatement ps=con.prepareStatement(sql);

			ps.setInt(1, foodId);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				f1=new Food();
				f1.setFoodId(rs.getInt(1));
				f1.setFoodName(rs.getString(2));
				f1.setFoodType(rs.getString(3));
				f1.setFoodCategory(rs.getString(4));
				f1.setFoodDesc(rs.getString(5));
				f1.setFoodPrice(rs.getInt(6));
				f1.setImage(rs.getString(7));
				
				return f1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Food> getAllFood() 
	{
		List<Food> l=new ArrayList<Food>();
		try 
		{
			Connection con=DButility.getConnect();
			String sql="select * from Food";
			PreparedStatement ps=con.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Food f=new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodType(rs.getString(3));
				f.setFoodCategory(rs.getString(4));
				f.setFoodDesc(rs.getString(5));
				f.setFoodPrice(rs.getDouble(6));
				f.setImage(rs.getString(7));
				l.add(f);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public List<Food> searchFoodByName(String foodName) 
	{
		List<Food> l=new ArrayList<Food>();
		try
		{
			Connection con=DButility.getConnect();
			String sql="select *from Food where foodName like ? ";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, "%"+foodName+"%");

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Food f=new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodType(rs.getString(3));
				f.setFoodCategory(rs.getString(4));
				f.setFoodDesc(rs.getString(5));
				f.setFoodPrice(rs.getDouble(6));
				f.setImage(rs.getString(7));

				l.add(f);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public List<Food> searchFoodByCategory(String Category) 
	{
		List<Food> l=new ArrayList<>();
		try
		{
			Connection con=DButility.getConnect();
			String sql="select *from Food where foodCategory=?";
			PreparedStatement ps=con.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{
				Food f=new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodType(rs.getString(3));
				f.setFoodCategory(rs.getString(4));
				f.setFoodDesc(rs.getString(5));
				f.setFoodPrice(rs.getDouble(6));
				f.setImage(rs.getString(7));

				l.add(f);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return l;
	}

}
