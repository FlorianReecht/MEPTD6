package fr.polytech.covid.repository;

import fr.polytech.covid.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Optional<Employee> findByUsername(final String username);
}
