package com.project.messdeck.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.messdeck.aspects.ValidateWithOval;
import com.project.messdeck.entity.Owner;
import com.project.messdeck.entity.Vendor;
import com.project.messdeck.entity.VendorAccount;
import com.project.messdeck.exceptions.InvalidOpreationException;
import com.project.messdeck.repository.OwnerRepository;
import com.project.messdeck.repository.VendorRepository;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorRepository repository;

	@Autowired
	OwnerRepository ownerRepository;

	@ValidateWithOval
	@Override
	public Vendor create(Vendor obj) {
		obj.setId(0);
		Optional<Owner> owner = Optional.ofNullable(ownerRepository.findOne(obj.getOwner().getId()));
		if (owner.isPresent()) {
			obj.setOwner(owner.get());
			return repository.save(obj);
		} else {
			throw new InvalidOpreationException(
					"Owner with id " + obj.getOwner().getId() + " Not exists. Update Failed");
		}

	}

	@Override
	public Vendor readSummary(Long id) {
		return repository.findOne(id);
	}

	@ValidateWithOval
	@Override
	public Vendor update(Vendor obj) {
		Vendor updatedItem;
		Optional<Vendor> vendor = Optional.ofNullable(this.readSummary(obj.getId()));
		if (vendor.isPresent()) {
			obj.setVendorAccount(vendor.get().getVendorAccount());
			obj.setOwner(ownerRepository.findOne(obj.getOwner().getId()));
			updatedItem = repository.save(obj);
		} else {
			throw new InvalidOpreationException("Vendor with id " + obj.getId() + " Not exists. Update Failed");
		}
		return updatedItem;
	}

	@Override
	public boolean delete(Long id) {
		repository.delete(id);
		return true;
	}

	@Override
	public VendorAccount fetchVendorAccount(Long vendorId) {
		Optional<Vendor> vendor = Optional.ofNullable(repository.findOne(vendorId));
		if (vendor.isPresent()) {

			VendorAccount vendorAccount = vendor.get().getVendorAccount();
			vendorAccount.getManagerMobNo();
			return vendorAccount;
		} else {
			throw new InvalidOpreationException(
					"Vendor with id " + vendorId + " Not exists. Fetch VendorAccount Failed");
		}
	}

	@Override
	public Vendor readDetails(Long id) {
		Vendor vendor = repository.findOne(id);
		vendor.getOwner().getMobileNo();
		return vendor;

	}

}
