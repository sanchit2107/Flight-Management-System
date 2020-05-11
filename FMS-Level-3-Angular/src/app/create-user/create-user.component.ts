import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.component';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  user: User = new User();
  submitted=false;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

    newUser(): void{
      this.submitted=false;
      this.user=new User();
    }

    save(){
      this.userService.createUser(this.user).subscribe(data => console.log(data), error => console.log(error));
      this.user = new User();
      this.gotoList();
    }

    onSubmit(){
      this.submitted=true;
      this.save();
    }

    gotoList(){
      this.router.navigate(['/addUser']);
    }

}
