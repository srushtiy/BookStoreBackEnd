package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.dao.CartDetailDAO;
import com.niit.bookstore.model.CartDetail;

@Repository("cartDetailDAO")
public class CartDetailDAOimpl implements CartDetailDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public CartDetailDAOimpl (SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void saveorUpdate(CartDetail cartDetail) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartDetail);
	}

	public void delete(String cartDetailid) {
		sessionFactory.getCurrentSession().delete(cartDetailid);
	}

	public List<CartDetail> getDetailbyUserId(String userid) {
		String hql = "from CartDetail where userId=" + "'" + userid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartDetail> CartList = (List<CartDetail>) query.list();
		return CartList;
	}
	

}
