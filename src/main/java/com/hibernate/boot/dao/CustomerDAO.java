package com.hibernate.boot.dao;

import java.util.List;

import com.hibernate.boot.entity.Customer;

/**
 * Persistence Layer API's to perform requested database operations.
 * 
 * @author kunal
 * @version 1.0
 */

public interface CustomerDAO {

	/**
	 * Read all available customers
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> listAllCustomers();

}
