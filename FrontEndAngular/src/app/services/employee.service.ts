import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from 'src/model/employee.model';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  URL = 'http://localhost:7002/api/employees/';

  constructor(private http: HttpClient) { }
  getById(id){
    return this.http.get(this.URL+String(id));
  }

  getAll(){
    return this.http.get(this.URL);
  }

  editEmployee(employee){
    console.log("in the service "+employee.firstName);
    return this.http.put<Employee>(this.URL,employee);
  }

  addEmployee(employee){    
    return this.http.post<Employee>(this.URL,employee);
  }

  delete(id){
    return this.http.delete<any>(this.URL+id);
  }

}
