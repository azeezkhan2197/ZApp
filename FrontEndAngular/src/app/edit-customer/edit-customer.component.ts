import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/model/customer.model';
import { CustomerService } from '../services/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  customer : Customer;
  constructor(private router : Router,private service : CustomerService) { }

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
    this.service.editCustomer(this.customer).subscribe(
      resposne=> console.log(resposne),
      error => console.log(error)
    );

    this.router.navigate(['customer']);
  }

}
