package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.Cart;

public interface CartDAO {

	List<Cart> list();

	Cart getbycustomerid(String customer_id);
	
	void saveOrUpdate(Cart cart);

	void delete(String cartid);
	
	/*Cart getbyuserid(String username);*/
	

}
