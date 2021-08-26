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
	public List<Customer> listAllCustomers();

}
