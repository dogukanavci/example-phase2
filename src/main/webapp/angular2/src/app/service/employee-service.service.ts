import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../entity/employee';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class EmployeeService {

private employeesUrl: string;

constructor(private http: HttpClient) {
    this.employeesUrl = 'http://localhost:8080/employees';
  }

  public findAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeesUrl);
  }

  public find(id: string) {
    return this.http.get<Employee>(this.employeesUrl + '/' + id);
  }

  public save(employee: Employee) {
    return this.http.post<Employee>(this.employeesUrl, employee);
  }


}
