package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.ShippingAddress;

@Repository(value="shippingaddressDAO")
public class ShippingAddressDAOimpl implements ShippingAddressDAO{
	
	@Autowired
	private SessionFactory sessionFactory;


	public ShippingAddressDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public ShippingAddress get(String shippingadd_id) {
		String hql = "from ShippingAddress where shippingadd_id=" + "'"+ shippingadd_id +"'";
		//  from category where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<ShippingAddress> listSA = (List<ShippingAddress>) query.list();
		
		if (listSA != null && !listSA.isEmpty()) {
			return listSA.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(ShippingAddress shippingaddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(shippingaddress);
	}

	@Transactional
	public void delete(String shippingadd_id) {
		ShippingAddress sa = new ShippingAddress();
		sa.setShippingadd_id(shippingadd_id);
		sessionFactory.getCurrentSession().delete(sa);
		
	}
	

}
