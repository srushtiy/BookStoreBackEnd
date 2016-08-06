package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.Supplier;

public interface SupplierDAO {
	
	public List<Supplier> supplierlist();

	public Supplier get(String id);

	public void saveorUpdate(Supplier supplier);

	public void delete(String id);

}
