package com.project.messdeck.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.messdeck.testdata.ItemData;

public class ItemServiceImplIntegrationTest extends AbstractServiceIntegrationTest {

	@Autowired
	private ItemService service;

	@Test
	public void createTest() {
		service.create(ItemData.getItemBatata());
	}

}
