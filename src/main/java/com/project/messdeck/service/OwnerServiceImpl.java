package com.project.messdeck.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.messdeck.aspects.ValidateWithOval;
import com.project.messdeck.entity.Owner;
import com.project.messdeck.entity.Vendor;
import com.project.messdeck.exceptions.InvalidOpreationException;
import com.project.messdeck.repository.OwnerRepository;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {
	@Autowired
	private OwnerRepository repository;

	@Override
	@ValidateWithOval
	public Owner create(Owner obj) {
		obj.setId(0);
		return repository.save(obj);
	}

	@Override
	public Owner readSummary(Long id) {
		Optional<Owner> owner = Optional.ofNullable(repository.findOne(id));
		if (owner.isPresent()) {
			return owner.get();
		} else {
			throw new InvalidOpreationException("Owner with id " + id + " Not exists. Fetch Failed");
		}
	}

	@Override
	@ValidateWithOval
	public Owner update(Owner obj) {
		Owner updatedItem;
		Optional<Owner> item = Optional.ofNullable(this.readSummary(obj.getId()));
		if (item.isPresent()) {
			updatedItem = repository.save(obj);
		} else {
			throw new InvalidOpreationException("Owner with id " + obj.getId() + " Not exists. Update Failed");
		}
		return updatedItem;
	}

	@Override
	public boolean delete(Long id) {
		System.out.println("@@@@ list of vendors " + this.readSummary(id).getVendorsList());
		repository.delete(id);
		return true;
	}

	public List<Vendor> getAllVendors(Long id) {
		return this.readSummary(id).getVendorsList();
	}

	@Override
	public Owner readDetails(Long id) {
		Optional<Owner> owner = Optional.ofNullable(repository.findOne(id));
		if (owner.isPresent()) {
			owner.get().getOwnerAddress().getAddressLine1();
			return owner.get();
		} else {
			throw new InvalidOpreationException("Owner with id " + id + " Not exists. Fetch Failed");
		}
	}

}
