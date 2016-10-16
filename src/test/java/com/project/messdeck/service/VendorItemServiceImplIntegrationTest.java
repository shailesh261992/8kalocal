package com.project.messdeck.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.messdeck.entity.Owner;
import com.project.messdeck.entity.Vendor;
import com.project.messdeck.entity.VendorItem;
import com.project.messdeck.testdata.OwnerData;
import com.project.messdeck.testdata.VendorData;
import com.project.messdeck.testdata.VendorItemData;

public class VendorItemServiceImplIntegrationTest extends AbstractServiceIntegrationTest {
	@Autowired
	private VendorItemService service;

	@Autowired
	private VendorService vendorService;

	@Autowired
	OwnerService ownerService;

	@Autowired
	ItemService itemService;

	@Test
	public void createTest() {

		Owner owner = ownerService.create(OwnerData.getOwnerData());
		Vendor saiVendor = VendorData.getSaiVendor();
		saiVendor.setOwner(owner);
		saiVendor = vendorService.create(saiVendor);
		VendorItem vendorItem_Batata = VendorItemData.getVendorItem_Batata();
		vendorItem_Batata.setVendorAccount(saiVendor.getVendorAccount());
		vendorItem_Batata.setItem(itemService.create(vendorItem_Batata.getItem()));
		service.create(vendorItem_Batata);
	}

}
