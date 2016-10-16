package com.project.messdeck.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.project.messdeck.entity.Name;
import com.project.messdeck.entity.Owner;
import com.project.messdeck.entity.Vendor;
import com.project.messdeck.testdata.VendorData;
import com.project.messdeck.utils.TestUtils;

@DatabaseSetup(value = { "/dbunit/testdata/integrationData.xml" })
public class VendorControllerIntegrationTest extends AbstractControllerIntegrationTest {
	@Test
	public void fetchSummaryTest() throws Exception {
		mockMvc.perform(get("/vendor/1/summary").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void fetchDetailsTest() throws Exception {
		mockMvc.perform(get("/vendor/1/details").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void fetchVendorAccount() throws Exception {
		mockMvc.perform(get("/vendor/1/account").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void createTest() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/owner/1/summary").accept(contentType)).andDo(print())
				.andExpect(status().isOk());
		Owner owner = (Owner) TestUtils
				.convertJsonToObject(resultActions.andReturn().getResponse().getContentAsString(), Owner.class);

		owner.setName(new Name("Shailesh", "Kadam"));

		Vendor saiVendor = VendorData.getSaiVendor();
		saiVendor.setOwner(owner);
		String jsonString = TestUtils.convertObjectToJsonString(saiVendor);
		System.out.println("##### JSON : " + jsonString);
		mockMvc.perform(post("/vendor/").accept(contentType).contentType(contentType).content(jsonString))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void updateTest() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/vendor/1/details").accept(contentType)).andDo(print());

		Vendor vendor = (Vendor) TestUtils
				.convertJsonToObject(resultActions.andReturn().getResponse().getContentAsString(), Vendor.class);

		vendor.setMessName("Shailesh Mess");

		mockMvc.perform(put("/vendor/").accept(contentType).contentType(contentType)
				.content(TestUtils.convertObjectToJsonString(vendor))).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void deleteTest() throws Exception {
		mockMvc.perform(delete("/vendor/1")).andDo(print()).andExpect(status().isOk());
	}

}
