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
import com.project.messdeck.testdata.OwnerData;
import com.project.messdeck.utils.TestUtils;

@DatabaseSetup(value = { "/dbunit/testdata/integrationData.xml" })
public class OwnerControllerIntegrationTest extends AbstractControllerIntegrationTest {
	@Test
	public void fetchSummaryTest() throws Exception {
		mockMvc.perform(get("/owner/1/summary").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void fetchDetailsTest() throws Exception {
		mockMvc.perform(get("/owner/1/details").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void createTest() throws Exception {
		mockMvc.perform(post("/owner/").accept(contentType).contentType(contentType)
				.content(TestUtils.convertObjectToJsonString(OwnerData.getOwnerData()))).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void updateTest() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/owner/1/details").accept(contentType)).andDo(print());

		Owner owner = (Owner) TestUtils
				.convertJsonToObject(resultActions.andReturn().getResponse().getContentAsString(), Owner.class);

		owner.setName(new Name("Shailesh", "Kadam"));

		mockMvc.perform(put("/owner/").accept(contentType).contentType(contentType)
				.content(TestUtils.convertObjectToJsonString(owner))).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void deleteTest() throws Exception {
		mockMvc.perform(delete("/owner/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void fetchAllVendorsTest() throws Exception {
		mockMvc.perform(get("/owner/1/vendors").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}
}
