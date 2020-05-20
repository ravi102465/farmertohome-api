package com.rsg.framertohomeapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rsg.framertohomeapi.models.CustomerTransaction;
import com.rsg.framertohomeapi.services.CustomerTransactionService;

@RestController
@RequestMapping("/api/v1/transaction")
public class CustomerTransactionController {

	@Autowired
	private CustomerTransactionService  customerTransactionService;
	
	@GetMapping
	List<CustomerTransaction> list()
	{
		return customerTransactionService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerTransaction create(@RequestBody final CustomerTransaction customerTransaction)
	{
		return customerTransactionService.saveAndFlush(customerTransaction);
	}
	
	@GetMapping
	@RequestMapping("{id}")
	List<CustomerTransaction> getPurchaseDetailByUserUd(@PathVariable("id") long id)
	{
		System.out.println("inside get by email" +id);
		return customerTransactionService.findByUserId(id);
	}
}
