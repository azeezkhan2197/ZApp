import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import { Router } from '@angular/router';
import { Customer } from 'src/model/customer.model';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {
  customerList: Customer[];
  customer: Customer;
  depositorCustomerId: String;
  amount : number;
  insufficientAmountMessage = null;
  wrongAccountNumberMessage = null;
  

  constructor(private service: CustomerService, private router: Router) { }

  ngOnInit() {
    this.service.getById(sessionStorage.getItem("userId")).subscribe(
      result => {
        this.customer = result as Customer;
      },
      error => console.log("error ")
    );


    this.service.getAll().subscribe(
      response => {
        this.customerList = response as Customer[];
      },
      error => console.log(error)
    )
  }

  onSubmit() {
    if(!this.isCustomerPresent()){
      this.wrongAccountNumberMessage = " account number doesnot exist";
    }
    else if(this.amount > this.customer.amount || this.amount < 0){
      this.insufficientAmountMessage = "amount to be transfered is less than the present amount or less than zero ";
    }
    else{
      this.service.transferFund(this.customer.id,this.depositorCustomerId,this.amount,this.customer).subscribe(
        response =>{
          this.router.navigate(['customer'])
        },
        error => console.log(error)
      );

    }

  }

  isCustomerPresent() {
    console.log(this.depositorCustomerId)
    for (let obj of this.customerList) {
      if (obj.id == this.depositorCustomerId)
        return true;
    }
    return false;
  }
}
