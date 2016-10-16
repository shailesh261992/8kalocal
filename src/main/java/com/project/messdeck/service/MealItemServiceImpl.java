package com.project.messdeck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.messdeck.aspects.ValidateWithOval;
import com.project.messdeck.entity.MealItem;
import com.project.messdeck.entity.VendorItem;
import com.project.messdeck.exceptions.InvalidOpreationException;
import com.project.messdeck.repository.MealItemRepository;
import com.project.messdeck.repository.VendorItemRepository;

@Service
public class MealItemServiceImpl implements MealItemService {

	@Autowired
	MealItemRepository repository;

	@Autowired
	VendorItemRepository vendorItemRepository;

	@ValidateWithOval
	@Override
	public MealItem create(MealItem obj) {
		obj.setId(0);
		Optional<VendorItem> vendorItem = Optional.of(vendorItemRepository.findOne(obj.getVendorItem().getId()));
		if (vendorItem.isPresent()) {
			obj.setVendorItem(vendorItem.get());
			return repository.save(obj);
		} else {
			new InvalidOpreationException(
					"Vendor Item with id " + obj.getVendorItem().getId() + " Not exists. Operation Failed");
		}

		return null;
	}

	@Override
	public MealItem readSummary(Long id) {
		return repository.findOne(id);
	}

	@ValidateWithOval
	@Override
	public MealItem update(MealItem obj) {
		throw new InvalidOpreationException("Unsopported Application");
	}

	@Override
	public boolean delete(Long id) {
		repository.delete(id);
		return true;
	}

	@Override
	public List<MealItem> fethAllMealItems(Long id) {

		return null;
	}

}
