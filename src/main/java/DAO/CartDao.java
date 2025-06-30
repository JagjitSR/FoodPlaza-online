package DAO;

import java.util.List;

import POJO.Cart;

public interface CartDao
{
	boolean addToCart(Cart cart);
	List<Cart> showCartList();
	List<Cart>searchCartByEmailId (String cEmail);
	Cart searchCartById(int cartid);
	boolean deleteCartById(int cartid);
	boolean deleteCartByEmail(String email);
	boolean updateCart(int cartid,int fquantity);
}
