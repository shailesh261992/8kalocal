package com.project.messdeck.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.messdeck.entity.Meal;
import com.project.messdeck.entity.MealItem;
import com.project.messdeck.entity.MessDeckOffering;
import com.project.messdeck.entity.MessDeckOfferingInstance;
import com.project.messdeck.entity.Owner;
import com.project.messdeck.entity.ServiceType;
import com.project.messdeck.entity.Vendor;
import com.project.messdeck.entity.VendorItem;
import com.project.messdeck.testdata.OwnerData;
import com.project.messdeck.testdata.VendorData;
import com.project.messdeck.testdata.VendorItemData;

public class MessDeckOfferingInstanceServiceImplIntegrationTest extends AbstractServiceIntegrationTest {

	@Autowired
	private MessDeckOfferingInstanceService service;

	@Autowired
	OwnerService ownerService;

	@Autowired
	VendorService vendorService;

	@Autowired
	MessDeckOfferingService messDeckOfferingService;

	@Autowired
	private MealService mealService;

	@Autowired
	private VendorItemService vendorItemService;

	@Autowired
	ItemService itemService;

	@Test
	public void createTest() {

		MessDeckOfferingInstance messDeckOfferingInstance = new MessDeckOfferingInstance();

		Owner owner = ownerService.create(OwnerData.getOwnerData());
		Vendor saiVendor = VendorData.getSaiVendor();
		saiVendor.setOwner(owner);
		vendorService.create(saiVendor);

		VendorItem vendorItem_Batata = VendorItemData.getVendorItem_Batata();
		vendorItem_Batata.setVendorAccount(saiVendor.getVendorAccount());
		vendorItem_Batata.setItem(itemService.create(vendorItem_Batata.getItem()));
		vendorItem_Batata = vendorItemService.create(vendorItem_Batata);

		Meal meal = new Meal();
		meal.setName("RicePLate");
		meal.setDescription("RicePlate Description");

		Set<MealItem> mealItems = new HashSet<MealItem>();
		MealItem mealItem = new MealItem();
		mealItem.setCount(1);
		mealItem.setVendorItem(vendorItem_Batata);
		mealItems.add(mealItem);

		meal.setMealItems(mealItems);
		meal.setVegeterian(true);
		meal = mealService.create(meal);

		MessDeckOffering messDeckOffering = new MessDeckOffering();
		messDeckOffering.setCapacityOfMembers(50);
		messDeckOffering.setCost(60);
		messDeckOffering.setCustomizable(false);
		messDeckOffering.setEndTime(LocalTime.of(12, 30));
		messDeckOffering.setStartTime(LocalTime.of(10, 30));
		messDeckOffering.setPenaltyPercentage(20);
		messDeckOffering.setUnlimited(false);
		messDeckOffering.setSubscribeThreshold(60000);
		messDeckOffering.setUnSubscribeThreshold(60000);
		messDeckOffering.setVegeterian(true);
		messDeckOffering.setVendorAccount(saiVendor.getVendorAccount());
		messDeckOffering.setServiceType(ServiceType.LUNCH);

		messDeckOfferingService.create(messDeckOffering);

		messDeckOfferingInstance.setCapacityOfMembers(50);
		messDeckOfferingInstance.setMessDeckService(messDeckOffering);
		messDeckOfferingInstance.setServiceDate(LocalDate.now());
		messDeckOfferingInstance.setMeal(meal);

		service.create(messDeckOfferingInstance);

	}

}
