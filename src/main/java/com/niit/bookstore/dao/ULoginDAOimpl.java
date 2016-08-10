package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.ULogin;

@Repository(value="uLoginDAO")
public class ULoginDAOimpl implements ULoginDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ULoginDAOimpl(SessionFactory sessionFctory){
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdate(ULogin uLogin){
		sessionFactory.getCurrentSession().saveOrUpdate(uLogin);
	}
	
	@Transactional
	public void delete(String id){
		ULogin user1 = new ULogin();
		user1.setLoginID(id);
		sessionFactory.getCurrentSession().delete(user1);
	}
	
	@Transactional
	public ULogin get(String id) {

		// sessionFactory.getCurrentSession().get(UserLogin.class,id);
		String hql = "from UrLogin where loginId=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<ULogin> listUsers = query.list();
		if (listUsers != null && !listUsers.isEmpty()) {
			return listUsers.get(0);
		}
		return null;
	}

	@Transactional
	public List<ULogin> listUser() {
		@SuppressWarnings("unchecked")
		List<ULogin> listUsers = (List<ULogin>) sessionFactory.getCurrentSession().createCriteria(ULogin.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUsers;
	}

	
}
