package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.Category;
import com.niit.bookstore.model.User;

public class UserDAOimpl implements UserDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;


	public UserDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<User> userlist() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}
		
	@Transactional
	public User get(String id) {
		String hql = "from User where id=" + "'"+ id +"'";
		//  from category where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}
	
	@Transactional
	public void saveorUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
		
	}
	
	@Transactional
	public void delete(String id) {
		User user = new User();
		user.setId(id);
		sessionFactory.getCurrentSession().delete(user);
	}

	public boolean isValidUser(String username, String password) {
		
		return false;
	}
	

}
