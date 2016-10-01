package com.app.messdeck.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public class MessDeckService extends AbstractEntity {
	private VendorAccount vendorAccount;
	private ServiceType serviceType;
	private int capacityOfMembers;
	private boolean isVegeterian;
	private boolean isCustomizable; // Whether it is allowed to customer to
									// customize a service
	private boolean isUnlimited; // Is service is unlimited
	private double cost;
	private Meal genericMeal;
	private LocalTime startTime;
	private LocalTime endTime;
	private double penaltyPercentage;
	private long subscribeThreshold;
	private long unSubscribeThreshold;
	private List<MessDeckServiceInstance> messDeckServiceInstances;

}
