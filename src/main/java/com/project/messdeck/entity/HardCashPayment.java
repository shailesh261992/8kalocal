package com.project.messdeck.entity;

import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.project.messdeck.serializer.LocalDateTimeAttributeConverter;

@Entity
@JsonInclude(Include.NON_EMPTY)
public class HardCashPayment extends Payment {

	@ManyToOne(optional = false)
	private CustomerAccount customerAccount;
	@ManyToOne(optional = false)
	private VendorAccount vendorAccount;
	private String recivedBy;
	private double amount;
	
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime timeStamp;

	public HardCashPayment() {
		super();
	}

	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public VendorAccount getVendorAccount() {
		return vendorAccount;
	}

	public void setVendorAccount(VendorAccount vendorAccount) {
		this.vendorAccount = vendorAccount;
	}

	public String getRecivedBy() {
		return recivedBy;
	}

	public void setRecivedBy(String recivedBy) {
		this.recivedBy = recivedBy;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

}
