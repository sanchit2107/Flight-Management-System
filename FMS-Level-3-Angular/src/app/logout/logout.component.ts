import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  template: ''
})
export class LogoutComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService,
    private router: Router) { }

  ngOnInit() {

    this.authenticationService.logOut();
    sessionStorage.setItem('role', null);
    sessionStorage.setItem('userId', null);
    this.router.navigate(['login']);
  }

}
