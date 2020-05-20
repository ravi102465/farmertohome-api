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

import com.rsg.framertohomeapi.models.FarmerProduct;
import com.rsg.framertohomeapi.services.FarmerProductService;


@RestController
@RequestMapping("/api/v1/products")
public class FarmerProductController {
	
	@Autowired
	private FarmerProductService  farmerProductService;
	
	@GetMapping
	List<FarmerProduct> list()
	{
		return farmerProductService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FarmerProduct create(@RequestBody final FarmerProduct farmerProduct)
	{
		return farmerProductService.saveAndFlush(farmerProduct);
	}
	
	@GetMapping
	@RequestMapping("{id}")
	List<FarmerProduct> getProductByUserId(@PathVariable("id") long id)
	{
		return farmerProductService.findByUserId(id);
	}
}
