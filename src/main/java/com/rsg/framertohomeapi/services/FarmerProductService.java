package com.rsg.framertohomeapi.services;

import java.util.List;

import com.rsg.framertohomeapi.models.FarmerProduct;

public interface FarmerProductService {

	List<FarmerProduct> findAll();

	FarmerProduct saveAndFlush(FarmerProduct farmerProduct);

	List<FarmerProduct> findByUserId(long id);

}
