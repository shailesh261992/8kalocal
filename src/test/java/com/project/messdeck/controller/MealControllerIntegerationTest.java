package com.project.messdeck.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import com.project.messdeck.entity.Meal;
import com.project.messdeck.entity.MealItem;
import com.project.messdeck.entity.VendorAccount;
import com.project.messdeck.utils.TestUtils;

public class MealControllerIntegerationTest extends AbstractControllerIntegrationTest {

	@Test
	public void fetchTest() throws Exception {
		mockMvc.perform(get("/meal/1").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void createTest() throws Exception {

		MealItem mealItem;
		ResultActions resultActions;

		Meal meal = new Meal();
		meal.setName("MH RicePlate");
		meal.setVegeterian(true);
		meal.setDescription("Description");

		Set<MealItem> mealItems = new HashSet<>();

		resultActions = mockMvc.perform(get("/mealItem/2").accept(contentType)).andDo(print())
				.andExpect(status().isOk());
		mealItem = (MealItem) TestUtils
				.convertJsonToObject(resultActions.andReturn().getResponse().getContentAsString(), MealItem.class);

		mealItems.add(mealItem);

		resultActions = mockMvc.perform(get("/mealItem/2").accept(contentType)).andDo(print())
				.andExpect(status().isOk());
		mealItem = (MealItem) TestUtils
				.convertJsonToObject(resultActions.andReturn().getResponse().getContentAsString(), MealItem.class);

		mealItems.add(mealItem);

		meal.setMealItems(mealItems);
		VendorAccount vendorAccount = new VendorAccount();
		vendorAccount.setId(1);
		meal.setVendorAccount(vendorAccount);

		mockMvc.perform(post("/meal/").accept(contentType).contentType(contentType)
				.content(com.project.messdeck.utils.TestUtils.convertObjectToJsonString(meal))).andDo(print())
				.andExpect(status().isOk());

		System.out.println("Tp");

	}

}
