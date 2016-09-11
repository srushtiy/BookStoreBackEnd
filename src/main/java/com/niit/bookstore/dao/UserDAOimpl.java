package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.Customer;
import com.niit.bookstore.model.User;
import com.niit.bookstore.model.UserAuthority;

@Repository("userDAO")
public class UserDAOimpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

	@Transactional
	public User get(String userid) {
		return (User) sessionFactory.getCurrentSession().get(User.class, userid);
	}

	@Transactional
	public void saveorUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	/*
	 * @Transactional public void delete(String id) { User user = new User();
	 * user.setUserid(id); sessionFactory.getCurrentSession().delete(user); }
	 */

	@Transactional
	public User getbyUsername(String username) {
		String hql = "from User where username=" + "'" + username + "'";
		// from category where id = '101'
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> listUser = (List<User>) query.list();
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}

	@Transactional
	public boolean isValidUser(String username, String password) {
		String hql = "from User where username=" + "'" + username + "'" + "and password=" + "'" + password +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> isValid = query.list();
		if (isValid !=null && !isValid.isEmpty()){
			return true;
		}
		return false;
	}

	/*@Transactional
	public String getrole(String userid) {
		String hql = "from UserAuthority where userid=" +"'" + userid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserAuthority> isAdmin = query.list();
		if(isAdmin != null && !isAdmin.isEmpty()){
			return isAdmin.get(0).getAuth_role();
		}
		return null;
	}

	@Transactional
	public String getcustomerid(String userid) {
		String hql = "from Customer where userid=" +"'" + userid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Customer> customer = query.list();
		if(customer != null && !customer.isEmpty()){
			return customer.get(0).getCustomer_id();
		}
		return null;
	}*/

}
