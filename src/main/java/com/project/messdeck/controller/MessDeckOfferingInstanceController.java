package com.project.messdeck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.messdeck.entity.MessDeckOfferingInstance;
import com.project.messdeck.service.MessDeckOfferingInstanceService;

@RestController
@RequestMapping(value = "/messDeckOfferingInstance")
public class MessDeckOfferingInstanceController {

	@Autowired
	private MessDeckOfferingInstanceService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public MessDeckOfferingInstance fetchMessDeckOfferingInstance(@PathVariable long id) {
		return service.readSummary(id);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteMessDeckOfferingInstance(@PathVariable long id) {
		return service.delete(id);

	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MessDeckOfferingInstance createMessDeckOfferingInstance(
			@RequestBody MessDeckOfferingInstance messDeckOfferingInstance) {
		MessDeckOfferingInstance cteatedItem = service.create(messDeckOfferingInstance);
		return cteatedItem;

	}

}
