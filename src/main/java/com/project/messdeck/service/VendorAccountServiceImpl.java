package com.project.messdeck.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.messdeck.entity.Meal;
import com.project.messdeck.entity.MessDeckOffering;
import com.project.messdeck.entity.VendorAccount;
import com.project.messdeck.entity.VendorItem;
import com.project.messdeck.exceptions.InvalidOpreationException;
import com.project.messdeck.repository.VendorAccountRepository;

@Service
@Transactional
public class VendorAccountServiceImpl implements VendorAccountService {

	@Autowired
	private VendorAccountRepository repository;

	@Override
	public Set<Meal> fetchAllMeals(Long vendorAccountNumber) {
		Optional<VendorAccount> vendorAccount = Optional.of(repository.findOne(vendorAccountNumber));
		if (vendorAccount.isPresent()) {
			return vendorAccount.get().getSetOfMeals();
		} else {
			throw new InvalidOpreationException(
					"Vendor Account with id " + vendorAccountNumber + " Not exists. Fetch VendorAccount Failed");
		}
	}

	@Override
	public Set<VendorItem> fetchAllVendorItems(Long vendorAccountNumber) {
		Optional<VendorAccount> vendorAccount = Optional.of(repository.findOne(vendorAccountNumber));
		if (vendorAccount.isPresent()) {
			return vendorAccount.get().getVendorItems();
		} else {
			throw new InvalidOpreationException(
					"Vendor Account with id " + vendorAccountNumber + " Not exists. Fetch VendorAccount Failed");
		}
	}

	@Override
	public List<MessDeckOffering> fethAllMessDeckOffering(Long vendorAccountNumber) {
		Optional<VendorAccount> vendorAccount = Optional.of(repository.findOne(vendorAccountNumber));
		if (vendorAccount.isPresent()) {
			return vendorAccount.get().getMessDeckOfferings();
		} else {
			throw new InvalidOpreationException(
					"Vendor Account with id " + vendorAccountNumber + " Not exists. Fetch VendorAccount Failed");
		}
	}

}
