package com.calc.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.calc.web.model.entities.User;
import com.calc.web.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(path = "/user/{id}")
	public User findById(@PathVariable Integer id) {
		return service.findById(id);
	}
}
