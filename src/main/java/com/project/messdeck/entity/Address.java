package com.project.messdeck.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.messdeck.Views;
import com.project.messdeck.serializer.AreaSerailizer;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@JsonView(Views.Summary.class)
	public long id;

	@JsonView(Views.Summary.class)
	private String addressLine1;

	@JsonView(Views.Summary.class)
	private String addressLine2;

	@JsonSerialize(using = AreaSerailizer.class)
	@JsonView(Views.Summary.class)
	Area area;

	@JsonView(Views.Summary.class)
	private Double lattitude;

	@JsonView(Views.Summary.class)
	private Double longitude;

	public Address() {
		super();
	}

	public Double getLattitude() {
		return lattitude;
	}

	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}
