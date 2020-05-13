import {Component, OnInit, Input} from '@angular/core';
import { GlobalService } from '../services/global.service';

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

    @Input() title: string;
    loginStatus: boolean;

    constructor(private globalService: GlobalService) {
      this.loginStatus = this.globalService.getLoginStatus();
    }

    changeLoginState(ls: boolean) {
      this.globalService.setLoginStatus(ls);
      this.loginStatus = this.globalService.getLoginStatus();
      alert('logout' + this.globalService.getLoginStatus());
    }

    ngOnInit(): void {
      this.loginStatus = this.globalService.getLoginStatus();
    }

}
