import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Department } from '../entity/department';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class DepartmentService {

private departmentsUrl: string;

constructor(private http: HttpClient) {
    this.departmentsUrl = 'http://localhost:8080/departments';
  }

  public findAll(): Observable<Department[]> {
    return this.http.get<Department[]>(this.departmentsUrl);
  }

  public find(id: string) {
    return this.http.get<Department>(this.departmentsUrl + '/' + id);
  }

  public save(department: Department) {
    return this.http.post<Department>(this.departmentsUrl, department);
  }


}
