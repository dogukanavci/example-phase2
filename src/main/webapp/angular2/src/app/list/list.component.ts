import { Component, OnInit } from '@angular/core';
import { Employee } from '../entity/employee';
import { Department } from '../entity/department';
import { EmployeeService } from '../service/employee-service.service';
import { DepartmentService } from '../service/department-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  employees: Employee[];
  employees2: Employee[];
  departments: Department[];
  departments2: Department[];
  showDepartments: Boolean;
  constructor(private route: ActivatedRoute, private router: Router,private employeeService: EmployeeService,private departmentService: DepartmentService) { }

  ngOnInit() {
    if(localStorage.getItem("logged")=="false"){
      this.router.navigate(['/login']);
    }
    this.showDepartments = false;
    this.employeeService.findAll().subscribe(data => {
      this.employees = data;
      this.employees2 = [];
    });
    this.departmentService.findAll().subscribe(data => {
      this.departments = data;
      this.departments2 = [];
    });
  }

  switchEmp(e: Employee){
    const index: number = this.employees2.indexOf(e);
    if (index !== -1) {
        this.employees2.splice(index, 1);
    }
    else{
        this.employees2.push(e);
    }
  }

  switchDep(d: Department){
    const index: number = this.departments2.indexOf(d);
    if (index !== -1) {
        this.departments2.splice(index, 1);
    }
    else{
        this.departments2.push(d);
    }
  }

  showDeps(){this.showDepartments = true;}
  showEmps(){this.showDepartments = false;}
  getShowDeps(){return this.showDepartments;}

}

