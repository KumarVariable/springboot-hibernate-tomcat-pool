package com.hibernate.boot.service;

import java.util.List;

import com.hibernate.boot.entity.Customer;

/**
 * Abstract APIs for Business Operations
 * 
 * @author kunal
 * @version 1.0
 * 
 */
public interface CustomerService {

	public int addCustomer(Customer customer);

	public List<Customer> listAllCustomers();
	
	public Customer findById(int customerNumber);

	public void upateCustomer(Customer customer);
	
	public void deleteCustomerById(int customerNumber);

}
