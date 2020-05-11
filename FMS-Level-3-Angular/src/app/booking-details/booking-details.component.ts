import {Component, OnInit} from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { BookingService } from '../services/booking.service';
import { Booking } from '../model/booking.component';
import { Passenger } from '../model/passenger.component';

//Author: SANCHIT SINGHAL
//Description: Component for adding passenger details
//Created On:

@Component({
    selector: 'booking-detail',
    templateUrl: './booking-details.component.html',
    styleUrls: ['./booking-details.component.css']
})
export class BookingDetailsComponent implements OnInit{

    flightId:number;
    booking:Booking={bookingId:null, bookingDate:null, bookingState:null, passengerCount:null, userId:null, ticketCost:null, scheduleFlight:null, passengerList:null};
    passengerList:Passenger[]=[{pnrNumber: null, passengerName:"", passengerAge:null, passengerUIN:null, passengerState:true}];
    passengerCount:number=1;

    minAge:number=5;
    maxAge:number=99;

    constructor(private route: ActivatedRoute, private router:Router, private bookingService:BookingService){}

    ngOnInit(){
        if(sessionStorage.getItem('role')==='admin'){
            this.router.navigate(['noauth']);
        }
        this.flightId=+this.route.snapshot.paramMap.get("flightId");
    }

    //Adds a passenger to template
    addPassenger(){
        if(this.passengerCount<=3){
            this.passengerList.push({pnrNumber: null, passengerName:"", passengerAge:null, passengerUIN:null, passengerState:true});
            this.passengerCount++;
        }
    }

    //Removes a passenger from template
    removePassenger(){
        if(this.passengerCount>1){
            this.passengerList.pop();
            this.passengerCount--;
        }
    }

    //Saves the booking
    addBooking(){
        this.booking.passengerList=this.passengerList;
        this.bookingService.addBooking(this.passengerList, this.flightId, sessionStorage.getItem('userId')).subscribe((data:Booking)=>this.booking=data);
        this.router.navigate(['booking/confirmation', this.booking.bookingId]);
    }

    buttonDisable:boolean=true;

    //Validation
    nameFlag:boolean=true;
    validateName(){
        this.nameFlag=true;
        for(let i=0; i<this.passengerList.length; i++){
            let name=this.passengerList[i].passengerName;
            var flag = /^[a-zA-Z ]+$/.test(name);
            this.nameFlag= this.nameFlag&&flag;
        }
    }

    //Validation
    ageFlag:boolean=true;
    validateAge(){
        this.ageFlag=true;
        for(let i=0; i<this.passengerList.length; i++){
            let age=this.passengerList[i].passengerAge;
            var flag=false;
            if(age>=5 && age<=99){
                flag=true;
            }
            this.ageFlag= this.ageFlag&&flag;
        }
    }

    //Validation
    uinFlag:boolean=true;
    validateUIN(){
        this.uinFlag=true;
        for(let i=0; i<this.passengerList.length; i++){
            let uin=String(this.passengerList[i].passengerUIN);
            var flag=false;
            if(uin.length==12){
                flag=true;
            }
            this.uinFlag= this.uinFlag&&flag;
        }
    }

    //Validation
    enableButton(){
        if(this.nameFlag && this.ageFlag && this.uinFlag){
            this.buttonDisable=false;
        }else{
            this.buttonDisable=true;
        }
    }

}
