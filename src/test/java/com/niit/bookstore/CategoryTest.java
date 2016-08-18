package com.niit.bookstore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bookstore.model.Category;
import com.niit.bookstore.dao.CategoryDAO;

public class CategoryTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.bookstore");
		context.refresh();
		
	Category category = (Category) context.getBean("category");
	
	CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category.setCatid("C001");
		category.setCatname("Sports and Recreation");
		category.setCatdescription("Sports, Fitness and Recreation");

		categoryDAO.saveOrUpdate(category);
	   
	   
	   
	   /*
	  if(   categoryDAO.get("sdfsf") ==null)
	  {
		  System.out.println("Category does not exist");
	  }
	  else
	  {
		  System.out.println("Category exist .. the details are ..");
		  System.out.println();
	  }*/
		
		
		
	}

}
