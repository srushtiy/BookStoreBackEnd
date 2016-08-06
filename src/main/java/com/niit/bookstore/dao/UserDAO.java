package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.User;

public interface UserDAO {
	public List<User> userlist();

	public User get(String id);

	public void saveorUpdate(User user);

	public void delete(String id);
	
	public boolean isValidUser(String username, String password);

}
