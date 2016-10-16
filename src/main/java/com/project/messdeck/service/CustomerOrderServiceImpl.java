package com.project.messdeck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.messdeck.aspects.ValidateWithOval;
import com.project.messdeck.entity.CustomerOrder;
import com.project.messdeck.repository.CustomerOrderRepository;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CustomerOrderRepository repository;

	@ValidateWithOval
	@Override
	public CustomerOrder create(CustomerOrder obj) {
		obj.setId(0);
		return repository.save(obj);
	}

	@Override
	public CustomerOrder readSummary(Long id) {
		return repository.findOne(id);
	}

	@ValidateWithOval
	@Override
	public CustomerOrder update(CustomerOrder obj) {
		return repository.save(obj);
	}

	@Override
	public boolean delete(Long id) {
		repository.delete(id);
		return true;
	}

}
