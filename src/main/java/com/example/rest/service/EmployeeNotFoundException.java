package com.example.rest.service;

public class EmployeeNotFoundException extends Exception {

    EmployeeNotFoundException(Long id) {
        super("Employee not found: " + id);
    }
}
