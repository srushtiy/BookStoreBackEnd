package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.OrderDet;

public interface OrderDetDAO {

	void saveOrUpdate(OrderDet orderDetail);

	void delete(String orderDetailId);

	List<OrderDet> listOrderDetails();
	
	OrderDet getOrderByCustomerId(String customerid);
}
