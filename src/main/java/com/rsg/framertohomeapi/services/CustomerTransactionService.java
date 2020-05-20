package com.rsg.framertohomeapi.services;

import java.util.List;

import com.rsg.framertohomeapi.models.CustomerTransaction;

public interface CustomerTransactionService {

	List<CustomerTransaction> findAll();

	CustomerTransaction saveAndFlush(CustomerTransaction customerTransaction);

	List<CustomerTransaction> findByUserId(long id);

}
