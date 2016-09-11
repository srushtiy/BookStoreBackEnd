package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.Supplier;

@Repository(value = "supplierDAO")
public class SupplierDAOimpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Supplier> supplierlist() {
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listSupplier;

	}

	@Transactional
	public Supplier get(String supid) {
		String hql = "from Supplier where supid=" + "'" + supid + "'";
		// from supplier where id = '101'
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> listSupplier = (List<Supplier>) query.list();

		if (listSupplier != null && !listSupplier.isEmpty()) {
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
		supplier.setSupid(id);
		sessionFactory.getCurrentSession().delete(supplier);

	}

}
