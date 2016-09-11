package com.niit.bookstore.dao;

import java.util.List;

import com.niit.bookstore.model.OrderItems;

public interface OrderItemsDAO {
	void saveOrUpdate(OrderItems orderedItems);

	void delete(String orderedItemId);

	List<OrderItems> listOrderedItems();
}
