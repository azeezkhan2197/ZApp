import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import { Customer } from 'src/model/customer.model';

@Component({
  selector: 'app-info-customer',
  templateUrl: './info-customer.component.html',
  styleUrls: ['./info-customer.component.css']
})
export class InfoCustomerComponent implements OnInit {
  customer: Customer;
  constructor(private service: CustomerService) { }

  ngOnInit() {
    setInterval(() => {
      this.service.getById(sessionStorage.getItem("userId")).subscribe(
        result => {
          this.customer = result as Customer;
        },
        error => console.log("error ")
      );
    },
      1000)


  }

}
