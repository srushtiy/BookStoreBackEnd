package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.Category;
import com.niit.bookstore.model.Product;

public interface CategoryDAO {

	public List<Category> list();

	public Category get(String catid);
	
	public void saveOrUpdate(Category category);
	
	public void delete(String catid);
	
	public List<Product> ProductListbyCat(String id);
	
/*	int getProductCountByCategory(String id);	
*/
}
