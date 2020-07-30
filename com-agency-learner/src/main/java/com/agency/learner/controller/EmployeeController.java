package com.agency.learner.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agency.learner.model.*;
import com.agency.learner.repository.EmployeeRepository;
import com.agency.learner.controller.*;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;

	    @GetMapping
	    public Iterable<Employee> findAll() {
	        return repository.findAll();
	    }

	    @GetMapping(path = "/{id}")
	    public Employee find(@PathVariable("id") String id) {
	        return repository.findOne(id);
	    }

	    @PostMapping(consumes = "application/json")
	    public Employee create(@RequestBody Employee emp) {
	        return repository.save(emp);
	    }

	    @DeleteMapping(path = "/{id}")
	    public void delete(@PathVariable("id") String id) {
	        repository.delete(id);
	    }

	    @PutMapping(path = "/{id}")
	    public Employee update(@PathVariable("id") String id, @RequestBody Employee emp) throws BadHttpRequest {
	        if (repository.exists(id)) {
	            emp.setId(id);
	            return repository.save(emp);
	        } else {
	            throw new BadHttpRequest();
	        }
	    }

}
