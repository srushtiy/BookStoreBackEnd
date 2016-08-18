package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.Cart;
import com.niit.bookstore.model.Product;

@Repository("cartDAO")
public class CartDAOimpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Cart> list() {
		String hql = "from Cart";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> cartlist = query.list();
		return cartlist;
	}

	@Transactional
	public Cart getbycustomerid(String customerid)  {
		String hql = "from Cart where id=" + "'" + customerid + "'";
		// from category where id = '101'
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> userlist = (List<Cart>) query.list();

		if (userlist != null && !userlist.isEmpty()) {
			return userlist.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);

	}

	@Transactional
	public void delete(String cartid) {
		sessionFactory.getCurrentSession().delete(cartid);
	}


}
