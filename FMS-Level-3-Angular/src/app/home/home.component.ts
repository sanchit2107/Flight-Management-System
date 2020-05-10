import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Airport } from '../model/airport.component';
import { AirportService } from '../services/airport.service';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  airports:Airport[]=[];

    src:string;
    dest:string;
    journeyDate:string;

    minDate:any;
    maxDate:any;

    errorFlag:boolean=false;

    constructor(private router:Router, private airportService:AirportService){
        this.minDate=new Date();
        this.maxDate=new Date();
        this.maxDate.setMonth(this.maxDate.getMonth()+2);
    }

    ngOnInit(){
        this.airportService.getAllAirports().subscribe((data:Airport[])=>this.airports=data);
    }

    findFlights(){
        this.router.navigate(['/booking/availableflights', this.src, this.dest, this.journeyDate]);
    }

    airportCheck(){
        if(this.src===this.dest){
            this.errorFlag=true;
        }else{
            this.errorFlag=false;
        }
    }

    sendMessage(){
        alert("Thank You for reaching out to us.");
        this.router.navigate(["/home"]);
    }

}
