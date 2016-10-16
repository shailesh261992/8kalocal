package com.project.messdeck.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CustomerOrder extends AbstractEntity {
	@ManyToOne(optional = false)
	private CustomerAccount customerAccount;
	@ManyToOne(optional = false)
	private MessDeckOfferingInstance messDeckServiceInstance;
	@ElementCollection
	private List<LineItem> lineItems;
	private boolean isCustomized;
	private double totalCost;
	@Column(nullable = false)
	private OrderStatus status;

	public CustomerOrder() {
		super();
	}

	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public MessDeckOfferingInstance getMessDeckServiceInstance() {
		return messDeckServiceInstance;
	}

	public void setMessDeckServiceInstance(MessDeckOfferingInstance messDeckServiceInstance) {
		this.messDeckServiceInstance = messDeckServiceInstance;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public boolean isCustomized() {
		return isCustomized;
	}

	public void setCustomized(boolean isCustomized) {
		this.isCustomized = isCustomized;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
