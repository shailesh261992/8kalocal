package com.project.messdeck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.messdeck.aspects.ValidateWithOval;
import com.project.messdeck.entity.Customer;
import com.project.messdeck.entity.CustomerAccount;
import com.project.messdeck.entity.CustomerAccountStatus;
import com.project.messdeck.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;

	@ValidateWithOval
	@Override
	public Customer create(Customer obj) {
		obj.setId(0);
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setCustomerAccountStatus(CustomerAccountStatus.NOT_VERIFIED);
		obj.setCustomerAccount(customerAccount);
		customerAccount.setCustomer(obj);
		return repository.save(obj);
	}

	@Override
	public Customer readSummary(Long id) {
		return getResorce(repository, id);
	}

	@ValidateWithOval
	@Override
	public Customer update(Customer obj) {
		Customer customer = this.readSummary(obj.getId());
		obj.setCustomerAccount(customer.getCustomerAccount());
		return repository.save(obj);
	}

	@Override
	public boolean delete(Long id) {
		repository.delete(id);
		return true;
	}

	@Override
	public Customer readDetails(Long id) {
		Customer customer = getResorce(repository, id);
		customer.getCustomerAccount().getBalance();
		return customer;
	}

	@Override
	public CustomerAccount fetchCustomerAccount(Long id) {
		Customer customer = getResorce(repository, id);
		CustomerAccount customerAccount = customer.getCustomerAccount();
		customerAccount.getBalance();
		return customerAccount;
	}

}
