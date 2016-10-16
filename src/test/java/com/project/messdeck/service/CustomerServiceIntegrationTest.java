package com.project.messdeck.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.messdeck.testdata.CustomerData;

public class CustomerServiceIntegrationTest extends AbstractServiceIntegrationTest {

	@Autowired
	private CustomerService service;

	@Test
	public void createTest() {
		service.create(CustomerData.getCustomer());

	}

}
