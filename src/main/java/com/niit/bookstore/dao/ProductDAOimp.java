package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.Product;

@Repository("productDAO")
public class ProductDAOimp implements ProductDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOimp (SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	

	public List<Product> productlist() {
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listProduct;
		
	}

	public Product get(String id) {
		String hql = "from Product where id=" + "'"+ id +"'";
		//  from category where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listProduct = (List<Product>) query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		return null;
		
	}
	
	@Transactional
	public void saveorUpdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}
	
	@Transactional
	public void delete(String id) {
		Product product = new Product();
		product.setId(id);
		sessionFactory.getCurrentSession().delete(product);
	
	}
	

}