package com.rsg.framertohomeapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rsg.framertohomeapi.models.UserDetail;
import com.rsg.framertohomeapi.repositories.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
public class UserDetailController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	List<UserDetail> list()
	{
		System.out.println("wrong request");
		return userRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	UserDetail getUser(@PathVariable("id") String id)
	{
		System.out.println("inside get by email" +id);
		return userRepository.findByEmail(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDetail create(@RequestBody final UserDetail userDetail)
	{
		return userRepository.saveAndFlush(userDetail);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "{id}", method = RequestMethod.PUT)
	public UserDetail update(@RequestBody final UserDetail userDetail)
	{
		return userRepository.saveAndFlush(userDetail);
	}
}
