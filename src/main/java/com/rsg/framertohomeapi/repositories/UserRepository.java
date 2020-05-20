package com.rsg.framertohomeapi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsg.framertohomeapi.models.UserDetail;

@Repository
public interface UserRepository  extends JpaRepository<UserDetail, Long> {

	
	UserDetail findByEmail(String username);

}
