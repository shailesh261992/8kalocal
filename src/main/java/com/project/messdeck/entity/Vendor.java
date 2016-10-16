package com.project.messdeck.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;
import com.project.messdeck.Views;

import net.sf.oval.constraint.AssertValid;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotNull;

@JsonInclude(Include.NON_EMPTY)
@Entity
public class Vendor extends AbstractEntity {
	@MatchPattern(pattern = "^[a-zA-Z ]*$", message = "Only Alphabets are allowed")
	@NotNull
	@JsonView(Views.Summary.class)
	private String messName;

	@AssertValid(message = "Invalid Vendor Address")
	@JsonView(Views.Summary.class)
	@OneToOne(cascade = CascadeType.ALL)
	private Address vendorAddress;

	@AssertValid
	@Embedded
	@JsonView(Views.Summary.class)
	private EmailID emailID;

	@JsonView(Views.Summary.class)
	private String receptionNo;

	@JsonView(Views.Details.class)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Owner owner;

	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
	private VendorAccount vendorAccount;

	public Vendor() {
		super();
	}

	public String getMessName() {
		return messName;
	}

	public void setMessName(String messName) {
		this.messName = messName;
	}

	public Address getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(Address vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public EmailID getEmailID() {
		return emailID;
	}

	public void setEmailID(EmailID emailID) {
		this.emailID = emailID;
	}

	public String getReceptionNo() {
		return receptionNo;
	}

	public void setReceptionNo(String receptionNo) {
		this.receptionNo = receptionNo;
	}

	public VendorAccount getVendorAccount() {
		return vendorAccount;
	}

	public void setVendorAccount(VendorAccount vendorAccount) {
		this.vendorAccount = vendorAccount;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

}
