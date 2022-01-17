package com.calc.web.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.calc.web.model.entities.User;
import com.calc.web.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User findById (Integer id) {
		Optional<User> user = userRepo.findById(id);
		return user.get();
	}
	
	public Iterable<User> findAll(){
		Pageable page = PageRequest.of(0, 100);
		return userRepo.findAll(page);
	}
}
