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
	   product.setP_id("P003");
	   product.setCatid("C001");
	   product.setSupid("S001");
	   product.setP_name("On the Origins of Sports");
	   product.setP_desc("The Early History and Original Rules of Everybody’s Favorite Games");
	   product.setP_price(9.99);
	   product.setP_quantity(40);
	   product.setP_author("Neil Fine & Gary Belsky");
	   product.setOut_of_stock(false);
/*	   product.setP_img("sports.png");
*/	   
	  productDAO.saveorUpdate(product);


	}

}
