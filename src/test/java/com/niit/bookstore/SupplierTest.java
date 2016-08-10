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
	   supplier.setSupid("S003");
	   supplier.setSupname("Workman");
	   supplier.setSupaddress("S.V. Road, Vile Parle, Mumbai");
	   supplier.setSupcontact("9899878778");
	   supplier.setSupemail("contact@workman.com");
	   
	   
	  supplierDAO.saveorUpdate(supplier);


	}

}
