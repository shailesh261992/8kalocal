package com.project.messdeck.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.messdeck.testdata.OwnerData;

public class OwnerServiceImplIntegrationTest extends AbstractServiceIntegrationTest {

	@Autowired
	private OwnerService service;

	@Test
	public void createTest() {
		service.create(OwnerData.getOwnerData());
	}

}
