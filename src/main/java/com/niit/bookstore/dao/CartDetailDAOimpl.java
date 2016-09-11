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
	
	@Transactional
	public void delete(String cartDetailid) {
		CartDetail cd = new CartDetail();
		cd.setCartDetailid(cartDetailid);
		sessionFactory.getCurrentSession().delete(cd);
	}
	
    @Transactional
	public List<CartDetail> getDetailbyCustomerId(String customer_id) {
		String hql = "from CartDetail where customer_id=" + "'" + customer_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartDetail> CartList = (List<CartDetail>) query.list();
		return CartList;
	}

    @Transactional
	public CartDetail getCartItem(String cartDetailid) {
    	String hql = "from CartDetail where cartDetailId=" + "'" + cartDetailid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartDetail> cartItemList = query.list();
		if(cartItemList!=null && !cartItemList.isEmpty())
			return cartItemList.get(0);
		return null;
	}
    
    @Transactional
	public List<CartDetail> listCartDetails() {
		String hql = "from CartDetail";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartDetail> cartItems = query.list();
		return cartItems;
	}
}
