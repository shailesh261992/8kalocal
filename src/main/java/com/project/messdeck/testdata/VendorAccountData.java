package com.project.messdeck.testdata;

import java.time.LocalDateTime;

import com.project.messdeck.entity.VendorAccount;

public class VendorAccountData {

	public static VendorAccount getSaiVendorAccount() {
		VendorAccount vendorAccount = new VendorAccount();
		
		vendorAccount.setManagerMobNo("7676767676");
		vendorAccount.setPenaltyPercentage(20);
		vendorAccount.setRegistrationDate(LocalDateTime.now());
		vendorAccount.setSubscribeThreshold(120000);
		vendorAccount.setUnSubscribeThreshold(120000);
		return vendorAccount;
	}

}
