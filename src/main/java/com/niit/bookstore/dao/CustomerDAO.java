package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.Customer;

public interface CustomerDAO {
	
	Customer get(String customer_id);
	
	List<Customer> list();
	
	Customer getCustomerByUserName(String username);
}
