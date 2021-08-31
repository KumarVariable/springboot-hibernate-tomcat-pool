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
	 * Create Customer
	 * 
	 * @return generated id of customer.
	 */
	public int addCustomer(Customer customer);

	/**
	 * Read all available customers
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> listAllCustomers();

	/**
	 * Find By Customer Id
	 * 
	 * @return Customer
	 */
	public Customer findById(int customerNumber);

	/**
	 * Update Customer
	 * 
	 */
	public void upateCustomer(Customer customer);

	/**
	 * Delete Customer
	 * 
	 */
	public void deleteCustomerById(Customer customer);

}
