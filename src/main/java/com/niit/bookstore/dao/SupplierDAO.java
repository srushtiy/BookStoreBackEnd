package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.Supplier;

public interface SupplierDAO {
	
	List<Supplier> supplierlist();

	Supplier get(String id);

	void saveorUpdate(Supplier supplier);

	void delete(String id);

}
