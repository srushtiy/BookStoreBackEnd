package com.niit.bookstore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bookstore.dao.CategoryDAO;
import com.niit.bookstore.model.Category;

public class CategoryTest {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.bookstore");
		context.refresh();
		
		
	   CategoryDAO categoryDAO = 	(CategoryDAO) context.getBean("categoryDAO");
	   
	   Category category = 	(Category) context.getBean("category");
	   category.setCatid("C005");;
	   category.setCatname("Sports and Recreation");
	   category.setCatdescription("Sports, Camping,Football,Tennis");
	   
	   
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
