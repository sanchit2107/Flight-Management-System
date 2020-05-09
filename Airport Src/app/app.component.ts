import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { registerLocaleData } from '@angular/common';
import {from} from "rxjs"

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent 
{
  title="Flight Management System";
}