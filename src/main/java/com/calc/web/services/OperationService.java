package com.calc.web.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.calc.web.model.entities.Operation;
import com.calc.web.repositories.OperationRepository;

@Service
public class OperationService {

	@Autowired
	private OperationRepository opRepo;
	
	public Operation findById (Integer id) {
		Optional<Operation> op = opRepo.findById(id);
		return op.get();
	}
	
	public Iterable<Operation> findAll(){
		Pageable page = PageRequest.of(0, 100);
		return opRepo.findAll(page);
	}
}
