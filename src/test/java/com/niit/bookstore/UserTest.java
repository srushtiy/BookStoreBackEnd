package com.niit.bookstore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.bookstore.dao.UserDAO;
import com.niit.bookstore.model.User;

public class UserTest {
	public static void main(String[] args){
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	
	context.scan("com.niit.bookstore");
	context.refresh();
	
	
   UserDAO userDAO = 	(UserDAO) context.getBean("userDAO");
   
   User user = 	(User) context.getBean("user");
   user.setId("U100");
   user.setName("Dan Brown");  
   user.setGender("M");
   user.setEmail("dan_b@gmail.com");
   user.setContact(93200677);
   
  userDAO.saveorUpdate(user);


}

}
