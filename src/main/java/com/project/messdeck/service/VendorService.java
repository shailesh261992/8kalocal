package com.project.messdeck.service;

import com.project.messdeck.entity.Vendor;
import com.project.messdeck.entity.VendorAccount;

public interface VendorService extends CRUDService<Vendor> {

	public VendorAccount fetchVendorAccount(Long vendorId);

	public Vendor readDetails(Long id);
}
