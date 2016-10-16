package com.project.messdeck.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import com.project.messdeck.entity.Meal;
import com.project.messdeck.entity.MessDeckOffering;
import com.project.messdeck.entity.MessDeckOfferingInstance;
import com.project.messdeck.utils.TestUtils;

public class MessDeckOfferingInstanceControllerIntegrationTest extends AbstractControllerIntegrationTest {

	@Test
	public void fetchTest() throws Exception {
		mockMvc.perform(get("/messDeckOfferingInstance/1").accept(contentType)).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void deleteTest() throws Exception {
		mockMvc.perform(delete("/messDeckOfferingInstance/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void createTest() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/messDeckOffering/1").accept(contentType)).andDo(print())
				.andExpect(status().isOk());

		MessDeckOffering messDeckOffering = (MessDeckOffering) TestUtils.convertJsonToObject(
				resultActions.andReturn().getResponse().getContentAsString(), MessDeckOffering.class);

		MessDeckOfferingInstance messDeckOfferingInstance = new MessDeckOfferingInstance();
		messDeckOfferingInstance.setCapacityOfMembers(15);
		messDeckOfferingInstance.setMessDeckService(messDeckOffering);
		messDeckOfferingInstance.setServiceDate(LocalDate.now());

		Meal meal = new Meal();
		meal.setId(1);

		messDeckOfferingInstance.setMeal(meal);

		mockMvc.perform(post("/messDeckOfferingInstance/").accept(contentType).contentType(contentType)
				.content(com.project.messdeck.utils.TestUtils.convertObjectToJsonString(messDeckOfferingInstance)))
				.andDo(print()).andExpect(status().isOk());

	}

}
