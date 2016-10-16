package com.project.messdeck.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.messdeck.aspects.ValidateWithOval;
import com.project.messdeck.entity.Item;
import com.project.messdeck.exceptions.InvalidOpreationException;
import com.project.messdeck.repository.ItemRepository;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repository;

	@ValidateWithOval
	@Override
	public Item create(Item obj) {
		obj.setId(0);
		return repository.save(obj);

	}

	@Override
	public Item readSummary(Long id) {
		return repository.findOne(id);
	}

	@ValidateWithOval
	@Override
	public Item update(Item obj) {
		Item updatedItem;
		Optional<Item> item = Optional.ofNullable(this.readSummary(obj.getId()));
		if (item.isPresent()) {
			updatedItem = repository.save(obj);
		} else {
			throw new InvalidOpreationException("Item with id " + obj.getId() + " Not exists. Update Failed");
		}
		return updatedItem;

	}

	@Override
	public boolean delete(Long id) {
		repository.delete(id);
		return true;
	}

	@Override
	public List<Item> fetchAll() {
		return repository.findAll();
	}

}
