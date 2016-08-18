package com.niit.bookstore.model;

import java.util.UUID;

import javax.persistence.Id;

public class ShippingAddress {

	@Id
	private String shippingadd_id;
	private String street;
	private String apartment;
	private String city;
	private String state;
	private String country;
	private String zip;
	public String getShippingadd_id() {
		return shippingadd_id;
	}
	public void setShippingadd_id(String shippingadd_id) {
		this.shippingadd_id = shippingadd_id;
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
	
	 public ShippingAddress(){
	    	this.shippingadd_id="SA"+UUID.randomUUID().toString().substring(27).toUpperCase();
	    }
	
}
