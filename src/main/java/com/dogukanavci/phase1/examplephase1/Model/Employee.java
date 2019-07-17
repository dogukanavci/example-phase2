package com.dogukanavci.phase1.examplephase1.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{
    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private long salary;
    @Column(name = "department_id")
    private long departmentId;
    @Column(name = "manager_id")
    private long manager_id;
    @Column(name = "designation")
    private Designation designation;
    protected Employee(){}
    public Employee(String name, long salary,long department_id,long manager_id,Designation designation) {
        this.name = name;
        this.salary = salary;
        this.departmentId=department_id;
        this.manager_id=manager_id;
        this.designation=designation;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getManager_id() {
        return manager_id;
    }

    public void setManager_id(long manager_id) {
        this.manager_id = manager_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return String.format("Employee[id='%d', name='%s', salary='%d',department_id='%d',manager_id='%d',designation='%s']", id, name, salary,departmentId,manager_id,designation);
    }
}


