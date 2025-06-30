package DAO;

import java.util.List;

import POJO.Customer;

public interface CustomerDao {

	boolean addCustomer(Customer c);
	boolean deleteCustomer(String emailId);
	boolean updateCustomer(Customer c1);
	
	Customer searchByEmailId(String emailId);
	
	List<Customer> getAllCustomer();
}
