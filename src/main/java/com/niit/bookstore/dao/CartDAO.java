package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.Cart;

public interface CartDAO {

	List<Cart> list();

	Cart getbyuserid(String userid);
	
	void saveOrUpdate(Cart cart);

	void delete(String cartid);
	

}
