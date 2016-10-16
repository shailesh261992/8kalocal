package com.project.messdeck.service;

import java.util.List;

import com.project.messdeck.entity.Item;

public interface ItemService extends CRUDService<Item> {
	public List<Item> fetchAll();
}
