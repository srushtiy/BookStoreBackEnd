package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.UserAuthority;



@Repository("userauthorityDAO")
public class UserAuthorityDAOimpl implements UserAuthorityDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserAuthorityDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public void saveOrUpdate(UserAuthority userauth) {
		sessionFactory.getCurrentSession().saveOrUpdate(userauth);
	}

	@Transactional
	public UserAuthority get(String userauth_id) {
		String hql = "from UserAuth where userauth_id=" + "'" + userauth_id + "'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<UserAuthority> listAuthorities= (List<UserAuthority>)query.list();
		if (listAuthorities!= null && !listAuthorities.isEmpty()) {
			return listAuthorities.get(0);
		}
		return null;
	}

	@Transactional
	public List<UserAuthority> list() {
		@SuppressWarnings("unchecked")
		List<UserAuthority> listAuthorities= (List<UserAuthority>) sessionFactory.getCurrentSession()
		.createCriteria(UserAuthority.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listAuthorities;
	}

}
