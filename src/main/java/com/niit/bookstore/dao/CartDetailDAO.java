package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.CartDetail;

public interface CartDetailDAO {
	
	void saveorUpdate(CartDetail cartDetail);
	
	void delete(String cartDetailid);
	
	List<CartDetail> getDetailbyCustomerId(String customer_id);
	
	CartDetail getCartItem(String cartDetailid);
	
	List<CartDetail> listCartDetails();
	

}
