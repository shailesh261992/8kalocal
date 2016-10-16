package com.project.messdeck.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.messdeck.Views;

@Entity
public class Meal extends AbstractEntity {

	@Column(unique = true)
	@JsonView(Views.Summary.class)
	private String name;

	@JsonView(Views.Summary.class)
	private String description;

	@JsonView(Views.Summary.class)
	private boolean isVegeterian;

	@JsonView(Views.Details.class)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private VendorAccount vendorAccount;

	@JsonView(Views.Summary.class)
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, })
	private Set<MealItem> mealItems;

	public Meal() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isVegeterian() {
		return isVegeterian;
	}

	public void setVegeterian(boolean isVegeterian) {
		this.isVegeterian = isVegeterian;
	}

	public Set<MealItem> getMealItems() {
		return mealItems;
	}

	public void setMealItems(Set<MealItem> mealItems) {
		this.mealItems = mealItems;
	}

	public VendorAccount getVendorAccount() {
		return vendorAccount;
	}

	public void setVendorAccount(VendorAccount vendorAccount) {
		this.vendorAccount = vendorAccount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Meal other = (Meal) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
