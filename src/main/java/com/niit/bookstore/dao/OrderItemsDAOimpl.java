package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.OrderItems;

@Repository("orderitemsDAO")
public class OrderItemsDAOimpl implements OrderItemsDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public OrderItemsDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(OrderItems orderedItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderedItems);

	}

	@Transactional
	public void delete(String orderedItemId) {
		OrderItems orderedItemsTodelete = new OrderItems();
		orderedItemsTodelete.setOrderItems_id(orderedItemId);
		sessionFactory.getCurrentSession().delete(orderedItemsTodelete);

	}

	@Transactional
	public List<OrderItems> listOrderedItems() {
		String hql = "from OrderedItems";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<OrderItems> listOfOrderedItems = query.list();
		return listOfOrderedItems;
	}
}
