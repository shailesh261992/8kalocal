package com.project.messdeck.repository;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.messdeck.entity.VendorItem;

@Transactional
public class MealItemRepositoryIntegrationTest extends AbstractRepositoryIntegrationTest {

	@Autowired
	private MealItemRepository repository;

	@Test
	public void test() {
		VendorItem vendorItem = new VendorItem();
		vendorItem.setId(1);

		System.out.println("OOOOOOOO " + repository.findByVendorItemAndCount(vendorItem, 1));

	}

}
