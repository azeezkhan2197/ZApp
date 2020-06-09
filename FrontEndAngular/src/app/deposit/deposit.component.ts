import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/model/customer.model';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {
  customer: Customer;
  amount : number;
  constructor(private service: CustomerService) { }

  ngOnInit() {
    setInterval(() => {
      this.service.getById(sessionStorage.getItem("userId")).subscribe(
        result => this.customer = result as Customer,
        error => console.log(error)
      );
    },
      1000)
  }

  onSubmit(){
    this
  }

}
