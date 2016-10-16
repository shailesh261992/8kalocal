package com.project.messdeck.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.messdeck.aspects.ValidateWithOval;
import com.project.messdeck.entity.Item;
import com.project.messdeck.entity.VendorAccount;
import com.project.messdeck.entity.VendorItem;
import com.project.messdeck.exceptions.InvalidOpreationException;
import com.project.messdeck.repository.ItemRepository;
import com.project.messdeck.repository.VendorAccountRepository;
import com.project.messdeck.repository.VendorItemRepository;

@Service
public class VendorItemServiceImpl implements VendorItemService {
	@Autowired
	private VendorItemRepository repository;

	@Autowired
	private VendorAccountRepository vendorAccountRepository;

	@Autowired
	ItemRepository itemRepository;

	@ValidateWithOval
	@Override
	public VendorItem create(VendorItem obj) {
		obj.setId(0);
		Optional<VendorAccount> vendorAccount = Optional
				.of(vendorAccountRepository.getOne(obj.getVendorAccount().getId()));
		if (vendorAccount.isPresent()) {

			Optional<Item> item = Optional.of(itemRepository.findOne(obj.getItem().getId()));
			if (item.isPresent()) {
				obj.setVendorAccount(vendorAccount.get());
				obj.setItem(item.get());
				return repository.save(obj);

			} else {
				new InvalidOpreationException("Item with id " + item.get().getId() + " Not exists. Operation Failed");
			}

		} else {
			new InvalidOpreationException(
					"Vendor Account with id " + obj.getVendorAccount().getId() + " Not exists. Operation Failed");
		}

		return null;

	}

	@Override
	public VendorItem readSummary(Long id) {
		return repository.findOne(id);
	}

	@ValidateWithOval
	@Override
	public VendorItem update(VendorItem obj) {
		Optional<VendorItem> vendorItem = Optional.of(repository.findOne(obj.getId()));

		if (vendorItem.isPresent()) {
			obj.setItem(vendorItem.get().getItem());
			obj.setVendorAccount(vendorItem.get().getVendorAccount());
			return repository.save(obj);
		} else {
			new InvalidOpreationException("VendorItem with id " + obj.getId() + " Not exists. Operation Failed");
		}

		return null;
	}

	@Override
	public boolean delete(Long id) {
		repository.delete(id);
		return true;
	}

	@Override
	public Set<VendorItem> fetchAll(Long vendorAccountId) {
		return vendorAccountRepository.getOne(vendorAccountId).getVendorItems();

	}

}
