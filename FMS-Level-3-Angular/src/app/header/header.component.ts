import {Component, OnInit} from '@angular/core';
// import { AuthenticationService } from './_service/app.authenticationservice';

//Author: Devang
//Description: Component for header
//Created On: 21/10/2019

@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{

    buttonFlag:boolean;
    username:string;
    user:boolean;
    admin:boolean;

    constructor(){}

    ngOnInit(){
        this.user=false;
        this.admin=false;
        if(sessionStorage.getItem('role')==='user'){
            this.user=true;
        }else if(sessionStorage.getItem('role')==='admin'){
            this.admin=true;
        }
        // this.buttonFlag=this.authenticationService.isUserLoggedIn();
        this.username=sessionStorage.getItem('username');
        if(this.username!=null)
            this.username=this.username.toUpperCase();
    }

}
