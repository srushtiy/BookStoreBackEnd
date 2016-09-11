package com.niit.bookstore.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bookstore.model.Card;

@Repository("cardDAO")
public class CardDAOimpl implements CardDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public CardDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Card card) {
		sessionFactory.getCurrentSession().saveOrUpdate(card);

	}
}
