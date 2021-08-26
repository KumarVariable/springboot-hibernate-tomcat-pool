package com.hibernate.boot.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.boot.dao.CustomerDAO;
import com.hibernate.boot.entity.Customer;

/**
 * Implementation of Persistence Layer API's to perform requested database
 * operations.
 * 
 * @author kunal
 * @version 1.0
 */
@Repository("customerDAO")
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	private static final int LIMIT_COUNT = 10;

	@Autowired
	HibernateTemplate template;

	@Autowired
	LocalSessionFactoryBean sessionFactory;

	/**
	 * Read all available customers - limit by {@value #LIMIT_COUNT}
	 */
	@Override
	public List<Customer> listAllCustomers() {

		String s = "from Customer customer ";

		@SuppressWarnings("unchecked")
		Query<Customer> query = sessionFactory.getObject().getCurrentSession()
				.createQuery(s);
		query.setMaxResults(LIMIT_COUNT);
		List<Customer> listOfCustomers = query.list();
		return listOfCustomers;
	}

}
