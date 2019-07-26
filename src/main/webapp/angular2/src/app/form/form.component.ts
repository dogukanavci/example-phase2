import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../entity/employee';
import { Department } from '../entity/department';
import { EmployeeService } from '../service/employee-service.service';
import { DepartmentService } from '../service/department-service.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent{
  employee: Employee;
  department: Department;
  creationId : number;

  constructor(private route: ActivatedRoute, private router: Router, private employeeService: EmployeeService,private departmentService: DepartmentService) {
    this.employee = new Employee();
    this.department = new Department();
  }

  ngOnInit() {
    if(localStorage.getItem("logged")=="false"){
      this.router.navigate(['/login']);
    }
    this.creationId=0;
  }
  onSubmit() {
    switch(this.creationId) {
      case 0: {
        this.employeeService.save(this.employee).subscribe(result => this.gotoList());
        break;
      }
      case 1: {
        this.departmentService.save(this.department).subscribe(result => this.gotoList());
        console.log("Department created");
        break;
      }
      default: {
        break;
      }
    }
  }

  gotoList() {
    this.router.navigate(['/lists']);
  }

}
