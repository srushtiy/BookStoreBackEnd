package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.Product;

public interface ProductDAO {
	List<Product> productlist();
	
	List<Product> related_products(String p_id);

	Product get(String p_id);

	void saveorUpdate(Product product);

	void delete(String p_id);
	
	List<Product> getListbyCatId(String catid);
	List<Product> searchProduct(String keyword);

}
