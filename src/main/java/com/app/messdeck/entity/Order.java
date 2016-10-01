package com.app.messdeck.entity;

import java.util.HashMap;
import java.util.List;

public class Order {
	private long orderID;
	private CustomerAccount customerAccount;
	private MessDeckServiceInstance messDeckServiceInstance;
	// private Meal meal;
	// private HashMap<VendorItem, Integer> extraMeal; // map of extra meal
	// items &
	// private List<ExtraMealItem> extraMealItems; // count
	private List<LineItem> orderLineItems;
	// private double serviceCost;
	// private double extraMealCost;
	private boolean isCustomized;
	private double totalCost;
	private OrderStatus status;

}
