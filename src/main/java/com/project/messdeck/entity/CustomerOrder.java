package com.project.messdeck.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.messdeck.Views;

@Entity
public class CustomerOrder extends AbstractEntity {

	@JsonView(Views.Details.class)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private CustomerAccount customerAccount;

	@JsonView(Views.Details.class)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private MessDeckOfferingInstance messDeckServiceInstance;

	@ElementCollection
	@JsonView(Views.Summary.class)
	private List<LineItem> lineItems;

	@JsonView(Views.Summary.class)
	private boolean isCustomized;

	@JsonView(Views.Summary.class)
	private double totalCost;

	@JsonView(Views.Summary.class)
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
