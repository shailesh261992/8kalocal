package com.project.messdeck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.messdeck.aspects.ValidateWithOval;
import com.project.messdeck.entity.CustomerPayement;
import com.project.messdeck.repository.CustomerPayementRepository;

@Service
public class CustomerPayementServiceImpl implements CustomerPayementService {
	@Autowired
	private CustomerPayementRepository repository;

	@ValidateWithOval
	@Override
	public CustomerPayement create(CustomerPayement obj) {
		obj.setId(0);
		return repository.save(obj);
	}

	@Override
	public CustomerPayement readSummary(Long id) {
		return repository.findOne(id);
	}

	@ValidateWithOval
	@Override
	public CustomerPayement update(CustomerPayement obj) {
		return repository.save(obj);
	}

	@Override
	public boolean delete(Long id) {
		repository.delete(id);
		return true;
	}

}
