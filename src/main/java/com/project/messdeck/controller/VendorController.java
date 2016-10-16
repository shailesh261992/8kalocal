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
import com.project.messdeck.entity.Vendor;
import com.project.messdeck.entity.VendorAccount;
import com.project.messdeck.service.VendorService;

@RestController
@RequestMapping(value = "/vendor")
public class VendorController {

	@Autowired
	private VendorService service;

	@JsonView(Views.Summary.class)
	@RequestMapping(value = "/{id}/summary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Vendor fetchVendorSummary(@PathVariable long id) {
		return service.readSummary(id);

	}

	@JsonView(Views.Details.class)
	@RequestMapping(value = "/{id}/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Vendor fetchVendorDetails(@PathVariable long id) {
		return service.readDetails(id);

	}

	@RequestMapping(value = "/{id}/account", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @JsonIgnoreProperties(allowGetters = true) VendorAccount fetchVendorAccount(@PathVariable long id) {
		return service.fetchVendorAccount(id);

	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Vendor createItem(@RequestBody Vendor vendor) {
		return service.create(vendor);

	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Vendor updateItem(@RequestBody Vendor vendor) {
		return service.update(vendor);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteVendor(@PathVariable long id) {
		return service.delete(id);

	}
	
	
	
	
	

}
