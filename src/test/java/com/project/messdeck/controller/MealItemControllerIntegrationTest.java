package com.project.messdeck.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import com.project.messdeck.entity.MealItem;
import com.project.messdeck.entity.VendorItem;
import com.project.messdeck.utils.TestUtils;

public class MealItemControllerIntegrationTest extends AbstractControllerIntegrationTest {

	@Test
	public void fetchTest() throws Exception {
		mockMvc.perform(get("/mealItem/2").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void createTest() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/vitem/2").accept(contentType)).andDo(print())
				.andExpect(status().isOk());
		VendorItem vendorItem = (VendorItem) TestUtils
				.convertJsonToObject(resultActions.andReturn().getResponse().getContentAsString(), VendorItem.class);

		MealItem mealItem = new MealItem();
		mealItem.setVendorItem(vendorItem);
		mealItem.setCount(2);

		mockMvc.perform(post("/mealItem/").accept(contentType).contentType(contentType)
				.content(com.project.messdeck.utils.TestUtils.convertObjectToJsonString(mealItem))).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void deleteTest() throws Exception {
		mockMvc.perform(delete("/mealItem/1")).andDo(print()).andExpect(status().isOk());
	}

}
