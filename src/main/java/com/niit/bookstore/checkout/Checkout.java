package com.niit.bookstore.checkout;

import java.io.Serializable;

import com.niit.bookstore.model.BillingAddress;
import com.niit.bookstore.model.Card;
import com.niit.bookstore.model.Cart;
import com.niit.bookstore.model.CartDetail;
import com.niit.bookstore.model.Customer;
import com.niit.bookstore.model.OrderDet;
import com.niit.bookstore.model.OrderItems;
import com.niit.bookstore.model.ShippingAddress;

public class Checkout implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Card card;
	private ShippingAddress shippingAddress;
	private BillingAddress billingAddress;
	private OrderDet orderDetail;
	private OrderItems orderItems;
	private Cart cart;
	private CartDetail cartDetail;
	private Customer customer;
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public OrderDet getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDet orderDetail) {
		this.orderDetail = orderDetail;
	}
	public OrderItems getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(OrderItems orderItems) {
		this.orderItems = orderItems;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public CartDetail getCartDetail() {
		return cartDetail;
	}
	public void setCartDetail(CartDetail cartDetail) {
		this.cartDetail = cartDetail;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
