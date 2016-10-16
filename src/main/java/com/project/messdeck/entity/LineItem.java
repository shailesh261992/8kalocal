package com.project.messdeck.entity;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class LineItem {
	/**
	 * 
	 * We keep count to maximum to indicate unlimited food itrm
	 * 
	 */
	@OneToOne(optional = false)
	private VendorItem vendorItem;
	private int count;
	private double cost;

	public LineItem() {
		super();
	}

	public VendorItem getVendorItem() {
		return vendorItem;
	}

	public void setVendorItem(VendorItem vendorItem) {
		this.vendorItem = vendorItem;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
