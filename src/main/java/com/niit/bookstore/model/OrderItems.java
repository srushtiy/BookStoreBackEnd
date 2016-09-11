package com.niit.bookstore.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class OrderItems implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String orderItems_id;
	private String customer_id;
	private String p_id;
	private double totalPrice;
	private int quantity;
	
	public String getOrderItems_id() {
		return orderItems_id;
	}
	public void setOrderItems_id(String orderItems_id) {
		this.orderItems_id = orderItems_id;
	}
	public String getCustomerId() {
		return customer_id;
	}
	public void setCustomerId(String customerId) {
		this.customer_id = customerId;
	}
	public String getProduct_id() {
		return p_id;
	}
	public void setProduct_id(String product_id) {
		this.p_id = product_id;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderItems(){
		this.orderItems_id="OIT"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	

}
