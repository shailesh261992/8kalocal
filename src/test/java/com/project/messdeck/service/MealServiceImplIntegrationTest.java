package com.project.messdeck.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.project.messdeck.entity.Meal;
import com.project.messdeck.entity.MealItem;
import com.project.messdeck.entity.Owner;
import com.project.messdeck.entity.Vendor;
import com.project.messdeck.entity.VendorItem;
import com.project.messdeck.testdata.OwnerData;
import com.project.messdeck.testdata.VendorData;
import com.project.messdeck.testdata.VendorItemData;

@Transactional
public class MealServiceImplIntegrationTest extends AbstractServiceIntegrationTest {
	@Autowired
	private MealService service;

	@Autowired
	private VendorItemService vendorItemService;

	@Autowired
	private VendorService vendorService;

	@Autowired
	OwnerService ownerService;

	@Autowired
	ItemService itemService;

	@Test
	@Rollback(value = false)
	public void createTest() {
		Owner owner = ownerService.create(OwnerData.getOwnerData());
		Vendor saiVendor = VendorData.getSaiVendor();
		saiVendor.setOwner(owner);
		saiVendor = vendorService.create(saiVendor);
		VendorItem vendorItem_Batata = VendorItemData.getVendorItem_Batata();
		vendorItem_Batata.setVendorAccount(saiVendor.getVendorAccount());
		vendorItem_Batata.setItem(itemService.create(vendorItem_Batata.getItem()));
		vendorItem_Batata = vendorItemService.create(vendorItem_Batata);

		Meal meal = new Meal();
		meal.setName("RicePLate");
		meal.setDescription("RicePlate Description");
		meal.setVendorAccount(saiVendor.getVendorAccount());

		Set<MealItem> mealItems = new HashSet<MealItem>();
		MealItem mealItem = new MealItem();
		mealItem.setCount(1);
		mealItem.setVendorItem(vendorItem_Batata);
		mealItems.add(mealItem);

		MealItem mealItem2 = new MealItem();
		mealItem2.setCount(10);
		mealItem2.setVendorItem(vendorItem_Batata);
		mealItems.add(mealItem2);

		meal.setMealItems(mealItems);
		meal.setVegeterian(true);
		service.create(meal);

	}

}
