package com.niit.bookstore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bookstore.dao.ProductDAO;
import com.niit.bookstore.model.Product;


public class ProductTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.bookstore");
		context.refresh();
		
		
	   ProductDAO productDAO = 	(ProductDAO) context.getBean("productDAO");
	   
	   Product product = 	(Product) context.getBean("product");
	   product.setId("P100");
	   product.setName("The Da Vinci Code");
	   product.setDescription("History Fiction");
	   
	   
	  productDAO.saveorUpdate(product);


	}

}
