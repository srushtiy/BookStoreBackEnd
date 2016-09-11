package com.niit.bookstore.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String cartid;
	private String customer_id;
	private double total_price;
	private int no_of_products;
	/*private String status;*/
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public int getNo_of_products() {
		return no_of_products;
	}
	public void setNo_of_products(int no_of_products) {
		this.no_of_products = no_of_products;
	}

	public Cart(){
		this.cartid="CART"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
}
