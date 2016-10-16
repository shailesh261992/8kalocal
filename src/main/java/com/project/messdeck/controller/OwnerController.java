package com.project.messdeck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.messdeck.Views;
import com.project.messdeck.entity.Owner;
import com.project.messdeck.entity.Vendor;
import com.project.messdeck.service.OwnerService;

@RestController
@RequestMapping(value = "/owner")
public class OwnerController {

	@Autowired
	private OwnerService service;

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Owner createOwner(@RequestBody Owner owner) {
		return service.create(owner);

	}

	@JsonView(Views.Summary.class)
	@RequestMapping(value = "/{id}/summary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Owner fetchOwnerSummary(@PathVariable long id) {
		return service.readSummary(id);

	}

	@JsonView(Views.Details.class)
	@RequestMapping(value = "/{id}/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Owner fetchOwnerDetails(@PathVariable long id) {
		return service.readDetails(id);

	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Owner updateOwner(@RequestBody Owner owner) {
		return service.update(owner);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteOwner(@PathVariable long id) {

		return service.delete(id);

	}

	@JsonView(Views.Summary.class)
	@RequestMapping(value = "/{id}/vendors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vendor> fetchAllVendors(@PathVariable long id) {

		return service.getAllVendors(id);

	}

}
