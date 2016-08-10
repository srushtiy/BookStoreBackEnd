package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.User;

public interface UserDAO {
	List<User> userlist();

	User get(String userid);

	void saveorUpdate(User user);
	
	User fetchbyUsername(String username);

	/*void delete(String id);*/

}
