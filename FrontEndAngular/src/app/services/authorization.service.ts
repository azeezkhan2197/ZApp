import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService implements CanActivate {
  constructor(private service : AuthenticationService ,private router : Router) { }

  canActivate(route: import("@angular/router").ActivatedRouteSnapshot, state: import("@angular/router").RouterStateSnapshot){
    if(this.service.isLoggedIn()){
      return true;
    }
    else{
      this.router.navigate(['login']);
      return false;
    }
  }
}
