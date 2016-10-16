package com.project.messdeck.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.messdeck.entity.MessDeckOffering;
import com.project.messdeck.entity.Owner;
import com.project.messdeck.entity.Vendor;
import com.project.messdeck.testdata.MessDeckOfferingData;
import com.project.messdeck.testdata.OwnerData;
import com.project.messdeck.testdata.VendorData;

public class MessDeckOfferingServiceImplIntegrationTest extends AbstractServiceIntegrationTest {
	@Autowired
	OwnerService ownerService;

	@Autowired
	VendorService vendorService;

	@Autowired
	MessDeckOfferingService service;

	@Test
	public void createTest() {

		Owner owner = ownerService.create(OwnerData.getOwnerData());
		Vendor saiVendor = VendorData.getSaiVendor();
		saiVendor.setOwner(owner);
		vendorService.create(saiVendor);

		MessDeckOffering messDeckOffering = MessDeckOfferingData.getMessDeckOfferingData();
		messDeckOffering.setVendorAccount(saiVendor.getVendorAccount());

		service.create(messDeckOffering);

	}

}
