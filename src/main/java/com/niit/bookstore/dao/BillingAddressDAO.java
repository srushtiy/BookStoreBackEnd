package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.BillingAddress;

public interface BillingAddressDAO {
	public BillingAddress get(String billingadd_id);

	public void saveOrUpdate(BillingAddress billingaddress);

	public void delete(String billingadd_id);
	
	public List<BillingAddress> list();
}
