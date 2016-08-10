package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.User;

@Repository("uInfoDAO")
public class UInfoDAOimpl implements UInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UInfoDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Transactional
	public void delete(String username) {
		User user = new User();
		user.setUsername(username);
		sessionFactory.getCurrentSession().delete(user);
	}

	@Transactional
	public User get(String username) {
		sessionFactory.getCurrentSession().get(User.class, username);
		return null;
	}

	@Transactional
	public List<User> listUsers() {
		List<User> listUsers = sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUsers;
		

	}
}
