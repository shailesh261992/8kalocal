package com.app.messdeck.entity;

import java.time.LocalDateTime;
import java.util.List;

public class VendorAccount {

	private Owner owner;
	private String managerMobNo;
	private LocalDateTime registrationDate;
	private long subscribeThreshold;
	private long unSubscribeThreshold;
	private double penaltyPercentage;
	private double balance;
	private List<MessDeckService> services;
	private List<HardCashPayement> hardCashPayementsTaken;
	private boolean isProvideCustomService; // Allow service to be customized

}
