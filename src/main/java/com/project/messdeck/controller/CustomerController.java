package com.project.messdeck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.project.messdeck.Views;
import com.project.messdeck.entity.Customer;
import com.project.messdeck.entity.CustomerAccount;
import com.project.messdeck.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	CustomerService service;

	@JsonView(Views.Summary.class)
	@RequestMapping(value = "/{id}/summary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer fetchCustomerSummary(@PathVariable long id) {
		return service.readSummary(id);

	}

	@JsonView(Views.Details.class)
	@RequestMapping(value = "/{id}/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer fetchCustomerDetails(@PathVariable long id) {
		return service.readDetails(id);

	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer createItem(@RequestBody Customer customer) {
		return service.create(customer);

	}

	@RequestMapping(value = "/{id}/account", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @JsonIgnoreProperties(allowGetters = true) CustomerAccount fetchVendorAccount(@PathVariable long id) {
		return service.fetchCustomerAccount(id);

	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@RequestBody Customer customer) {
		return service.update(customer);

	}

}
