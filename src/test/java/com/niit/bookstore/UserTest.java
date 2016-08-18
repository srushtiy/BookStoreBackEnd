/*package com.niit.bookstore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bookstore.dao.UserDAO;
import com.niit.bookstore.model.User;

public class UserTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.bookstore");
		context.refresh();
		
		User user = (User)context.getBean("user");
		
		UserDAO userDAO =(UserDAO)context.getBean("userDAO");
		
		user.setUseremail("danbrown@gmail.com");
		user.setUsercontact("9920766556");
		user.setGender("Male");
		user.setPassword("danbrown");
		
		
		userDAO.saveorUpdate(user);
	}
}*/