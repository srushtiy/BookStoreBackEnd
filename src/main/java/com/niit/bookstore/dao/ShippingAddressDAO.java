package com.niit.bookstore.dao;

import com.niit.bookstore.model.ShippingAddress;

public interface ShippingAddressDAO {
	
	public ShippingAddress get(String shippingadd_id);
	
	public void saveOrUpdate(ShippingAddress shippingaddress);
	
	public void delete(String shippingadd_id);
}
