package com.dogukanavci.phase1.examplephase1.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dogukanavci.phase1.examplephase1.Model.Designation;
import com.dogukanavci.phase1.examplephase1.Model.Employee;
import com.dogukanavci.phase1.examplephase1.Repository.EmployeeRepository;
import com.dogukanavci.phase1.examplephase1.Specification.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;

    @GetMapping("/saveemps")
    public String process(){
        Employee e = new Employee("John",600,7,2,Designation.ARCHITECT);
        Employee e2 = new Employee("Jack",1600,4,3,Designation.ASSOCIATE);
        Employee e3 = new Employee("Bill",6000,6,3,Designation.MANAGER);
        List<Employee> l= new ArrayList<>();
        l.add(e);
        l.add(e2);
        l.add(e3);
        for (Employee entity : l) {
            repository.save(entity);
        }

        return "Done";
    }
    @GetMapping("/updateemployee")
    public String updateEmployee(@RequestParam("id") String id,@RequestParam("newname") String newname,@RequestParam("newdepartment_id") Long newdepartment_id,
                                 @RequestParam("newsalary") Long newsalary,@RequestParam("designation") Designation designation){
        Employee e = repository.findById(Long.parseLong(id)).get();
        e.setName(newname);
        e.setDepartmentId(newdepartment_id);
        e.setSalary(newsalary);
        e.setDesignation(designation);
        repository.save(e);
        return e.getName()+"'s information is updated";
    }

    @GetMapping("/newemployee")
    public String addEmployee(@RequestParam("name") String name,@RequestParam("department_id") Long department_id,
                                 @RequestParam("salary") Long salary,@RequestParam("manager_id") Long manager_id,@RequestParam("designation") Designation designation){
        Employee e = new Employee(name,salary,department_id,manager_id,designation);
        repository.save(e);
        return e.getName()+" added";
    }

    @GetMapping("/findallemp")
    public String findAll(){

        String result = "";

        for(Employee em : repository.findAll()){
            result += em + "</br>";
        }

        return result;
    }


    @GetMapping("/findempbyname")
    public String fetchDataByName(@RequestParam("name") String name){
        String result = "";

        for(Employee em: repository.findByName(name)){
            result += em + "</br>";
        }

        return result;
    }

    @GetMapping("/findempbyid")
    public String fetchDataById(@RequestParam("id") String id){
        Employee e = repository.findById(Long.parseLong(id)).get();
        return e.toString();
    }

    @GetMapping("/cleanemps")
    public String cleanEmployees(){
        repository.deleteAll();
        return "Employees cleaned";
    }

    @GetMapping("/findempbydepid")
    public String fetchDataByDepartmentId(@RequestParam("department_id") String department_id){
        String result = "";

        for(Employee em : repository.findByDepartmentId(Long.parseLong(department_id))){
            result += em + "</br>";
        }

        return result;
    }

    //SPECIFICATIONS

    @GetMapping("/getempbyid")
    public String fetchDataByIdSpec(@RequestParam("id") String id){
        String result = "";

        for(Employee em : repository.findAll(EmployeeSpecification.getEmployeesById(Long.parseLong(id)))){
            result += em + "</br>";
        }
        return result;
    }

    @GetMapping("/getempwheresalarygreater")
    public String fetchDataSalaryGreater(@RequestParam("salary") String salary){
        String result = "";

        for(Employee em : repository.findAll(EmployeeSpecification.salaryGreaterThan(Long.parseLong(salary)))){
            result += em + "</br>";
        }
        return result;
    }

    @GetMapping("/getempwheresalarygreaterthanandbydepartmentid")
    public String fetchDataSalaryGreaterAndByDepartmentId(@RequestParam("salary") String salary,@RequestParam("departmentId") String departmentId){
        String result = "";

        for(Employee em : repository.findAll(EmployeeSpecification.salaryGreaterThan( Long.parseLong(salary)).and
                                            (EmployeeSpecification.getEmployeesByDepartmentId( Long.parseLong(departmentId ))))
           ){
            result += em + "</br>";
        }
        return result;
    }

    @GetMapping("/getempbydesignation")
    public String fetchDataByDesignation(@RequestParam("designation") String designation){
        String result = "";

        for(Employee em : repository.findAll(EmployeeSpecification.getEmployeesByDesignation(Designation.valueOf(designation)))){
            result += em + "</br>";
        }
        return result;
    }
}
