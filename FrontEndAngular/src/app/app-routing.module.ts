import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Customer } from 'src/model/customer.model';
import { CustomerComponent } from './customer/customer.component';
import { EmployeeComponent } from './employee/employee.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthorizationService } from './services/authorization.service';
import { InfoCustomerComponent } from './info-customer/info-customer.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { TransferComponent } from './transfer/transfer.component';
import { DepositComponent } from './deposit/deposit.component';


const routes: Routes = [
  {
    path: 'customer', component: CustomerComponent, canActivate: [AuthorizationService],
    children: [
      { path: '', component: InfoCustomerComponent, canActivate: [AuthorizationService] },
      { path: 'infoCustomer', component: InfoCustomerComponent, canActivate: [AuthorizationService] },
      { path: 'editCustomer', component: EditCustomerComponent, canActivate: [AuthorizationService] },
      { path: 'transfer', component: TransferComponent, canActivate: [AuthorizationService] },
      { path: 'deposit', component: DepositComponent, canActivate: [AuthorizationService] }
    ]
  },
  { path: 'employee', component: EmployeeComponent, canActivate: [AuthorizationService] },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent, canActivate: [AuthorizationService] },
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
