package com.rsg.framertohomeapi.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsg.framertohomeapi.models.FarmerProduct;

public interface FarmerProductRepository extends JpaRepository<FarmerProduct, Long>{

	List<FarmerProduct> getByUserId(long id);

}
