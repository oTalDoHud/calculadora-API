package com.calc.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calc.web.model.Operation;

public interface OperationRepository extends JpaRepository<Operation, Integer>{

}
