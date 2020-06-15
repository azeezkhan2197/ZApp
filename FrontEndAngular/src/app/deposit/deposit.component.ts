import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/model/customer.model';
import { CustomerService } from '../services/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {
  customer: Customer;
  amount : number;
  warning : String = null;  ;
  constructor(private service: CustomerService,private router : Router ) { }

  ngOnInit() {
    console.log(sessionStorage.getItem('userId'));
    this.service.getById(sessionStorage.getItem('userId')).subscribe(
      result => {
        this.customer = result as Customer;
      },
      error => console.log("error")
    );
  }

  onSubmit(){
    if(this.amount >0 ){
    this.customer.amount = this.amount + this.customer.amount;
    this.service.editCustomer(this.customer).subscribe(
      resposne=> console.log(resposne),
      error => console.log(error)
    );

    this.router.navigate(['customer']);
    }
    else{
      this.warning =" amount should be greter than equal to zero";
    }
  }

}
