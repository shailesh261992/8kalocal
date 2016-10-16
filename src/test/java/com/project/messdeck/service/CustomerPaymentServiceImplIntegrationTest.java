package com.project.messdeck.service;

import java.time.LocalDateTime;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.messdeck.entity.Customer;
import com.project.messdeck.entity.CustomerPayement;
import com.project.messdeck.entity.HardCashPayment;
import com.project.messdeck.entity.Owner;
import com.project.messdeck.entity.Vendor;
import com.project.messdeck.testdata.CustomerData;
import com.project.messdeck.testdata.OwnerData;
import com.project.messdeck.testdata.VendorData;

public class CustomerPaymentServiceImplIntegrationTest extends AbstractServiceIntegrationTest {

	@Autowired
	private OwnerService ownerService;

	@Autowired
	private CustomerPayementService service;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private VendorService vendorService;

	@Test
	public void createTest() {

		Owner owner = ownerService.create(OwnerData.getOwnerData());
		Vendor saiVendor = VendorData.getSaiVendor();
		saiVendor.setOwner(owner);
		vendorService.create(saiVendor);

		Customer customer = customerService.create(CustomerData.getCustomer());

		CustomerPayement customerPayement = new CustomerPayement();
		customerPayement.setAmount(1000);
		customerPayement.setTimestamp(LocalDateTime.now());
		customerPayement.setCustomerAccount(customer.getCustomerAccount());

		HardCashPayment hardCashPayement = new HardCashPayment();
		hardCashPayement.setAmount(1000);
		hardCashPayement.setCustomerAccount(customer.getCustomerAccount());
		hardCashPayement.setRecivedBy("Parag");

		hardCashPayement.setVendorAccount(saiVendor.getVendorAccount());

		customerPayement.setPayment(hardCashPayement);

		service.create(customerPayement);

	}

}
