package com.project.messdeck.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import com.project.messdeck.entity.Item;
import com.project.messdeck.entity.Unit;
import com.project.messdeck.entity.VendorAccount;
import com.project.messdeck.entity.VendorItem;
import com.project.messdeck.utils.TestUtils;

public class VendorItemControllerIntegrationTest extends AbstractControllerIntegrationTest {
	@Test
	public void fetchTest() throws Exception {
		mockMvc.perform(get("/vitem/2").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void createTest() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/item/6").accept(contentType)).andDo(print())
				.andExpect(status().isOk());
		Item item = (Item) TestUtils.convertJsonToObject(resultActions.andReturn().getResponse().getContentAsString(),
				Item.class);

		resultActions = mockMvc.perform(get("/vendor/1/account").accept(contentType)).andDo(print())
				.andExpect(status().isOk());

		VendorAccount vendorAccount = (VendorAccount) TestUtils
				.convertJsonToObject(resultActions.andReturn().getResponse().getContentAsString(), VendorAccount.class);

		VendorItem vendorItem = new VendorItem();
		vendorItem.setItem(item);
		vendorItem.setVendorAccount(vendorAccount);
		vendorItem.setCost(60);
		vendorItem.setUnit(Unit.BOWL);
		vendorItem.setRating(4);

		mockMvc.perform(post("/vitem/").accept(contentType).contentType(contentType)
				.content(com.project.messdeck.utils.TestUtils.convertObjectToJsonString(vendorItem))).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void updateTest() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/vitem/2").accept(contentType)).andDo(print())
				.andExpect(status().isOk());
		VendorItem vitem = (VendorItem) TestUtils
				.convertJsonToObject(resultActions.andReturn().getResponse().getContentAsString(), VendorItem.class);
		// vitem.setItem(Ite);
		vitem.getItem().setName("Name Changed");
		vitem.setCost(50);

		mockMvc.perform(put("/vitem/").accept(contentType).contentType(contentType)
				.content(com.project.messdeck.utils.TestUtils.convertObjectToJsonString(vitem))).andDo(print())
				.andExpect(status().isOk());

	}

	@Test
	public void deleteTest() throws Exception {
		mockMvc.perform(delete("/vitem/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void fetchAllTest() throws Exception {
		mockMvc.perform(get("/vitem/all/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void fetchVendorItemUnitsTest() throws Exception {
		mockMvc.perform(get("/vitem/units").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

}
