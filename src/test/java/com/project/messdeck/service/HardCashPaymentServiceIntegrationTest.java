package com.project.messdeck.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.messdeck.entity.Customer;
import com.project.messdeck.entity.HardCashPayment;
import com.project.messdeck.entity.Owner;
import com.project.messdeck.entity.Vendor;
import com.project.messdeck.testdata.CustomerData;
import com.project.messdeck.testdata.HardCashPayementData;
import com.project.messdeck.testdata.OwnerData;
import com.project.messdeck.testdata.VendorData;

public class HardCashPaymentServiceIntegrationTest extends AbstractServiceIntegrationTest {
	@Autowired
	private HardCashPaymentService service;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private OwnerService ownerService;

	@Test
	public void createTest() {
		Customer customer = customerService.create(CustomerData.getCustomer());

		Owner owner = ownerService.create(OwnerData.getOwnerData());
		Vendor saiVendor = VendorData.getSaiVendor();
		saiVendor.setOwner(owner);
		saiVendor = vendorService.create(saiVendor);

		HardCashPayment hardCashPayment = HardCashPayementData.getHardCashPaymentData();
		hardCashPayment.setCustomerAccount(customer.getCustomerAccount());
		hardCashPayment.setVendorAccount(saiVendor.getVendorAccount());

		service.create(hardCashPayment);

	}

}
