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

import com.niit.bookstore.dao.CategoryDAO;
import com.niit.bookstore.dao.CategoryDAOimpl;
import com.niit.bookstore.model.Category;
//data source properties, hibernate properties; check pom.xml for all dependencies; Debugging
@Configuration
@ComponentScan("com.niit.bookstore")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
 	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");//jdbc:h2:meme:tmp.db;INIT=CREATE SCHEMA IF NOT EXISTS NIIT
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
      	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
   
	  @Autowired
	  @Bean(name = "categoryDAO")
	  public CategoryDAO getCategoryDao(SessionFactory sessionFactory) {
		  return new CategoryDAOimpl(sessionFactory);
	    }
}
