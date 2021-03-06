package com.dogukanavci.phase1.examplephase1.Specification;

import com.dogukanavci.phase1.examplephase1.Entity.Designation;
import com.dogukanavci.phase1.examplephase1.Entity.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {
    public static Specification<Employee> getEmployeesById(Long id){
        return (root, query, cb) -> {
            return cb.equal(root.get("id"),id);
        };
    }
    public static Specification<Employee> getEmployeesByDesignation(Designation designation){
        return (root, query, cb) -> {
            return cb.equal(root.get("designation"),designation);
        };
    }
    public static Specification<Employee> salaryGreaterThan(Long salary){
        return (root, query, cb) -> {
            query.orderBy(cb.asc(root.get("name")));
            return cb.greaterThan(root.get("salary"),salary);
        };
    }

    public static Specification<Employee> getEmployeesByDepartmentId(Long departmentId){
        return (root, query, cb) -> {
            query.orderBy(cb.desc(root.get("salary")));
            return cb.equal(root.get("departmentId"),departmentId);
        };
    }
}
