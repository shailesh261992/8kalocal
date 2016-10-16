package com.project.messdeck.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import com.project.messdeck.entity.CustomerAccount;
import com.project.messdeck.entity.HardCashPayment;
import com.project.messdeck.entity.VendorAccount;
import com.project.messdeck.testdata.HardCashPayementData;
import com.project.messdeck.utils.TestUtils;

public class HardCashPaymentControllerIntegrationTest extends AbstractControllerIntegrationTest {
	@Test
	public void fetchTest() throws Exception {
		mockMvc.perform(get("/hardCashPayment/1").accept(contentType)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void createTest() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/customer/11/account").accept(contentType)).andDo(print())
				.andExpect(status().isOk());
		CustomerAccount customerAccount = (CustomerAccount) TestUtils.convertJsonToObject(
				resultActions.andReturn().getResponse().getContentAsString(), CustomerAccount.class);

		resultActions = mockMvc.perform(get("/vendor/1/account").accept(contentType)).andDo(print())
				.andExpect(status().isOk());

		VendorAccount vendorAccount = (VendorAccount) TestUtils
				.convertJsonToObject(resultActions.andReturn().getResponse().getContentAsString(), VendorAccount.class);

		HardCashPayment hardCashPayment = HardCashPayementData.getHardCashPaymentData();
		hardCashPayment.setCustomerAccount(customerAccount);
		hardCashPayment.setVendorAccount(vendorAccount);

		mockMvc.perform(post("/hardCashPayment/").accept(contentType).contentType(contentType)
				.content(TestUtils.convertObjectToJsonString(hardCashPayment))).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void deleteTest() throws Exception {
		mockMvc.perform(delete("/hardCashPayment/1")).andDo(print()).andExpect(status().isOk());
	}
}
