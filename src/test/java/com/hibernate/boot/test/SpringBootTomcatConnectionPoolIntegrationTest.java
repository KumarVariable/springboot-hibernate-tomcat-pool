package com.hibernate.boot.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Simple Integration Test to Check : (a) Spring Boot has correctly configured
 * the Connection Pool. (b) Check for successful MyDQL Database connection.
 * 
 * @SpringBootTest : Tells Spring Boot to look for a main configuration class
 *                 (for instance - the one with @SprinBootApplication
 *                 annotation).
 * 
 * 
 * @author kunal
 * @version 1.0
 */
@SpringBootTest
@DisplayName("Spring Boot Integration Test")
public class SpringBootTomcatConnectionPoolIntegrationTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${spring.datasource.type}")
    private String expectedDataSourceName;

    private static final String EXPECTED_DTABASE_NAME = "classicmodels";
    private static final String GET_CURRENT_DATABASE = "SELECT DATABASE() ";

    @BeforeEach
    public void init(TestInfo testinfo) {

	String testCaseToRun = testinfo.getTestMethod().get().getName();

	System.out.println(" <-- Going To Run Test Case -->  " + testCaseToRun);

    }

    @Test
    @DisplayName("Verify Application Context")
    void contextLoads() {

	// Empty contextLoads() is a test to verify if the application is able to load
	// Spring context successfully or not with @SpringBootTest annotation.
    }

    @Test
    @DisplayName("Test Connection Pool Instance - Tomcat")
    public void testConnectionPoolInstanceIsTomcat() {

	String actualDataSourceName = dataSource.getClass().getName();

	assertNotNull(expectedDataSourceName);
	assertNotNull(actualDataSourceName);
	assertEquals(expectedDataSourceName, actualDataSourceName);
    }

    @Test
    @DisplayName("Test MySQL Database Connection")
    public void testMySQLDatabaseConnection() {

	String templateName = jdbcTemplate.getClass().getName();
	assertNotNull(templateName);

	String actualDatabaseName = jdbcTemplate.queryForObject(GET_CURRENT_DATABASE, String.class);
	assertThat(actualDatabaseName).isEqualTo(EXPECTED_DTABASE_NAME);

    }

}
