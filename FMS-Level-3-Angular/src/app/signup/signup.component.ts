import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.component';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user: User={"userId": null, "userName":"", "userPassword":"", "userPhone": null, "userEmail":"", "active": null, "roles":""};

  public barLabel: string = "Password strength:";
  public myColors = ['#DD2C00', '#FF6D00', '#FFD600', '#AEEA00', '#00C853'];

  constructor(private router: Router, private loginservice: AuthenticationService) { }


  ngOnInit() {
    if(sessionStorage.getItem('role') === 'customer' || sessionStorage.getItem('role') === 'admin') {
      this.router.navigate(['noauth']);
    }
  }

  // Adds a new User
  signUp() {
    console.log(this.user);
    this.loginservice.signUp(this.user).subscribe();
    this.router.navigate(["login"]);
  }

  // UserName Validations
  nameFlag: boolean= false;
  validateName() {
    var flag =  /^[a-zA-Z ]+$/.test(this.user.userName);
    if(!flag) {
      this.nameFlag=true;
    }
    else {
      this.nameFlag=false;
    }
  }

  // UserPhone valdiations
  phoneFlag:boolean=false;
    validatePhone(){
        let phone=String(this.user.userPhone);
        if(phone.length!=10){
            this.phoneFlag=true;
        }else{
            this.phoneFlag=false;
        }
    }

    //UserEmail Validation
    emailFlag:boolean=false;
    validateEmail(){
        var flag=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(this.user.userEmail);
        if(!flag){
            this.emailFlag=true;
        }else{
            this.emailFlag=false;
        }
    }

    buttonFlag:boolean=true;
    enableButton(){
        this.buttonFlag=this.nameFlag||this.emailFlag||this.phoneFlag;
    }
}
