package com.project.messdeck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.messdeck.aspects.ValidateWithOval;
import com.project.messdeck.entity.MessDeckOffering;
import com.project.messdeck.entity.MessDeckOfferingInstance;
import com.project.messdeck.entity.VendorAccount;
import com.project.messdeck.exceptions.InvalidOpreationException;
import com.project.messdeck.repository.MessDeckOfferingRepository;
import com.project.messdeck.repository.VendorAccountRepository;

@Service
public class MessDeckOfferingServiceImpl implements MessDeckOfferingService {

	@Autowired
	private MessDeckOfferingRepository repository;

	@Autowired
	VendorAccountRepository vendorAccountRepository;

	@ValidateWithOval
	@Override
	public MessDeckOffering create(MessDeckOffering obj) {
		obj.setId(0);
		Optional<VendorAccount> vendorAccount = Optional
				.of(vendorAccountRepository.findOne(obj.getVendorAccount().getId()));

		if (vendorAccount.isPresent()) {
			return repository.save(obj);
		} else {
			throw new InvalidOpreationException(
					"Vendor Account with id " + obj.getVendorAccount().getId() + " Not exists. Operation Failed");
		}

	}

	@Override
	public MessDeckOffering readSummary(Long id) {
		return repository.findOne(id);
	}

	@ValidateWithOval
	@Override
	public MessDeckOffering update(MessDeckOffering obj) {
		Optional<VendorAccount> vendorAccount = Optional
				.of(vendorAccountRepository.findOne(obj.getVendorAccount().getId()));

		if (vendorAccount.isPresent()) {
			return repository.save(obj);
		} else {
			throw new InvalidOpreationException(
					"Vendor Account with id " + obj.getVendorAccount().getId() + " Not exists. Operation Failed");
		}

	}

	@Override
	public boolean delete(Long id) {
		repository.delete(id);
		return true;
	}


	@Override
	public List<MessDeckOfferingInstance> getInstances(Long id) {
		return repository.getOne(id).getMessDeckServiceInstances();
	}
}
