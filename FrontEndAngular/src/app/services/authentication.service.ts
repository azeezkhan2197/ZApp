import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { CustomerService } from './customer.service';
import { Customer } from 'src/model/customer.model';
import { Employee } from 'src/model/employee.model';
import { EmployeeService } from './employee.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  temporaryCustomer =  new Customer();
  temporaryEmployee  = new Employee();
  constructor(private http: HttpClient, private customerService: CustomerService,
    private employeeService : EmployeeService) { }

    fetchdetails(userId: string, password: string){
      this.customerService.getById(userId).subscribe(
        response => {
          this.temporaryCustomer = response as Customer;
          console.log("temporary password is  " + this.temporaryCustomer.password);
        },
        error => {
          return false;
        }
      )
    }
  authenticateCustomer(userId: string, password: string) {
    console.log("password from the login is "+password);
    if (this.temporaryCustomer.password === password) {
      this.registerSuccessfulLogin(userId);
      return true;
    }
    else {
      return false;
    }
  }

  authenticateEmployee(userId: string, password: string) {
    this.employeeService.getById(userId).subscribe(
      repsonse => {
        this.temporaryEmployee = repsonse as Employee;
        console.log("temporary password in subscribe is " + this.temporaryEmployee.password)
      },
      error => {
        return false;
      }
    )
    console.log("in authenticate method temporary password is "+this.temporaryEmployee.password);
    if ( this.temporaryEmployee.password === password) {
      this.registerSuccessfulLogin(userId);
      console.log()
      return true;
    }
    else {
      return false;
    }
  }

  registerSuccessfulLogin(userId) {
    sessionStorage.setItem('userId', userId)
  }

  isLoggedIn() {
    if (sessionStorage.getItem('userId') == null)
      return false;
    else
      return true;
  }

}

