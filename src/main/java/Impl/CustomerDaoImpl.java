package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.CustomerDao;
import POJO.Customer;
import Utility.DButility;

public class CustomerDaoImpl implements CustomerDao 
{

	@Override
	public boolean addCustomer(Customer c) 
	{
		try
		{
			Connection con=DButility.getConnect();
			
			String sql= "insert into Customer(custName,emailId,custPass,custAdd,custContact,custLoc) values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			 
			ps.setString(1, c.getCustName()); 
			ps.setString(2, c.getEmailId());
			ps.setString(3, c.getCustPassword());
			ps.setString(4, c.getCustAddress());
			ps.setString(5, c.getContactNo());
			ps.setString(6, c.getCustLocation());
			
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
	public boolean deleteCustomer(String emailId) 
	{
		try
		{
			Connection con=DButility.getConnect();
			
			String sql="delete from Customer where emailId=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, emailId);
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
	public boolean updateCustomer(Customer c1)
	{
		try
		{
		Connection con=DButility.getConnect();
		
		String sql="update Customer set custName=?,custAdd=?,custContact=?,custLoc=? where emailId=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, c1.getCustName());
		ps.setString(2, c1.getCustAddress());
		ps.setString(3, c1.getContactNo());
		ps.setString(4, c1.getCustLocation());
		ps.setString(5, c1.getEmailId());
		
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
	public Customer searchByEmailId(String emailId)
	{
		//List<Customer> li=new ArrayList<>();
		
		Customer c=null;
		try
		{
			String sql="select custName,emailId,custPass,custAdd,custContact,custLoc from Customer where emailId=?";
			Connection con=DButility.getConnect();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, emailId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				c=new Customer();
				c.setCustName(rs.getString(1));
				c.setEmailId(rs.getString(2));
				c.setCustPassword(rs.getString(3));
				c.setCustAddress(rs.getString(4));
				c.setContactNo(rs.getString(5));
				c.setCustLocation(rs.getString(6));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Customer> getAllCustomer() 
	{
		List<Customer> l=new ArrayList<Customer>();
		try
		{
			String sql="select * from Customer";
			Connection con=DButility.getConnect();
			
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			Customer c=new Customer();
			c.setCustName(rs.getString(1));
			c.setEmailId(rs.getString(2));
			c.setCustPassword(rs.getString(3));
			c.setCustAddress(rs.getString(4));
			c.setContactNo(rs.getString(5));
			c.setCustLocation(rs.getString(6));
			
			l.add(c);
			
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
