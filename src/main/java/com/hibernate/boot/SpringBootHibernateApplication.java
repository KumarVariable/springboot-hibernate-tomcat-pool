package com.hibernate.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Boot Main Class to load application context, required configuration and
 * dependencies.
 * 
 * @author kunal
 * @version 1.0
 */
@SpringBootApplication
public class SpringBootHibernateApplication {

    public static void main(String[] args) {
	SpringApplication.run(SpringBootHibernateApplication.class, args);

    }

}
