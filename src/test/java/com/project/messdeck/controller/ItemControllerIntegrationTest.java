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
import com.project.messdeck.entity.Item;
import com.project.messdeck.testdata.ItemData;
import com.project.messdeck.utils.TestUtils;

@DatabaseSetup(value = { "/dbunit/testdata/integrationData.xml" })
public class ItemControllerIntegrationTest extends AbstractControllerIntegrationTest {

	@Test
	public void fetchTest() throws Exception {
		mockMvc.perform(get("/item/2").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void createTest() throws Exception {
		mockMvc.perform(post("/item/").accept(contentType).contentType(contentType)
				.content(com.project.messdeck.utils.TestUtils.convertObjectToJsonString(ItemData.getItemBatata())))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void updateTest() throws Exception {
		ResultActions resultActions = mockMvc
				.perform(post("/item/").accept(contentType).contentType(contentType).content(
						com.project.messdeck.utils.TestUtils.convertObjectToJsonString(ItemData.getItemBatata())))
				.andDo(print());

		Item item = (Item) TestUtils.convertJsonToObject(resultActions.andReturn().getResponse().getContentAsString(),
				Item.class);

		item.setDescription("Decription Modified");

		mockMvc.perform(put("/item/").accept(contentType).contentType(contentType)
				.content(com.project.messdeck.utils.TestUtils.convertObjectToJsonString(item))).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void deleteTest() throws Exception {
		mockMvc.perform(delete("/item/2")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void fetchAllTest() throws Exception {
		mockMvc.perform(get("/item/all")).andDo(print()).andExpect(status().isOk());
	}

}
