package com.niit.bookstore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bookstore.dao.ULoginDAO;
import com.niit.bookstore.dao.UserDAO;
import com.niit.bookstore.model.ULogin;

public class ULoginTest {
	public static void main(String[] args){
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	
	context.scan("com.niit.bookstore");
	context.refresh();
	
	
   ULoginDAO uloginDAO = 	(ULoginDAO) context.getBean("uLoginDAO");
   
   ULogin uLogin = 	(ULogin) context.getBean("ulogin");
   uLogin.setLoginID("001");
   uLogin.setUsername("danbrown");  
   uLogin.setPassword("danbrown");
   uLogin.setLogin(true);
   
   uloginDAO.saveOrUpdate(uLogin);


}

}
