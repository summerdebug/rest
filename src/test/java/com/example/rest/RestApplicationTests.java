package com.example.rest;

import com.example.rest.dao.EmployeeRepository;
import com.example.rest.service.EmployeeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RestApplicationTests {

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private EmployeeController controller;

	@Test
	void contextLoads() {
		assertNotNull(repository);
		assertNotNull(controller);
	}

}
