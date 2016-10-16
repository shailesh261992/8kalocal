package com.project.messdeck.service;

import com.project.messdeck.entity.Customer;
import com.project.messdeck.entity.CustomerAccount;

public interface CustomerService extends CRUDService<Customer> {

	public Customer readDetails(Long id);

	public CustomerAccount fetchCustomerAccount(Long id);

}
