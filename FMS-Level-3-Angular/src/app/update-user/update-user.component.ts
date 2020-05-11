import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.component';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  submitted: false;
  userId: number;
  user: User;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) { }

  ngOnInit(): void {
    this.user = new User();

    this.userId = this.route.snapshot.params['userId'];

    this.userService.getUser(this.userId)
    .subscribe(data => {
      console.log(data);
    },
    error => console.log(error)
    );
  }

  updateUser(){
    this.userService.updateUser(this.user)
    .subscribe(data => console.log(data), error => console.log(error));
    this.user = new User();
    this.gotoList();
  }

  onSubmit(){
    this.updateUser();
  }

  gotoList(){
    this.router.navigate(['/users']);
  }

}
