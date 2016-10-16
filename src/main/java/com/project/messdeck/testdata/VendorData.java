package com.project.messdeck.testdata;

import com.project.messdeck.entity.EmailID;
import com.project.messdeck.entity.Vendor;

public class VendorData {
	public static Vendor getSaiVendor() {
		Vendor vendor = new Vendor();
		vendor.setMessName("Sai Mess");
		vendor.setEmailID(new EmailID("Sai@gmail.com"));
		vendor.setReceptionNo("9876543210");
		vendor.setVendorAddress(AddressData.getAddressData());
		vendor.setVendorAccount(VendorAccountData.getSaiVendorAccount());

		return vendor;
	}
}
