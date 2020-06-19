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

  editCustomer(customer){
    console.log("in the service "+JSON.stringify(customer));
    return this.http.put<Customer>(this.URL,customer);
  }

  addCustomer(customer){    
    return this.http.post<Customer>(this.URL,customer);
  }

  delete(id){
    return this.http.delete<any>(this.URL+id);
  }

  getPassword(id){
    console.log("in the customer service "+id );
    return this.http.get<String>('http://localhost:7002/customers/password/'+id);
  }

  transferFund(id1,id2,amount,customer){
    return this.http.put<Customer>('http://localhost:7002/customers/'+id1+'/'+id2+'/'+amount,customer);
  }

}
