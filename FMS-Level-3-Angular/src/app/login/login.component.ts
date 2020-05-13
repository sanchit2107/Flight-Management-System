import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.component';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { ThrowStmt } from '@angular/compiler';
import { UserLogin } from '../model/user-login.component';
import { UserService } from '../services/user.service';
import { GlobalService } from '../services/global.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  users: User[];
  currentUser: User;
  userLogin: UserLogin;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private userService: UserService,
              private globalService: GlobalService,
              private loginService: LoginService) {
    this.currentUser = new User();
    this.userLogin = new UserLogin();
  }

  onSubmit(): void {
    this.userLogin.userName = this.currentUser.userName;
    this.userLogin.password = this.currentUser.userPassword;

    this.loginService.userLogin(this.userLogin)
      .subscribe(value => {
        if (value != null) {
          alert(this.globalService.getLoginStatus());
          this.globalService.setCurrentUser(value);
          this.globalService.setLoginStatus(true);
          if (value.userType == 'Admin') {
            this.router.navigate(['/adminpanel']);
          } else if (value.userType == 'User') {
            this.router.navigate(['/userpanel']);
            this.globalService.setCurrentUser(value);
          } else {
            this.globalService.setLoginStatus(false);
          }
        } else {
          this.globalService.setLoginStatus(false);
        }
        alert('2' + this.globalService.getLoginStatus());
      });
  }

  ngOnInit(): void {
  }

}
