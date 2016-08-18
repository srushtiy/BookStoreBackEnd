package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.UserAuthority;

public interface UserAuthorityDAO {
	void saveOrUpdate(UserAuthority userauth);

/*	void edit(UserAuthority userauth);
*/		
	UserAuthority get(String userauth_id);
		
	List<UserAuthority> list();
}
