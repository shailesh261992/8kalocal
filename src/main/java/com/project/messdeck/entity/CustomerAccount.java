package com.project.messdeck.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerAccount extends AbstractEntity {

	@JsonIgnore
	@OneToOne(optional = false, mappedBy = "customerAccount")
	private Customer customer;

	private double balance;
	@Column(nullable = false)

	private CustomerAccountStatus customerAccountStatus;

	@OneToMany(mappedBy = "customerAccount")
	List<DeliveryAddress> deliveryAddresses;

	@OneToMany(mappedBy = "customerAccount")
	List<CustomerOrder> orders;

	@OneToMany(mappedBy = "customerAccount")
	List<CustomerPayement> payements;

	@OneToMany(mappedBy = "customerAccount")
	List<Review> reviews;

	public CustomerAccount() {
		super();
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public CustomerAccountStatus getCustomerAccountStatus() {
		return customerAccountStatus;
	}

	public void setCustomerAccountStatus(CustomerAccountStatus customerAccountStatus) {
		this.customerAccountStatus = customerAccountStatus;
	}

	public List<DeliveryAddress> getDeliveryAddresses() {
		return deliveryAddresses;
	}

	public void setDeliveryAddresses(List<DeliveryAddress> deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}

	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}

	public List<CustomerPayement> getPayements() {
		return payements;
	}

	public void setPayements(List<CustomerPayement> payements) {
		this.payements = payements;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
