package com.project.messdeck.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import com.project.messdeck.entity.Customer;
import com.project.messdeck.testdata.CustomerData;
import com.project.messdeck.utils.TestUtils;

public class CustomerControllerIntegrationTest extends AbstractControllerIntegrationTest {
	@Test
	public void fetchSummaryTest() throws Exception {
		mockMvc.perform(get("/customer/11/summary").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void fetchDetailsTest() throws Exception {
		mockMvc.perform(get("/customer/11/details").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void fetchCustomerAccountTest() throws Exception {
		mockMvc.perform(get("/customer/11/account").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void createTest() throws Exception {
		Customer customer = CustomerData.getCustomer();
		String jsonString = TestUtils.convertObjectToJsonString(customer);

		mockMvc.perform(post("/customer/").accept(contentType).contentType(contentType).content(jsonString))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void updateTest() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/customer/11/details").accept(contentType)).andDo(print());

		Customer customer = (Customer) TestUtils
				.convertJsonToObject(resultActions.andReturn().getResponse().getContentAsString(), Customer.class);

		customer.setMobileNo("6767676767");

		mockMvc.perform(put("/customer/").accept(contentType).contentType(contentType)
				.content(TestUtils.convertObjectToJsonString(customer))).andDo(print()).andExpect(status().isOk());
	}

}
