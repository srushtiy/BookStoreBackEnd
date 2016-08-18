package com.niit.bookstore.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CartDetail {

	@Id
	private String cartdetailid;
	private String cartid;
	private String customer_id;
	private String p_id;
	private int quantity;
	private double price_total;

	public String getCartDetailID() {
		return cartdetailid;
	}

	public void setCartDetailid(String cartDetailid) {
		this.cartdetailid = cartDetailid;
	}

	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public String getP_Id() {
		return p_id;
	}

	public void setP_Id(String p_Id) {
		this.p_id = p_Id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice_total() {
		return price_total;
	}

	public void setPrice_total(double price_total) {
		this.price_total = price_total;
	}

	public String getCustomerID() {
		return customer_id;
	}

	public void setCustomerID(String customer_id) {
		this.customer_id = customer_id;
	}
	
	public CartDetail(){
		this.cartdetailid="CDI"+UUID.randomUUID().toString().substring(24).toUpperCase();
	}

}
