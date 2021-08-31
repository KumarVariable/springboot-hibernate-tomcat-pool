package com.hibernate.boot.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

	private static final Logger log = LoggerFactory
			.getLogger(SpringBootApplication.class);

	private static final int LIMIT_COUNT = 10;

	@Autowired
	HibernateTemplate template;

	@Autowired
	LocalSessionFactoryBean sessionFactory;

	/**
	 * Create Customer
	 * 
	 * @return id of newly created Customer
	 */
	@Override
	public int addCustomer(Customer customer) {

		Integer id = (Integer) template.save(customer);
		log.info("Customer id " + id + " creation successfull ");

		return id;

	}

	/**
	 * Read Customer(s) - limit by {@value #LIMIT_COUNT}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> listAllCustomers() {

		String queryString = "from Customer customer ";

		Query<Customer> query = sessionFactory.getObject().getCurrentSession()
				.createQuery(queryString);

		query.setMaxResults(LIMIT_COUNT);
		List<Customer> listOfCustomers = query.list();

		return listOfCustomers;
	}

	/**
	 * Find Customer by Id.
	 * 
	 * @return Customer
	 */
	@Override
	public Customer findById(int customerNumber) {
		Customer customer = template.load(Customer.class, customerNumber);

		log.info("Find by customer Id " + customer.getCustomerNumber() + " = = "
				+ customer.toString());
		return customer;
	}

	/**
	 * Update Customer
	 */
	@Override
	public void upateCustomer(Customer customer) {
		template.update(customer);
	}

	/**
	 * Delete Customer
	 */
	@Override
	public void deleteCustomerById(Customer customer) {
		template.delete(customer);

	}

}
