package com.project.messdeck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.messdeck.entity.MessDeckOffering;
import com.project.messdeck.entity.MessDeckOfferingInstance;
import com.project.messdeck.service.MessDeckOfferingService;

@RestController
@RequestMapping(value = "/messDeckOffering")
public class MessDeckOfferingController {

	@Autowired
	private MessDeckOfferingService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public MessDeckOffering fetchMessDeckOffering(@PathVariable long id) {
		return service.readSummary(id);

	}

	
	@RequestMapping(value = "/{id}/instances", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MessDeckOfferingInstance> fetchMessDeckOfferingINstances(@PathVariable long id) {
		return service.getInstances(id);

	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MessDeckOffering createItem(@RequestBody MessDeckOffering messDeckOffering) {
		return service.create(messDeckOffering);

	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MessDeckOffering updateItem(@RequestBody MessDeckOffering messDeckOffering) {
		return service.update(messDeckOffering);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteItem(@PathVariable long id) {
		return service.delete(id);

	}
	
	
	

}
