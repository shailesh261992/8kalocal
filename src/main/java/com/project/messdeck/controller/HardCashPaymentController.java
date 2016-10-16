package com.project.messdeck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.messdeck.entity.HardCashPayment;
import com.project.messdeck.service.HardCashPaymentService;

@RestController
@RequestMapping(value = "/hardCashPayment")
public class HardCashPaymentController {

	@Autowired
	private HardCashPaymentService service;

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HardCashPayment createItem(@RequestBody HardCashPayment hardCashPayment) {
		return service.create(hardCashPayment);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HardCashPayment fetchItem(@PathVariable long id) {
		return service.readSummary(id);

	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HardCashPayment updateItem(@RequestBody HardCashPayment hardCashPayment) {
		return service.update(hardCashPayment);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteItem(@PathVariable long id) {
		return service.delete(id);

	}

}
