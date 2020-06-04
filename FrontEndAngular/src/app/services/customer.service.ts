import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from 'src/model/customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  URL = 'http://localhost:7002/customers/';
  constructor(private http : HttpClient) { }
  getById(id){
    return this.http.get(this.URL+String(id));
  }

  getAll(){
    return this.http.get(this.URL);
  }

  editEmployee(employee){
    console.log("in the service "+employee.firstName);
    return this.http.put<Customer>(this.URL,employee);
  }

  addEmployee(employee){    
    return this.http.post<Customer>(this.URL,employee);
  }

  delete(id){
    return this.http.delete<any>(this.URL+id);
  }

  getPassword(id){
    console.log("in the customer service "+id );
    return this.http.get<String>(this.URL+'password/'+id);
  }

}
