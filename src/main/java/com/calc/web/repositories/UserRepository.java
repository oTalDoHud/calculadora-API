package com.calc.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calc.web.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
