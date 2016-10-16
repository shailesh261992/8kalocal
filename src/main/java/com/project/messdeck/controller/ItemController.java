package com.project.messdeck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.messdeck.entity.Item;
import com.project.messdeck.entity.ItemCategory;
import com.project.messdeck.service.ItemService;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

	@Autowired
	private ItemService service;

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Item createItem(@RequestBody Item item) {
		Item cteatedItem = service.create(item);
		return cteatedItem;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Item fetchItem(@PathVariable long id) {
		return service.readSummary(id);

	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Item updateItem(@RequestBody Item item) {
		return service.update(item);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteItem(@PathVariable long id) {
		return service.delete(id);

	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> fetchAll() {
		return service.fetchAll();

	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemCategory[] fetchAllCategoryList() {
		return ItemCategory.values();

	}

}
