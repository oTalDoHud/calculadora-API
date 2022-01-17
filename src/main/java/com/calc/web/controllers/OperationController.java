package com.calc.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.calc.web.model.entities.Operation;
import com.calc.web.services.OperationService;

@RestController
public class OperationController {
	
	@Autowired
	private OperationService service;
	
	@GetMapping(path = "/op/{id}")
	public Operation findById(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@GetMapping(path = "/ops")
	public Iterable<Operation> findAll() {
		return service.findAll();
	}
	
	@GetMapping(path = "/ops/pag/{pag}/size/{size}")
	public Iterable<Operation> findAll(@PathVariable int pag,
			@PathVariable int size) {
		return service.findAll(pag, size);
	}
}
