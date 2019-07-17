package com.dogukanavci.phase1.examplephase1.Repository;

import com.dogukanavci.phase1.examplephase1.Model.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
    List<Employee> findByName(String name);
    List<Employee> findByDepartmentId(Long department_id);
}
