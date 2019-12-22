package com.example.rest.dao;

import com.example.rest.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDao {

    @PersistenceContext
    private EntityManager em;

    public Optional<Employee> findById(Long id) {
        Employee employee = em.find(Employee.class, id);
        return Optional.ofNullable(employee);
    }

    public Optional<Employee> findByIdWithQuery(Long id) {
        TypedQuery<Employee> query = em.createQuery(
                "SELECT e FROM Employee e WHERE id = ?1",
                Employee.class);
        List<Employee> employee = query.setParameter(1, id).getResultList();
        if (employee.size() == 0) {
            return Optional.empty();
        }
        return Optional.of(employee.get(0));
    }
}
