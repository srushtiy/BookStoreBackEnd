package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.Product;

public interface ProductDAO {
	List<Product> productlist();

	Product get(String id);

	void saveorUpdate(Product product);

	void delete(String id);

}
