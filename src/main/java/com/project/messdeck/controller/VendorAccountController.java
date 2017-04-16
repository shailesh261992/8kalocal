package com.project.messdeck.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.messdeck.Views;
import com.project.messdeck.entity.Meal;
import com.project.messdeck.entity.MessDeckOffering;
import com.project.messdeck.entity.VendorItem;
import com.project.messdeck.service.VendorAccountService;

@RestController
@RequestMapping(value = "/vendoraccount")
@CrossOrigin
public class VendorAccountController {
	@Autowired
	private VendorAccountService service;

	@JsonView(Views.Summary.class)
	@RequestMapping(value = "/{vendorAccountNumber}/mealset", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<Meal> fetchAllMeals(@PathVariable long vendorAccountNumber) {
		return service.fetchAllMeals(vendorAccountNumber);

	}

	@JsonView(Views.Summary.class)
	@RequestMapping(value = "/{vendorAccountNumber}/vitems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<VendorItem> fetchAllVendorItems(@PathVariable long vendorAccountNumber) {
		return service.fetchAllVendorItems(vendorAccountNumber);

	}

	@CrossOrigin()
	@JsonView(Views.Summary.class)
	@RequestMapping(value = "/{vendorAccountNumber}/messdeckofferings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MessDeckOffering> fetchAllMessDeckOfferings(@PathVariable long vendorAccountNumber) {
		return service.fethAllMessDeckOffering(vendorAccountNumber);

	}

}
