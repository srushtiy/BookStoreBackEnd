package com.niit.bookstore.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class UserAuthority{
	
	
	@Id
	private String userauth_id;
	private String username;
	private String auth_role;
	public String getUserauth_id() {
		return userauth_id;
	}

	public void setUserauth_id(String userauth_id) {
		this.userauth_id = userauth_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuth_role() {
		return auth_role;
	}

	public void setAuth_role(String auth_role) {
		this.auth_role = auth_role;
	}


	
	public UserAuthority(){
		   this.userauth_id="UA"+UUID.randomUUID().toString().substring(30).toUpperCase();
	   }
}
