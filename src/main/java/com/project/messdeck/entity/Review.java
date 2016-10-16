package com.project.messdeck.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Review extends AbstractEntity {
	@ManyToOne(optional = false)
	private CustomerAccount customerAccount;
	private LocalDateTime timeStamp;
	@OneToOne(optional = false)
	private VendorItem vendorItem;
	private double rating;

	public Review() {
		super();
	}

	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public VendorItem getVendorItem() {
		return vendorItem;
	}

	public void setVendorItem(VendorItem vendorItem) {
		this.vendorItem = vendorItem;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}
