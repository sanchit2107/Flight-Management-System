import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.component';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user: User;
  err: any;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private userService: UserService) {
    this.user = new User();
  }

  onSubmit() {

    this.userService.addUser(this.user).subscribe(data => {
      this.goToSuccess();
    }, error => {
      console.log('opps', error);
    });

  }

  goToSuccess() {
    this.router.navigate(['/signupsuccess']);
  }

  ngOnInit(): void {
  }

  // // Adds a new User
  // signUp() {
  //   console.log(this.user);
  //   this.loginservice.signUp(this.user).subscribe();
  //   this.router.navigate(["login"]);
  // }

  // // UserName Validations
  // nameFlag: boolean= false;
  // validateName() {
  //   var flag =  /^[a-zA-Z ]+$/.test(this.user.userName);
  //   if(!flag) {
  //     this.nameFlag=true;
  //   }
  //   else {
  //     this.nameFlag=false;
  //   }
  // }

  // // UserPhone valdiations
  // phoneFlag:boolean=false;
  //   validatePhone(){
  //       let phone=String(this.user.userPhone);
  //       if(phone.length!=10){
  //           this.phoneFlag=true;
  //       }else{
  //           this.phoneFlag=false;
  //       }
  //   }

  //   //UserEmail Validation
  //   emailFlag:boolean=false;
  //   validateEmail(){
  //       var flag=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(this.user.userEmail);
  //       if(!flag){
  //           this.emailFlag=true;
  //       }else{
  //           this.emailFlag=false;
  //       }
  //   }

  //   buttonFlag:boolean=true;
  //   enableButton(){
  //       this.buttonFlag=this.nameFlag||this.emailFlag||this.phoneFlag;
  //   }
}
