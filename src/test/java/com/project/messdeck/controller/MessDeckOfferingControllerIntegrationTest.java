package com.project.messdeck.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import com.project.messdeck.entity.MessDeckOffering;
import com.project.messdeck.entity.VendorAccount;
import com.project.messdeck.testdata.MessDeckOfferingData;
import com.project.messdeck.utils.TestUtils;

public class MessDeckOfferingControllerIntegrationTest extends AbstractControllerIntegrationTest {
	@Test
	public void fetchTest() throws Exception {
		mockMvc.perform(get("/messDeckOffering/1").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void createTest() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/vendor/1/account").accept(contentType)).andDo(print())
				.andExpect(status().isOk());

		VendorAccount vendorAccount = (VendorAccount) TestUtils
				.convertJsonToObject(resultActions.andReturn().getResponse().getContentAsString(), VendorAccount.class);

		MessDeckOffering messDeckOffering = MessDeckOfferingData.getMessDeckOfferingData();
		messDeckOffering.setVendorAccount(vendorAccount);

		mockMvc.perform(post("/messDeckOffering/").accept(contentType).contentType(contentType)
				.content(com.project.messdeck.utils.TestUtils.convertObjectToJsonString(messDeckOffering)))
				.andDo(print()).andExpect(status().isOk());

	}

	@Test
	public void updateTest() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/messDeckOffering/1").accept(contentType)).andDo(print())
				.andExpect(status().isOk());

		MessDeckOffering messDeckOffering = (MessDeckOffering) TestUtils.convertJsonToObject(
				resultActions.andReturn().getResponse().getContentAsString(), MessDeckOffering.class);

		messDeckOffering.setPenaltyPercentage(55);

		mockMvc.perform(put("/messDeckOffering/").accept(contentType).contentType(contentType)
				.content(TestUtils.convertObjectToJsonString(messDeckOffering))).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void deleteTest() throws Exception {
		mockMvc.perform(delete("/messDeckOffering/1")).andDo(print()).andExpect(status().isOk());
	}
}
