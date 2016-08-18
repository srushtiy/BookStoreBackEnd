package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.User;

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

}
