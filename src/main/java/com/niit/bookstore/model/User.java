package com.niit.bookstore.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class User {

	@Id
	private String userid; // should match with path
	private String first_name;
	private String last_name;

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUserid() {
		return userid;
	}

	private String password;
	private String useremail;
	private String gender;
	private String usercontact;
	private String address;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsercontact() {
		return usercontact;
	}

	public void setUsercontact(String usercontact) {
		this.usercontact = usercontact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public User(){
		this.userid = "U" + UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
}
