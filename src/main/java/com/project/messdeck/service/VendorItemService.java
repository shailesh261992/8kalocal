package com.project.messdeck.service;

import java.util.Set;

import com.project.messdeck.entity.VendorItem;

public interface VendorItemService extends CRUDService<VendorItem> {
	public Set<VendorItem> fetchAll(Long vendorAccountId);
}
