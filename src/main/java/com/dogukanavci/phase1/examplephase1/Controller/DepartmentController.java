package com.dogukanavci.phase1.examplephase1.Controller;

import com.dogukanavci.phase1.examplephase1.Model.Department;
import com.dogukanavci.phase1.examplephase1.Model.Employee;
import com.dogukanavci.phase1.examplephase1.Repository.DepartmentRepository;
import com.dogukanavci.phase1.examplephase1.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentRepository repository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/savedeps")
    public String process(){
        List<Department> l= new ArrayList<>();
        Department d1 = new Department("IT");l.add(d1);
        Department d2 = new Department("HR");l.add(d2);
        Department d3 = new Department("QUALITYASSURANCE");l.add(d3);
        Department d4 = new Department("LAW");l.add(d4);
        Department d5 = new Department("POST");l.add(d5);
        Department d6 = new Department("SECURITY");l.add(d6);
        for (Department entity : l) {
            repository.save(entity);
        }
        return "Done";
    }

    @GetMapping("/newdep")
    public String addDepartment(@RequestParam("name") String name){
        Department d = new Department(name);
        repository.save(d);
        return d.getName()+" added";
    }
    @GetMapping("/cleandeps")
    public String cleanDepartments(){
        repository.deleteAll();
        return "Departments cleaned";
    }

    @GetMapping("/mapdeptoemp")
    public String listDepartmentsWithEmployees(){
        String result = "";
        for(Department dep : repository.findAll()){
            result += "<br>"+ dep.getId() + " , " + dep.getName() + "</br>";
            for(Employee emp : employeeRepository.findByDepartmentId(dep.getId())){
                result += emp + "</br>";
            }
        }
        return result;
    }

    @GetMapping("/updatedep")
    public String updateDepartment(@RequestParam("id") String id,@RequestParam("newname") String newname){
        Department d = repository.findById(Long.parseLong(id)).get();
        d.setName(newname);
        repository.save(d);
        return d.getName()+"'s information is updated";
    }

    @GetMapping("/findalldep")
    public String findAll(){

        String result = "";

        for(Department dep : repository.findAll()){
            result += dep + "</br>";
        }

        return result;
    }
    @GetMapping("/finddepbyname")
    public String fetchDataByName(@RequestParam("name") String name){
        String result = "";

        for(Department dep: repository.findByName(name)){
            result += dep + "</br>";
        }

        return result;
    }
    @GetMapping("/finddepbyid")
    public String fetchDataById(@RequestParam("id") String id){
        Department d = repository.findById(Long.parseLong(id)).get();
        return d.toString();
    }
}
