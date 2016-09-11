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
public class OrderDet implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String order_id;
    private String customer_id;
	private double grandTotal;
	private String shippingadd_id;
	private String billingadd_id;

	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	
	public String getCustomerId() {
		return customer_id;
	}
	public void setCustomerId(String customerId) {
		this.customer_id = customerId;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public String getShippingAddress_id() {
		return shippingadd_id;
	}
	public void setShippingAddress_id(String shippingAddress_id) {
		this.shippingadd_id = shippingAddress_id;
	}
	public String getBillingAddress_id() {
		return billingadd_id;
	}
	public void setBillingAddress_id(String billingAddress_id) {
		this.billingadd_id = billingAddress_id;
	}

	public OrderDet(){
		this.order_id="O"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	

}
