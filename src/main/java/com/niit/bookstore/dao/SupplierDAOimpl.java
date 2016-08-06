package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOimpl implements SupplierDAO{
	
	private SessionFactory sessionFactory;
	public SupplierDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	public List<Supplier> supplierlist() {
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listSupplier;
		
	}

	public Supplier get(String id) {
		String hql = "from Supplier where id=" + "'"+ id +"'";
		//  from supplier where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> listSupplier = (List<Supplier>) query.list();
		
		if (listSupplier!= null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		return null;
		
	}
	
	@Transactional
	public void saveorUpdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	
	}
	
	@Transactional
	public void delete(String id) {
		Supplier supplier = new Supplier();
		supplier.setId(id);
		sessionFactory.getCurrentSession().delete(supplier);
		
		
	}
	

}
