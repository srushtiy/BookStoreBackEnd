package com.niit.bookstore.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="supplier")
@Component
public class Supplier {
	
	@Id
	private String supid;
	private String supname;
	private String supaddress;
	private String supcontact;
	private String supemail;
	public String getSupid() {
		return supid;
	}
	public void setSupid(String supid) {
		this.supid = supid;
	}
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
	public String getSupaddress() {
		return supaddress;
	}
	public void setSupaddress(String supaddress) {
		this.supaddress = supaddress;
	}
	public String getSupcontact() {
		return supcontact;
	}
	public void setSupcontact(String supcontact) {
		this.supcontact = supcontact;
	}
	public String getSupemail() {
		return supemail;
	}
	public void setSupemail(String supemail) {
		this.supemail = supemail;
	}
	
	public Supplier(){
		this.supid = 'S'+ UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
}
