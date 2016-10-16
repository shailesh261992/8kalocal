package com.project.messdeck.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class DeliveryAddress extends Address {
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private CustomerAccount customerAccount;
	private long frequency; // will reflect how many times customer used
							// delivery address

	public long getFrequency() {
		return frequency;
	}

	public DeliveryAddress() {
		super();
	}

	public void setFrequency(long frequency) {
		this.frequency = frequency;
	}

	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

}
