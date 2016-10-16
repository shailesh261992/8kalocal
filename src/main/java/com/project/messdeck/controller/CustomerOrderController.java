package com.project.messdeck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.messdeck.Views;
import com.project.messdeck.entity.CustomerOrder;
import com.project.messdeck.service.CustomerOrderService;

@RestController
@RequestMapping(value = "/order")
public class CustomerOrderController {
	@Autowired
	private CustomerOrderService service;

	@JsonView(Views.Summary.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerOrder fetchCustomerOrder(@PathVariable long id) {
		return service.readSummary(id);

	}

	@JsonView(Views.Details.class)
	@RequestMapping(value = "/{id}/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerOrder fetchCustomerOrderDetrails(@PathVariable long id) {
		return service.readDetails(id);

	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerOrder createVendorItem(@RequestBody CustomerOrder customerOrder) {
		CustomerOrder cteatedItem = service.create(customerOrder);
		return cteatedItem;

	}

}
