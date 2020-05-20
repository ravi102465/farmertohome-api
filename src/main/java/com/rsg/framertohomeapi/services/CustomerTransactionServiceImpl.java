package com.rsg.framertohomeapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsg.framertohomeapi.models.CustomerTransaction;
import com.rsg.framertohomeapi.repositories.CustomerTransactionRepository;

@Service
public class CustomerTransactionServiceImpl implements CustomerTransactionService {

	@Autowired
	private CustomerTransactionRepository customerTransactionRepository;
	@Override
	public List<CustomerTransaction> findAll() {
		return customerTransactionRepository.findAll();
	}

	@Override
	public CustomerTransaction saveAndFlush(CustomerTransaction customerTransaction) {

		return customerTransactionRepository.saveAndFlush(customerTransaction);
	}

	@Override
	public List<CustomerTransaction> findByUserId(long id) {
		
		return customerTransactionRepository.getByUserId(id);

	}

}
