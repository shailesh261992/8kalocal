package com.project.messdeck.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "count", "vendor_item" }) })
public class MealItem extends AbstractEntity {
	@ManyToOne(optional = false)
	private VendorItem vendorItem;
	private int count;

	public MealItem() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((vendorItem == null) ? 0 : vendorItem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MealItem other = (MealItem) obj;
		if (vendorItem == null) {
			if (other.vendorItem != null)
				return false;
		} else if (!vendorItem.equals(other.vendorItem))
			return false;
		return true;
	}

}
