package com.hibernate.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.boot.dao.CustomerDAO;
import com.hibernate.boot.entity.Customer;
import com.hibernate.boot.service.CustomerService;

/**
 * Implementation of APIs for Business Operations
 * 
 * @author kunal
 * @version 1.0
 * 
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;

	@Override
	public int addCustomer(Customer customer) {
		return customerDAO.addCustomer(customer);
	}

	@Override
	public List<Customer> listAllCustomers() {
		return customerDAO.listAllCustomers();
	}

	@Override
	public Customer findById(int customerNumber) {
		return customerDAO.findById(customerNumber);
	}

	@Override
	public void upateCustomer(Customer customer) {
		customerDAO.upateCustomer(customer);

	}

	@Override
	public void deleteCustomerById(int customerNumber) {
		Customer customer = new Customer();
		customer.setCustomerNumber(customerNumber);

		customerDAO.deleteCustomerById(customer);

	}

}
