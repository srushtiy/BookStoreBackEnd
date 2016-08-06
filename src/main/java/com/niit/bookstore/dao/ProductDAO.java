package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.Product;

public interface ProductDAO {
	public List<Product> productlist();

	public Product get(String id);

	public void saveorUpdate(Product product);

	public void delete(String id);

}
