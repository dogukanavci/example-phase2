package com.dogukanavci.phase1.examplephase1.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
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
}


