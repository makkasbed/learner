package com.agency.learner.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.agency.learner.model.*;

//@RepositoryRestResource(path = "/employees")
@RestResource(exported = false)
public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
