import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { CustomerService } from './customer.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  temporaryPassword: String;
  constructor(private http: HttpClient,private customerService : CustomerService) { }


  authenticateCustomer(userId: string, password: string) {
    console.log("in the authentication service "+userId);
    console.log(this.customerService.getPassword(userId));
    this.customerService.getPassword(userId).subscribe(
      response => {
        console.log("password is "+response as String);
        this.temporaryPassword = response as String;
        console.log("temporary password is  "+this.temporaryPassword);
      },
      error => {
        return false;
      }
    )
    console.log("temporaryPassword id "+this.temporaryPassword +" and real password is "+password);
    if (this.temporaryPassword == password) {
      this.registerSuccessfulLogin(userId, password);
      return true;
    }
    else{
      return false;
    }
  }

  authenticateEmployee(userId: string, password: string) {
    this.http.get<String>('http://localhost:7002/employees/password/' + userId).subscribe(
      repsonse => {
        this.temporaryPassword = repsonse;
      },
      error => {
        return false;
      }
    )
    if (this.temporaryPassword === password) {
      this.registerSuccessfulLogin(userId, password);
      console.log()
      return true;
    }
    else{
      return false;
    }this.registerSuccessfulLogin(userId, password);

  }

  registerSuccessfulLogin(userId, password) {
    sessionStorage.setItem('userId', userId)
  }

  isLoggedIn() {
    if (sessionStorage.getItem('userId') == null)
      return false;
    else
      return true;
  }

}

