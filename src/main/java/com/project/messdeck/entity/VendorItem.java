package com.project.messdeck.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;
import com.project.messdeck.Views;

@Entity
@JsonInclude(Include.NON_EMPTY)
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "item", "vendor_account" }) })
public class VendorItem extends AbstractEntity {

	@JsonView(Views.Details.class)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private VendorAccount vendorAccount;

	@JsonView(Views.Summary.class)
	@ManyToOne(optional = false)
	private Item item;

	@JsonView(Views.Summary.class)
	private Unit unit;

	@JsonView(Views.Summary.class)
	private double cost;

	@JsonView(Views.Summary.class)
	private double rating;

	@JsonIgnore
	@OneToMany(mappedBy = "vendorItem")
	private List<Review> reviews;

	public VendorItem() {
		super();
	}

	public VendorAccount getVendorAccount() {
		return vendorAccount;
	}

	public void setVendorAccount(VendorAccount vendorAccount) {
		this.vendorAccount = vendorAccount;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((vendorAccount == null) ? 0 : vendorAccount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof VendorItem))
			return false;
		VendorItem other = (VendorItem) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (vendorAccount == null) {
			if (other.vendorAccount != null)
				return false;
		} else if (!vendorAccount.equals(other.vendorAccount))
			return false;
		return true;
	}

}
