package com.app.messdeck.entity;

import java.time.LocalDateTime;
import java.util.List;

public class VendorItem {
	private long vendorItemId;
	private VendorAccount vendor;
	private Item item;
	private Unit unit;
	//private boolean isIndepenedentlySellable;
	private double cost;
	private double rating;
	//private LocalDateTime effectiveDate;
	private List<Review> reviews;

}
