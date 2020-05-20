package com.rsg.framertohomeapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsg.framertohomeapi.models.CustomerTransaction;


public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, Long>{

	List<CustomerTransaction> getByUserId(long id);

}
