package com.hibernate.boot;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hibernate.boot.entity.Customer;
import com.hibernate.boot.service.CustomerService;

/**
 * Boot Main Class to load application context, required configuration and
 * dependencies.
 * 
 * @author kunal
 * @version 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.hibernate.boot"})
public class SpringBootHibernateApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory
			.getLogger(SpringBootApplication.class);

	@Autowired
	CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		log.info("Create Customer Operation");

		Customer insertCustomer = getInsertCustomer();

		int customerId = customerService.addCustomer(insertCustomer);

		log.info("Inserted New Customer Id :: " + customerId);
		
		log.info("Find Customer By Id Operation");
		
		customerService.findById(customerId);

		log.info(" Find Customers Operations limit records by 10 ");

		List<Customer> listOfCustomers = customerService.listAllCustomers();

		log.info("Total Size of Customer List -> " + listOfCustomers.size());

		int customerIdToUpdate = listOfCustomers.get(0).getCustomerNumber();
		int customerIdToDelete = listOfCustomers.get(1).getCustomerNumber();

		log.info("Update Customer Operation for Customer id :: "
				+ customerIdToUpdate);

		Customer updateCustomer = getUpdateCustomer(customerIdToUpdate);
		customerService.upateCustomer(updateCustomer);

		log.info("Delete Customer Operation for Customer id :: "
				+ customerIdToDelete);

		customerService.deleteCustomerById(customerIdToDelete);

	}

	private Customer getInsertCustomer() {
		Calendar calendar = Calendar.getInstance();

		String strSeconds = String.valueOf(calendar.get(Calendar.SECOND));

		Customer customer = new Customer();

		customer.setCustomerName("Gift Store".concat(strSeconds));
		customer.setContactFirstName("KUN".concat(strSeconds));
		customer.setContactLastName("KUM".concat(strSeconds));

		customer.setPhone("+91-9845789032");
		customer.setAddressLine1("Blue Lane");
		customer.setAddressLine2("Yellow Block");
		customer.setCity("Dream City");
		customer.setState("Jharkhand");
		customer.setPostalCode("825009");
		customer.setCountry("India");

		customer.setSalesRepEmployeeNumber(1504);

		String creditVal = "12000456.853";
		double doubleCreditVal = Double.valueOf(creditVal);

		BigDecimal creditLimit = BigDecimal.valueOf(doubleCreditVal);

		creditLimit = creditLimit.setScale(2, RoundingMode.HALF_EVEN);

		customer.setCreditLimit(creditLimit);

		return customer;
	}

	private Customer getUpdateCustomer(int customerNumber) {
		Calendar calendar = Calendar.getInstance();

		String strSeconds = String.valueOf(calendar.get(Calendar.SECOND));

		Customer updateCustomer = new Customer();

		updateCustomer.setCustomerNumber(customerNumber);

		updateCustomer.setCustomerName("Updated Store".concat(strSeconds));
		updateCustomer.setContactFirstName("UPDATE".concat(strSeconds));
		updateCustomer.setContactLastName("UPDATE".concat(strSeconds));

		updateCustomer.setPhone("+91-9845789032");
		updateCustomer.setAddressLine1("Blue Lane");
		updateCustomer.setAddressLine2("Yellow Block");
		updateCustomer.setCity("Dream City");
		updateCustomer.setState("Jharkhand");
		updateCustomer.setPostalCode("825009");
		updateCustomer.setCountry("India");

		updateCustomer.setSalesRepEmployeeNumber(1504);

		String creditVal = "3000456.853";
		double doubleCreditVal = Double.valueOf(creditVal);

		BigDecimal creditLimit = BigDecimal.valueOf(doubleCreditVal);

		creditLimit = creditLimit.setScale(2, RoundingMode.HALF_EVEN);

		updateCustomer.setCreditLimit(creditLimit);

		return updateCustomer;
	}

}
