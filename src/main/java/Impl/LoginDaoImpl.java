package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.LoginDao;
import Utility.DButility;

public class LoginDaoImpl implements LoginDao 
{

	@Override
	public boolean userLogin(String emailId, String CPassword) {
		try 
		{
			Connection con=DButility.getConnect();
			String sql="select * from Customer where emailId=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, emailId);
			
			ResultSet rs=ps.executeQuery();

			if(rs.next())//checking if rs has any data
			{
				String pass=rs.getString("custPass");//sp123

				if(pass.equals(CPassword))
				{
					return true;
				}
				else
				{
					return false;
				}
			}


		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean userChangePassword(String custName, String newPassword) {
		try 
		{
			Connection con=DButility.getConnect();
			String sql="update Customer set custPass=? where custName=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(2, custName);
			ps.setString(1, newPassword);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}else {
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean adminLogin(String adminName, String adminPassword) {
		try {
			Connection con=DButility.getConnect();
			String sql="select * from admin where adUsername=?";
			PreparedStatement ps=con.prepareStatement(sql);

			ps.setString(1,adminName);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				String pass=rs.getString("adPassword");
				if(pass.equals(adminPassword))
				{

					return true;
				}
				else
				{
					return false;
				}
			}	

		}catch(Exception a)
		{
			a.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean adminChangePassword(String adminUserName, String adminNewPassword) {
		try {
			String sql="update admin set adPassword=? where adUsername=?";

			Connection con=DButility.getConnect();

			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,adminNewPassword);
			ps.setString(2, adminUserName);

			int i=ps.executeUpdate();

			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return false;
	}

}
