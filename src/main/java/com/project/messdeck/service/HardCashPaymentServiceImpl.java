package com.project.messdeck.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.messdeck.aspects.ValidateWithOval;
import com.project.messdeck.entity.CustomerPayement;
import com.project.messdeck.entity.HardCashPayment;
import com.project.messdeck.repository.HardCashPayementRepository;

@Service
@Transactional
public class HardCashPaymentServiceImpl implements HardCashPaymentService {
	@Autowired
	private HardCashPayementRepository repository;

	@Autowired
	private CustomerPayementService customerPayementService;

	@ValidateWithOval
	@Override
	public HardCashPayment create(HardCashPayment obj) {
		obj.setId(0);
		HardCashPayment hardCashPayment = repository.save(obj);

		CustomerPayement customerPayement = new CustomerPayement();
		customerPayement.setAmount(obj.getAmount());
		customerPayement.setCustomerAccount(obj.getCustomerAccount());
		customerPayement.setTimestamp(LocalDateTime.now());
		customerPayement.setPayment(hardCashPayment);
		customerPayementService.create(customerPayement);

		return hardCashPayment;
	}

	@Override
	public HardCashPayment readSummary(Long id) {
		return repository.findOne(id);
	}

	@ValidateWithOval
	@Override
	public HardCashPayment update(HardCashPayment obj) {

		return null;
	}

	@Override
	public boolean delete(Long id) {
		repository.delete(id);
		return true;
	}

}
