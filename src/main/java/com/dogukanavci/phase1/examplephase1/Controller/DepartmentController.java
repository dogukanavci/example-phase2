package com.dogukanavci.phase1.examplephase1.Controller;

import com.dogukanavci.phase1.examplephase1.Entity.Department;
import com.dogukanavci.phase1.examplephase1.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {

    @Autowired
    DepartmentRepository repository;

    @GetMapping("/cleandeps")
    public void cleanAllDepartments(){
        repository.deleteAll();
    }
    @GetMapping("/departments")
    public List<Department> findAll() {
        return (List<Department>) repository.findAll();
    }

    @PostMapping("/departments")
    void addDepartment(@RequestBody Department department) {
        repository.save(department);
    }
}
