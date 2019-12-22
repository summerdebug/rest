package com.example.rest.dao;

import com.example.rest.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class EmployeeDaoTest {

    @Autowired
    private EmployeeDao dao;

    @Test
    void whenFindByIdThenSuccessful() throws Exception {
        Optional<Employee> employee = dao.findById(1L);

        assertTrue(employee.isPresent());
    }

    @Test
    void whenFindByIdThenNotFound() throws Exception {
        Optional<Employee> employee = dao.findById(100L);

        assertFalse(employee.isPresent());
    }

    @Test
    void whenFindByIdWithQueryThenSuccessful() throws Exception {
        Optional<Employee> employee = dao.findByIdWithQuery(1L);

        assertTrue(employee.isPresent());
    }

    @Test
    void whenFindByIdWithQueryThenNotFound() throws Exception {
        Optional<Employee> employee = dao.findByIdWithQuery(100L);

        assertFalse(employee.isPresent());
    }
}