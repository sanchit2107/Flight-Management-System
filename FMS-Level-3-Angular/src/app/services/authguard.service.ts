import { Injectable } from '@angular/core';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { GlobalService } from './global.service';

//Author: SANCHIT SINGHAL
//Description: Performs Routing for invalid user
//Created On: 08/05/2020

@Injectable({
  providedIn: 'root'
})
export class AuthguardService {

  constructor(private route: ActivatedRoute,
    private router: Router,
    private globalService: GlobalService) {
}

  canActivate() {
    alert('AuthGaurd activated');
    if (this.globalService.getLoginStatus()) {
      return true;
    } else {
      alert('Login required to access the page.')
      this.router.navigate(['/login']);
      return false;
    }
  }
}
