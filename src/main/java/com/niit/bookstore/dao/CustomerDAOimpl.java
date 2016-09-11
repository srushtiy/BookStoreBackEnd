package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.Customer;

@Repository("customerDAO")
public class CustomerDAOimpl implements CustomerDAO {
	@Autowired
	SessionFactory sessionFactory;

	public CustomerDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}
	@Transactional
	public Customer get(String customer_id) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, customer_id);

	}

	@Transactional
	public List<Customer> list() {
		@SuppressWarnings("unchecked")
		List<Customer> listCustomer = (List<Customer>) sessionFactory.getCurrentSession()
		.createCriteria(Customer.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCustomer;
	}


	@Transactional
	public Customer getCustomerByUserName(String username) {
		String hql = "from Customer where username=" + "'" + username + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Customer> listOfCustomers = query.list();
		if (listOfCustomers != null && !listOfCustomers.isEmpty()){
			return  listOfCustomers.get(0);
		}
			
		
		return null;

	}

	@Transactional
	public Customer getCustomerByFirstName(String firstname) {
		String hql = "from Customer where customer_first_name=" + "'" + firstname + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Customer> listOfCustomers = query.list();
		if (listOfCustomers != null && !listOfCustomers.isEmpty()){
			return  listOfCustomers.get(0);
		}
		return null;
	}
}

