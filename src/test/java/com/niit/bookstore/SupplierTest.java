package com.niit.bookstore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.bookstore.dao.SupplierDAO;
import com.niit.bookstore.model.Supplier;

public class SupplierTest {

public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.bookstore");
		context.refresh();
		
		
	   SupplierDAO supplierDAO = 	(SupplierDAO) context.getBean("supplierDAO");
	   
	   Supplier supplier = 	(Supplier) context.getBean("supplier");
	   supplier.setId("S100");
	   supplier.setName("Lucky Books Supplier");
	   supplier.setAddress("3 Forest Walk Road, Powai, Mumbai");
	   
	   
	  supplierDAO.saveorUpdate(supplier);


	}

}
