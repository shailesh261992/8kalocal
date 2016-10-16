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
import com.project.messdeck.entity.Meal;
import com.project.messdeck.service.MealService;

@RestController
@RequestMapping(value = "/meal")
public class MealController {

	@Autowired
	MealService service;

	@JsonView(Views.Summary.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Meal fetchMeal(@PathVariable long id) {
		return service.readSummary(id);

	}

	@JsonView(Views.Summary.class)
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Meal createMealItem(@RequestBody Meal meal) {
		return service.create(meal);

	}
}
