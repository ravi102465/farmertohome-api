package com.rsg.framertohomeapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsg.framertohomeapi.models.FarmerProduct;
import com.rsg.framertohomeapi.repositories.FarmerProductRepository;

@Service
public class FarmerProductServiceImpl implements FarmerProductService {

	@Autowired
	FarmerProductRepository farmerProductRepository;

	@Override
	public List<FarmerProduct> findAll() {
		return farmerProductRepository.findAll();
	}

	@Override
	public FarmerProduct saveAndFlush(FarmerProduct farmerProduct) {
		return farmerProductRepository.saveAndFlush(farmerProduct);
	}

	@Override
	public List<FarmerProduct> findByUserId(long id) {
		return farmerProductRepository.getByUserId(id);
	}
	
}
