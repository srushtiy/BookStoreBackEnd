package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.Cart;

@Repository("cartDAO")
public class CartDAOimpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Cart> list() {
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCart;
	}

	@Transactional
	public Cart get(String id) {
		String hql = "from Cart where id=" + "'" + id + "'";
		// from category where id = '101'
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> listCart = (List<Cart>) query.list();

		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);

	}

	@Transactional
	public void delete(String id) {
		Cart cart = new Cart();
		cart.setId(id);
		sessionFactory.getCurrentSession().delete(cart);

	}

}
