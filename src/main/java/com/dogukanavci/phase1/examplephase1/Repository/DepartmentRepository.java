package com.dogukanavci.phase1.examplephase1.Repository;

import com.dogukanavci.phase1.examplephase1.Entity.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    List<Department> findByName(String name);
}
