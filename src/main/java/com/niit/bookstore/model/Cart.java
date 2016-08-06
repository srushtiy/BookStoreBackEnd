package com.niit.bookstore.model;

public class Cart {
	
	private String id;
	private String product_ID;
	private String product_name;
	private int quantity;
	private double price;
	private String description;
	public String getProduct_ID() {
		return product_ID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setProduct_ID(String product_ID) {
		this.product_ID = product_ID;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
