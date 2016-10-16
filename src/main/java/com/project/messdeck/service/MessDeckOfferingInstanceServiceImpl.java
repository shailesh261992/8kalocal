package com.project.messdeck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.messdeck.aspects.ValidateWithOval;
import com.project.messdeck.entity.MessDeckOfferingInstance;
import com.project.messdeck.repository.MessDeckOfferingInstanceRepository;

@Service
public class MessDeckOfferingInstanceServiceImpl implements MessDeckOfferingInstanceService {

	@Autowired
	private MessDeckOfferingInstanceRepository repository;

	@ValidateWithOval
	@Override
	public MessDeckOfferingInstance create(MessDeckOfferingInstance obj) {
		obj.setId(0);
		MessDeckOfferingInstance messDeckOfferingInstance = repository.save(obj);
		messDeckOfferingInstance.getMeal().getName();
		return messDeckOfferingInstance;
	}

	@Override
	public MessDeckOfferingInstance readSummary(Long id) {
		return repository.findOne(id);
	}

	@ValidateWithOval
	@Override
	public MessDeckOfferingInstance update(MessDeckOfferingInstance obj) {
		return repository.save(obj);
	}

	@Override
	public boolean delete(Long id) {
		repository.delete(id);
		return true;
	}

}
