package com.project.messdeck.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.messdeck.entity.Owner;
import com.project.messdeck.entity.Vendor;
import com.project.messdeck.testdata.OwnerData;
import com.project.messdeck.testdata.VendorData;

public class VendorServiceImplIntegrationTest extends AbstractServiceIntegrationTest {

	@Autowired
	private VendorService service;

	@Autowired
	private OwnerService ownerService;

	@Test
	public void createTest() {
		Owner owner = ownerService.create(OwnerData.getOwnerData());
		Vendor saiVendor = VendorData.getSaiVendor();
		saiVendor.setOwner(owner);
		service.create(saiVendor);
	}

}
