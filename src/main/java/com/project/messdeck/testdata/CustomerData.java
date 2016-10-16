package com.project.messdeck.testdata;

import com.project.messdeck.entity.Customer;
import com.project.messdeck.entity.CustomerAccount;
import com.project.messdeck.entity.EmailID;
import com.project.messdeck.entity.Gender;
import com.project.messdeck.entity.Name;

public class CustomerData {

	public static Customer getCustomer() {
		Customer customer = new Customer();
		customer.setEmailID(new EmailID("Shailesh261992@gmail.com"));
		customer.setGender(Gender.MALE);
		customer.setMobileNo("7276248187");
		customer.setName(new Name("Shailesh", "Kadam"));
		CustomerAccount customerAccount = CustomerAccountData.getCustomerAccount();
		customerAccount.setCustomer(customer);
		customer.setCustomerAccount(customerAccount);

		return customer;
	}

}
