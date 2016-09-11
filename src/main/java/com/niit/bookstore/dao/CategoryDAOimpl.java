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

@Repository(value="categoryDAO")
public class CategoryDAOimpl implements CategoryDAO {
	

	@Autowired
	private SessionFactory sessionFactory;


	public CategoryDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public void saveOrUpdate(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
			
	}

	@Transactional
	public void delete(String catid) {
		Category category = new Category();
		category.setCatid(catid);
		sessionFactory.getCurrentSession().delete(category);
	}

	@Transactional
	public Category get(String catid) {
		String hql = "from Category where catid=" + "'"+ catid +"'";
		//  from category where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> listCategory = (List<Category>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Category> list() {
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCategory;
	}

	@Transactional
	public List<Product> ProductListbyCat(String id) {
		String hql="from Product where catid=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listSelectedProducts = query.list();
		return listSelectedProducts; 
	}
	
	/*@Transactional
	public List<Product> selectedCategoryProductList(String id)
	{
		String hql="from Product where categoryId=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listSelectedProducts = query.getResultList();
		return listSelectedProducts; 
		
	
	}
	
	@Transactional
	public int getProductCountByCategory(String id)
	{
		String hql="from Product where categoryId=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listSelectedProducts = query.getResultList();
		return listSelectedProducts.size(); 
		
	
	}*/
	


}
