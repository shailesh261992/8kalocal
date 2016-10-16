package com.project.messdeck.service;

import java.util.List;

import com.project.messdeck.entity.MealItem;

public interface MealItemService extends CRUDService<MealItem> {

	public List<MealItem> fethAllMealItems(Long id);

}
