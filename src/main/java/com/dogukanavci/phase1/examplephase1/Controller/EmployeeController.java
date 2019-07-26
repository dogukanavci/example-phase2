package com.dogukanavci.phase1.examplephase1.Controller;

import com.dogukanavci.phase1.examplephase1.Entity.Employee;
import com.dogukanavci.phase1.examplephase1.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;

    @GetMapping("/cleanemps")
    public void cleanAllEmployees(){
        repository.deleteAll();
    }
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return (List<Employee>) repository.findAll();
    }

    @PostMapping("/employees")
    void addEmployee(@RequestBody Employee employee) {
        repository.save(employee);
    }
}
