package com.niit.bookstore.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table
@Component
public class BillingAddress {
	@Id
	private String billingadd_id;
	private String street;
	private String apartment;
	private String city;
	private String state;
	private String country;
	private String zip;
	public String getBillingadd_id() {
		return billingadd_id;
	}
	public void setBillingadd_id(String billingadd_id) {
		this.billingadd_id = billingadd_id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getApartment() {
		return apartment;
	}
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public BillingAddress(){
		this.billingadd_id = "BA" + UUID.randomUUID().toString().substring(24).toUpperCase(); 
	}
	
	
}
