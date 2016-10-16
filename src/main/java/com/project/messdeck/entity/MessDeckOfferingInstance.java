package com.project.messdeck.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.project.messdeck.serializer.LocalDateAttributeConverter;

@Entity
public class MessDeckOfferingInstance extends AbstractEntity {
	@ManyToOne(optional = false)
	private MessDeckOffering messDeckService;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Meal meal;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate serviceDate;

	@JsonIgnore
	@OneToMany(mappedBy = "messDeckServiceInstance")
	List<CustomerOrder> orders;

	private int capacityOfMembers;

	public MessDeckOfferingInstance() {
		super();
	}

	public MessDeckOffering getMessDeckService() {
		return messDeckService;
	}

	public void setMessDeckService(MessDeckOffering messDeckService) {
		this.messDeckService = messDeckService;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public LocalDate getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(LocalDate serviceDate) {
		this.serviceDate = serviceDate;
	}

	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}

	public int getCapacityOfMembers() {
		return capacityOfMembers;
	}

	public void setCapacityOfMembers(int capacityOfMembers) {
		this.capacityOfMembers = capacityOfMembers;
	}

}
