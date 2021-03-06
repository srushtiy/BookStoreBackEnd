package com.niit.bookstore.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;

import com.niit.bookstore.dao.CardDAO;
import com.niit.bookstore.dao.CardDAOimpl;
import com.niit.bookstore.dao.CartDAO;
import com.niit.bookstore.dao.CartDAOimpl;
import com.niit.bookstore.dao.CategoryDAO;
import com.niit.bookstore.dao.CategoryDAOimpl;
import com.niit.bookstore.dao.ProductDAO;
import com.niit.bookstore.dao.ProductDAOimp;
import com.niit.bookstore.dao.SupplierDAO;
import com.niit.bookstore.dao.SupplierDAOimpl;
import com.niit.bookstore.dao.UserDAO;
import com.niit.bookstore.dao.UserDAOimpl;
import com.niit.bookstore.model.BillingAddress;
import com.niit.bookstore.model.Card;
import com.niit.bookstore.model.Cart;
import com.niit.bookstore.model.CartDetail;
import com.niit.bookstore.model.Category;
import com.niit.bookstore.model.Customer;
import com.niit.bookstore.model.OrderDet;
import com.niit.bookstore.model.OrderItems;
import com.niit.bookstore.model.Product;
import com.niit.bookstore.model.ShippingAddress;
import com.niit.bookstore.model.Supplier;
import com.niit.bookstore.model.User;
import com.niit.bookstore.model.UserAuthority;

//data source properties, hibernate properties; check pom.xml for all dependencies; Debugging
@Configuration
@ComponentScan("com.niit.bookstore")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");// jdbc:h2:meme:tmp.db;INIT=CREATE
															// SCHEMA IF NOT
															// EXISTS NIIT
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(CartDetail.class);
		sessionBuilder.addAnnotatedClass(Customer.class);
		sessionBuilder.addAnnotatedClass(BillingAddress.class);
		sessionBuilder.addAnnotatedClass(ShippingAddress.class);
		sessionBuilder.addAnnotatedClass(UserAuthority.class);
		sessionBuilder.addAnnotatedClass(OrderDet.class);
		sessionBuilder.addAnnotatedClass(OrderItems.class);
		sessionBuilder.addAnnotatedClass(Card.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
	    org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(25000000);
	    return multipartResolver;
	}

	/*@Autowired
	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDAOimpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "supplierDAO")
	public SupplierDAO getSupplierDao(SessionFactory sessionFactory) {
		return new SupplierDAOimpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO getProductDao(SessionFactory sessionFactory) {
		return new ProductDAOimp(sessionFactory);
	}

	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDao(SessionFactory sessionFactory) {
		return new UserDAOimpl(sessionFactory);
	}

	@Autowired
	 @Bean(name = "cartDAO")
	 public CartDAO getCartDao(SessionFactory sessionFactory) {
		  return new CartDAOimpl(sessionFactory);
	    }
	
	@Autowired
	@Bean(name = "cardDAO")
	public CardDAO getCardDao(SessionFactory sessionFactory) {
		return new CardDAOimpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "orderdetDAO")
	public UserDAO getUserDao(SessionFactory sessionFactory) {
		return new UserDAOimpl(sessionFactory);
	}*/
}
