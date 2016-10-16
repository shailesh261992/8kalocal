package com.project.messdeck.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.project.messdeck.Views;

import net.sf.oval.constraint.AssertValid;

@Entity
@JsonInclude(Include.NON_EMPTY)
public class Owner extends Person {
	@AssertValid
	@JsonView(Views.Details.class)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Address ownerAddress;

	@JsonIgnore
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	List<Vendor> vendorsList;

	public Owner() {
		super();
	}

	public Address getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(Address ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public List<Vendor> getVendorsList() {
		return vendorsList;
	}

	public void setVendorsList(List<Vendor> vendorsList) {
		this.vendorsList = vendorsList;
	}

}
