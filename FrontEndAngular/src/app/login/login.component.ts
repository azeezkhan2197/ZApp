import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userId: string;
  password: string;
  message: string = null;
  constructor(private router: Router, private service: AuthenticationService) { }

  ngOnInit() {
  }


  login() {
    if (this.userId.substring(0, 1) == 'C') {
       
      if (this.service.authenticateCustomer(this.userId, this.password)) {
      
        this.router.navigate(['customer']);
      }
      else {
        this.message = "invalid userId or password";
      }
    }
    else {
      if (this.service.authenticateEmployee(this.userId, this.password)) {
        this.router.navigate(['employee']);
      }
      else {
        this.message = "invalid userId or password";
      }
    }
  }
}
