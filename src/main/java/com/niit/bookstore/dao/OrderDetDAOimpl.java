package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.OrderDet;

@Repository("orderdetDAO")
public class OrderDetDAOimpl implements OrderDetDAO{

	@Autowired
	SessionFactory sessionFactory;

	public OrderDetDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdate(OrderDet orderDetail) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderDetail);
		
	}

	@Transactional
	public void delete(String orderDetailId) {
		OrderDet orderDetailTodelete = new OrderDet();
		orderDetailTodelete.setOrder_id(orderDetailId);
		
	}

	@Transactional
	public List<OrderDet> listOrderDetails() {
		String hql="from OrderDet";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<OrderDet> listOfOrderDetails = query.list();
		return listOfOrderDetails;
	}

	@Override
	public OrderDet getOrderByCustomerId(String customerid) {
		String hql = "from OrderDet where customer_id=" + "'" + customerid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<OrderDet> listOfOrders = query.list();
		if (listOfOrders != null && !listOfOrders.isEmpty()){
			return  listOfOrders.get(0);
		}
		return null;
	}

}
