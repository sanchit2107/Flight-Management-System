import { Injectable } from '@angular/core';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AuthenticationService } from './authentication.service';

//Author: SANCHIT SINGHAL
//Description: Performs Routing for invalid user
//Created On: 08/05/2020

@Injectable({
  providedIn: 'root'
})
export class AuthguardService {

  constructor(private router: Router, private authSerivce: AuthenticationService) { }

  // Routes to error page if user is not logged in
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if(this.authSerivce.isUserLoggedIn()) {
      return true;
    }
    this.router.navigate(['login']);
    return false;
  }
}
