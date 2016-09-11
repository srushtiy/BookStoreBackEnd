package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.Customer;
import com.niit.bookstore.model.User;
import com.niit.bookstore.model.UserAuthority;

public interface UserDAO {
	List<User> list();

	User get(String userid);

	void saveorUpdate(User user);
	
	User getbyUsername(String username);

	/*void delete(String id);*/
	boolean isValidUser(String username, String password);
	
	/*String getrole(String userid);
	
	String getcustomerid(String userid);*/

}
