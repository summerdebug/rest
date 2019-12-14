package payroll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
