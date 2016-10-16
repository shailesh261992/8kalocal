package com.project.messdeck.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.project.messdeck.Views;
import com.project.messdeck.serializer.LocalDateTimeAttributeConverter;

@Entity
@JsonInclude(Include.NON_EMPTY)
public class VendorAccount extends AbstractEntity {
	@JsonIgnore
	@OneToOne(optional = false, mappedBy = "vendorAccount", fetch = FetchType.LAZY)
	private Vendor vendor;

	@JsonView(Views.Summary.class)
	private String managerMobNo;

	@JsonView(Views.Summary.class)
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime registrationDate;

	@JsonView(Views.Summary.class)
	private long subscribeThreshold;

	@JsonView(Views.Summary.class)
	private long unSubscribeThreshold;
	@JsonView(Views.Summary.class)
	private double penaltyPercentage;
	@JsonView(Views.Summary.class)
	private boolean isProvideCustomService; // Allow service to be customized

	@JsonIgnore
	@OneToMany(mappedBy = "vendorAccount", fetch = FetchType.LAZY)
	private Set<VendorItem> vendorItems;

	@OneToMany(mappedBy = "vendorAccount", fetch = FetchType.LAZY)
	private Set<Meal> setOfMeals;

	@JsonIgnore
	@OneToMany(mappedBy = "vendorAccount")
	private List<MessDeckOffering> messDeckOfferings;

	@JsonIgnore
	@OneToMany(mappedBy = "vendorAccount")
	private List<HardCashPayment> hardCashPayementsTaken;

	public VendorAccount() {
		super();
	}

	public String getManagerMobNo() {
		return managerMobNo;
	}

	public void setManagerMobNo(String managerMobNo) {
		this.managerMobNo = managerMobNo;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public long getSubscribeThreshold() {
		return subscribeThreshold;
	}

	public void setSubscribeThreshold(long subscribeThreshold) {
		this.subscribeThreshold = subscribeThreshold;
	}

	public long getUnSubscribeThreshold() {
		return unSubscribeThreshold;
	}

	public void setUnSubscribeThreshold(long unSubscribeThreshold) {
		this.unSubscribeThreshold = unSubscribeThreshold;
	}

	public double getPenaltyPercentage() {
		return penaltyPercentage;
	}

	public void setPenaltyPercentage(double penaltyPercentage) {
		this.penaltyPercentage = penaltyPercentage;
	}

	public List<MessDeckOffering> getMessDeckOfferings() {
		return messDeckOfferings;
	}

	public void setMessDeckOfferings(List<MessDeckOffering> messDeckOfferings) {
		this.messDeckOfferings = messDeckOfferings;
	}

	public List<HardCashPayment> getHardCashPayementsTaken() {
		return hardCashPayementsTaken;
	}

	public void setHardCashPayementsTaken(List<HardCashPayment> hardCashPayementsTaken) {
		this.hardCashPayementsTaken = hardCashPayementsTaken;
	}

	public boolean isProvideCustomService() {
		return isProvideCustomService;
	}

	public void setProvideCustomService(boolean isProvideCustomService) {
		this.isProvideCustomService = isProvideCustomService;
	}

	public Set<VendorItem> getVendorItems() {
		return vendorItems;
	}

	public void setVendorItems(Set<VendorItem> vendorItems) {
		this.vendorItems = vendorItems;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Set<Meal> getSetOfMeals() {
		return setOfMeals;
	}

	public void setSetOfMeals(Set<Meal> setOfMeals) {
		this.setOfMeals = setOfMeals;
	}

}
