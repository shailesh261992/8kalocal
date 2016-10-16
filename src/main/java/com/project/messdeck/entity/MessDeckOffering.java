package com.project.messdeck.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.project.messdeck.serializer.LocalDateTimeAttributeConverter;
import com.project.messdeck.serializer.LocalTimeAttributeConverter;

@Entity
public class MessDeckOffering extends AbstractEntity {
	@ManyToOne(optional = false)
	private VendorAccount vendorAccount;
	@Column(nullable = false)
	private ServiceType serviceType;
	private int capacityOfMembers;
	private boolean isVegeterian;
	private boolean isCustomizable; // Whether it is allowed to customer to
									// customize a service
	private boolean isUnlimited; // Is service is unlimited
	private double cost;
	@Transient
	private Meal genericMeal;

	@JsonDeserialize(using = LocalTimeDeserializer.class)
	@JsonSerialize(using = LocalTimeSerializer.class)
	@Convert(converter = LocalTimeAttributeConverter.class)
	private LocalTime startTime;

	@JsonDeserialize(using = LocalTimeDeserializer.class)
	@JsonSerialize(using = LocalTimeSerializer.class)
	@Convert(converter = LocalTimeAttributeConverter.class)
	private LocalTime endTime;

	private double penaltyPercentage;
	private long subscribeThreshold;
	private long unSubscribeThreshold;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime effectiveFrom;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime effectiveTill;

	@JsonIgnore
	@OneToMany(mappedBy = "messDeckService")
	private List<MessDeckOfferingInstance> messDeckServiceInstances;

	public MessDeckOffering() {
		super();
	}

	public VendorAccount getVendorAccount() {
		return vendorAccount;
	}

	public void setVendorAccount(VendorAccount vendorAccount) {
		this.vendorAccount = vendorAccount;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public int getCapacityOfMembers() {
		return capacityOfMembers;
	}

	public void setCapacityOfMembers(int capacityOfMembers) {
		this.capacityOfMembers = capacityOfMembers;
	}

	public boolean isVegeterian() {
		return isVegeterian;
	}

	public void setVegeterian(boolean isVegeterian) {
		this.isVegeterian = isVegeterian;
	}

	public boolean isCustomizable() {
		return isCustomizable;
	}

	public void setCustomizable(boolean isCustomizable) {
		this.isCustomizable = isCustomizable;
	}

	public boolean isUnlimited() {
		return isUnlimited;
	}

	public void setUnlimited(boolean isUnlimited) {
		this.isUnlimited = isUnlimited;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Meal getGenericMeal() {
		return genericMeal;
	}

	public void setGenericMeal(Meal genericMeal) {
		this.genericMeal = genericMeal;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public double getPenaltyPercentage() {
		return penaltyPercentage;
	}

	public void setPenaltyPercentage(double penaltyPercentage) {
		this.penaltyPercentage = penaltyPercentage;
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

	public List<MessDeckOfferingInstance> getMessDeckServiceInstances() {
		return messDeckServiceInstances;
	}

	public void setMessDeckServiceInstances(List<MessDeckOfferingInstance> messDeckServiceInstances) {
		this.messDeckServiceInstances = messDeckServiceInstances;
	}

	public LocalDateTime getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(LocalDateTime effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	public LocalDateTime getEffectiveTill() {
		return effectiveTill;
	}

	public void setEffectiveTill(LocalDateTime effectiveTill) {
		this.effectiveTill = effectiveTill;
	}

}
