package com.project.messdeck.service;

import java.util.List;
import java.util.Set;

import com.project.messdeck.entity.Meal;
import com.project.messdeck.entity.MessDeckOffering;
import com.project.messdeck.entity.VendorItem;

public interface VendorAccountService {

	Set<Meal> fetchAllMeals(Long vendorAccountNumber);

	Set<VendorItem> fetchAllVendorItems(Long vendorAccountNumber);

	List<MessDeckOffering> fethAllMessDeckOffering(Long vendorAccountNumber);
}
