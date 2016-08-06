package com.niit.bookstore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bookstore.dao.CartDAO;
import com.niit.bookstore.model.Cart;

public class CartTest {
	public static void main(String[] args){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.bookstore");
		context.refresh();
		
		
	   CartDAO cartDAO = 	(CartDAO) context.getBean("cartDAO");
	   
	   Cart cart = 	(Cart) context.getBean("cart");
	   cart.setId("C001");
	   cart.setDescription("CDesc100");
	   cart.setPrice(179.8);
	   cart.setProduct_name("Harry Potter and the Curse Child");
	   cart.setQuantity(1);
	   
	   
	   cartDAO.saveOrUpdate(cart);
	   
	   
	   
	  if(   cartDAO.get("sdfsf") ==null)
	  {
		  System.out.println("cart does not exist");
	  }
	  else
	  {
		  System.out.println("cart exist .. the details are ..");
		  System.out.println();
	  }
		
		
	}
}
