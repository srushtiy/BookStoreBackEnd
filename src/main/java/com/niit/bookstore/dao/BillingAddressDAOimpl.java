package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.BillingAddress;

@Repository(value="billingaddressDAO")
public class BillingAddressDAOimpl implements BillingAddressDAO {
	
	@Autowired
	private SessionFactory sessionFactory;


	public BillingAddressDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public BillingAddress get(String billingadd_id) {
		String hql = "from BillingAddress where billingadd_id=" + "'"+ billingadd_id +"'";
		//  from category where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<BillingAddress> listBA = (List<BillingAddress>) query.list();
		
		if (listBA != null && !listBA.isEmpty()) {
			return listBA.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(BillingAddress billingaddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(billingaddress);
	}

	@Transactional
	public void delete(String billingadd_id) {
		BillingAddress ba = new BillingAddress();
		ba.setBillingadd_id(billingadd_id);
		sessionFactory.getCurrentSession().delete(ba);
	}
	
	@Transactional
	public List<BillingAddress> list() {
		@SuppressWarnings("unchecked")
		List<BillingAddress> listAdd= (List<BillingAddress>) sessionFactory.getCurrentSession()
		.createCriteria(BillingAddress.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listAdd;
	}

}
