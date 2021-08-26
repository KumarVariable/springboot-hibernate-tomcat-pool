package com.hibernate.boot;

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

	Logger log = LoggerFactory.getLogger(SpringBootApplication.class);

	@Autowired
	CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		log.info(" List all customers limit by 10 ");

		List<Customer> listOfCustomers = customerService.listAllCustomers();

		log.info("Total Size of Customer List -> " + listOfCustomers.size());
	}

}
