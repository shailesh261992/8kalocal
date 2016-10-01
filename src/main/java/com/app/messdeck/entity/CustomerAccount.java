package com.app.messdeck.entity;

import java.util.List;

public class CustomerAccount extends AbstractEntity {

	
	private CustomerAccountStatus customerAccountStatus;
	private double balance;
	List<DeliveryAddress> deliveryAddresses;
	List<Order> orders;
	List<CustomerPayementTransaction> payements;
}
