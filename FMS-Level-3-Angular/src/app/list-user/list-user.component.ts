import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user.component';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {

  users: Observable<User[]>;

  constructor(private userService: UserService, private router:Router) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData(){
    this.users=this.userService.getUserList();
  }

  deleteUser(userId:number){
    this.userService.deleteUser(userId)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
  }

  updateUser(userId: number){
    this.router.navigate(['updateUser',userId])
    .then(() => {
      window.location.reload();
    });
  }

  userDetails(userId: number){
    this.router.navigate(['userDetails',userId]);
  }

}
