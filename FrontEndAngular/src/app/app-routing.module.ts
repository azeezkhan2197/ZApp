import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Customer } from 'src/model/customer.model';
import { CustomerComponent } from './customer/customer.component';
import { EmployeeComponent } from './employee/employee.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthorizationService } from './services/authorization.service';


const routes: Routes = [
  { path: "customer", component: CustomerComponent ,canActivate:[AuthorizationService]},
  { path: "employee", component: EmployeeComponent ,canActivate:[AuthorizationService]},
  { path: "login", component: LoginComponent },
  { path: "logout", component: LogoutComponent ,canActivate:[AuthorizationService]},
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
