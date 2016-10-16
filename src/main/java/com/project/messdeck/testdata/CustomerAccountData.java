package com.project.messdeck.testdata;

import com.project.messdeck.entity.CustomerAccount;
import com.project.messdeck.entity.CustomerAccountStatus;

public class CustomerAccountData {

	public static CustomerAccount getCustomerAccount() {
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setBalance(100);
		customerAccount.setCustomerAccountStatus(CustomerAccountStatus.VERIFIED);
		return customerAccount;
	}

}
