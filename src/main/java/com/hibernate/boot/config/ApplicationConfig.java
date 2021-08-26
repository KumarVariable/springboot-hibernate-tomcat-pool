package com.hibernate.boot.config;

/**
 * Configuration class to declare Hibernate Configuration and application specific beans.
 * @author kunal
 * */

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ApplicationConfig {

	@Bean(name = "appSessionFactory")
	public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource) {

		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		factoryBean.setHibernateProperties(hibernateProperties());
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan("com.hibernate.boot");

		return factoryBean;

	}

	@Bean(name = "appHibernateTemplate")
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
		return new HibernateTemplate(sessionFactory);
	}

	@Bean(name = "appHibernateTransactionManager")
	public HibernateTransactionManager hibernateTrransactionManager(
			SessionFactory sessionFactory) {

		return new HibernateTransactionManager(sessionFactory);

	}

	/**
	 * Private helper method to set Hibernate configuration properties.
	 * 
	 * (a) Show / Do not Show log for each sql query.
	 * 
	 * (b) Hibernate ddl auto (create, create-drop, validate, update).
	 * 
	 * (c) The SQL dialect makes Hibernate generate better SQL for the chosen
	 * database.
	 */
	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();

		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");

		hibernateProperties.setProperty("hibernate.dialect",
				"org.hibernate.dialect.MySQL8Dialect");

		return hibernateProperties;
	}

}
