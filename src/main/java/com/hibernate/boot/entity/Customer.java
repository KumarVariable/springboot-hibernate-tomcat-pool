package com.hibernate.boot.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a Customer
 * 
 * @author kunal
 * @version 1.0
 * 
 */

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8391791032558628284L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customerNumber")
	private int customerNumber;

	private String customerName;
	private String contactLastName;
	private String contactFirstName;
	private String phone;

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;

	@Column(nullable = true, name = "salesRepEmployeeNumber")
	private Integer salesRepEmployeeNumber;

	@Column(nullable = true,name = "creditLimit")
	private BigDecimal creditLimit;

	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactLastName() {
		return contactLastName;
	}
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}
	public String getContactFirstName() {
		return contactFirstName;
	}
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getSalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}
	public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
	}
	public BigDecimal getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", customerName="
				+ customerName + ", contactLastName=" + contactLastName
				+ ", contactFirstName=" + contactFirstName + ", phone=" + phone
				+ ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", country=" + country
				+ ", salesRepEmployeeNumber=" + salesRepEmployeeNumber
				+ ", creditLimit=" + creditLimit + "]";
	}

}
