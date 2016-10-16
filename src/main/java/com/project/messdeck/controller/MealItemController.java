package com.project.messdeck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.messdeck.entity.MealItem;
import com.project.messdeck.service.MealItemService;

@RestController
@RequestMapping(value = "/mealItem")
public class MealItemController {

	@Autowired
	private MealItemService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public MealItem fetchMealItem(@PathVariable long id) {
		return service.readSummary(id);

	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MealItem createMealItem(@RequestBody MealItem mealItem) {
		MealItem cteatedItem = service.create(mealItem);
		return cteatedItem;

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteItem(@PathVariable long id) {
		return service.delete(id);

	}

}
