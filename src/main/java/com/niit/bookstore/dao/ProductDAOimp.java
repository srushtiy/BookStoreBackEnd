package com.niit.bookstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.Category;
import com.niit.bookstore.model.Product;

@Repository("productDAO")
public class ProductDAOimp implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOimp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Product> productlist() {
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listProduct;

	}

	@Transactional
	public Product get(String id) {
		String hql = "from Product where id=" + "'" + id + "'";
		// from category where id = '101'
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
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
	public void delete(String p_id) {
		Product product = new Product();
		product.setP_id(p_id);
		sessionFactory.getCurrentSession().delete(product);

	}

	@Transactional
	public List<Product> getListbyCatId(String catid) {
		@SuppressWarnings("unchecked")
		List<Product> getByCatId = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.createCriteria("catid", catid);
		return getByCatId;
	}
	
    @Transactional
	public List<Product> related_products(String p_id) {
		Product product = get(p_id);
		
		String hql = "from Product where product_id!=" + "'" + p_id + "'" + "and" + " category_id=" + "'"
				+ product.getCatid() + "'" + "and supplier_id!=" + "'" + product.getSupid();
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> similarProductList = query.list();
		return similarProductList;
	}
}
