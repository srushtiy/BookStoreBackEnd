package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.Cart;

public interface CartDAO {

	public List<Cart> list();

	public Cart get(String id);
	
	public void saveOrUpdate(Cart cart);

	public void delete(String id);

}
