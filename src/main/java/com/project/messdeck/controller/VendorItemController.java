package com.project.messdeck.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.messdeck.Views;
import com.project.messdeck.entity.Unit;
import com.project.messdeck.entity.VendorItem;
import com.project.messdeck.service.VendorItemService;

@RestController
@RequestMapping(value = "/vitem")
public class VendorItemController {
	@Autowired
	private VendorItemService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public VendorItem fetchItem(@PathVariable long id) {
		return service.readSummary(id);

	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public VendorItem createVendorItem(@RequestBody VendorItem vitem) {
		VendorItem cteatedItem = service.create(vitem);
		return cteatedItem;

	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public VendorItem updateVendorItem(@RequestBody VendorItem vitem) {
		return service.update(vitem);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteItem(@PathVariable long id) {
		return service.delete(id);

	}

	@JsonView(Views.Summary.class)
	@RequestMapping(value = "/all/{vendorAccountId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<VendorItem> fetchAll(@PathVariable long vendorAccountId) {
		return service.fetchAll(vendorAccountId);

	}

	@JsonView(Views.Summary.class)
	@RequestMapping(value = "/units", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Unit[] fetchAllUnits() {
		return Unit.values();

	}

}
