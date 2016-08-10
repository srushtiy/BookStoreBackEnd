package com.niit.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CartDetail {

	@Id
	private String cartdetailid;
	private String cartid;
	private String userid;
	private String p_Id;
	private int quantity;
	private double price_total;

	public String getCartDetailID() {
		return cartdetailid;
	}

	public void setCartDetailid(String cartDetailid) {
		this.cartdetailid = cartdetailid;
	}

	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public String getP_Id() {
		return p_Id;
	}

	public void setP_Id(String p_Id) {
		this.p_Id = p_Id;
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

	public String getUserID() {
		return userid;
	}

	public void setUserID(String userID) {
		this.userid = userID;
	}

}
