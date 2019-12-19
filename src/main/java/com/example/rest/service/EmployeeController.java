package com.example.rest.service;

import com.example.rest.dao.EmployeeRepository;
import com.example.rest.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    /**
     * To test it simply open http://localhost:8080/employees in browser
     */
    @GetMapping("/employees")
    List<Employee> all() {
        return repository.findAll();
    }

    /**
     * To test it open in browser http://localhost:8080/employees/2
     */
    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) throws EmployeeNotFoundException {
        return repository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException(id));
    }

    /**
     * To test it in Soap UI send request:
     * Method: POST
     * Endpoint: http://localhost:8080/employees
     * Header: Content-type, Value: application/json
     * Body: {"name" : "Bill", "role" : "teacher"}
     * It will add new employee to the database.
     */
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }
}
