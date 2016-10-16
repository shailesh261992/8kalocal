package com.project.messdeck.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.messdeck.aspects.ValidateWithOval;
import com.project.messdeck.entity.Meal;
import com.project.messdeck.entity.MealItem;
import com.project.messdeck.entity.VendorItem;
import com.project.messdeck.repository.MealItemRepository;
import com.project.messdeck.repository.MealRepository;

@Service
public class MealServiceImpl implements MealService {

	@Autowired
	MealRepository repository;

	@Autowired
	MealItemRepository mealItemRepository;

	@ValidateWithOval
	@Override
	public Meal create(Meal obj) {
		obj.setId(0);
		Set<MealItem> mealItems = obj.getMealItems();
		Set<MealItem> mealItemsCopy = new HashSet<>();
		MealItem mealItem;
		for (MealItem m : mealItems) {
			if (m.getId() == 0) {
				VendorItem vitem = new VendorItem();
				vitem.setId(m.getVendorItem().getId());

				mealItem = mealItemRepository.findByVendorItemAndCount(vitem, m.getCount());
				if (mealItem != null) {
					mealItemsCopy.add(mealItem);
				} else {
					mealItemsCopy.add(m);
				}

			} else {
				mealItemsCopy.add(mealItemRepository.findOne(m.getId()));
			}
		}
		obj.setMealItems(mealItemsCopy);
		return repository.save(obj);
	}

	@Override
	public Meal readSummary(Long id) {
		return repository.findOne(id);
	}

	@ValidateWithOval
	@Override
	public Meal update(Meal obj) {
		Set<MealItem> mealItems = obj.getMealItems();
		Set<MealItem> mealItemsCopy = new HashSet<>();
		MealItem mealItem;
		for (MealItem m : mealItems) {
			if (m.getId() == 0) {
				VendorItem vitem = new VendorItem();
				vitem.setId(m.getVendorItem().getId());

				mealItem = mealItemRepository.findByVendorItemAndCount(vitem, m.getCount());
				if (mealItem != null) {
					mealItemsCopy.add(mealItem);
				} else {
					mealItemsCopy.add(m);
				}

			} else {
				mealItemsCopy.add(mealItemRepository.findOne(m.getId()));
			}
		}
		obj.setMealItems(mealItemsCopy);
		return repository.save(obj);
	}

	@Override
	public boolean delete(Long id) {
		repository.delete(id);
		return true;
	}

}
