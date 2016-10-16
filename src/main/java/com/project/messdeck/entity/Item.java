package com.project.messdeck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Item extends AbstractEntity {

	@Column(unique = true)
	private String name;
	private String description;
	@Column(nullable = false)
	private ItemCategory Category;

	public Item() {
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

	public ItemCategory getCategory() {
		return Category;
	}

	public void setCategory(ItemCategory category) {
		Category = category;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", description=" + description + ", Category=" + Category + ", getId()=" + getId()
				+ "]";
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
		if (!(obj instanceof Item))
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
