package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.User;

public interface UserDAO {
	List<User> list();

	User get(String userid);

	void saveorUpdate(User user);
	
	User getbyUsername(String username);

	/*void delete(String id);*/

}
