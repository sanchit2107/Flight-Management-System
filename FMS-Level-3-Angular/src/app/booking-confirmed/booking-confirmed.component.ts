import { Component, OnInit } from '@angular/core';
import { Booking } from '../model/booking.component';
import { BookingService } from '../services/booking.service';
import { Router, ActivatedRoute } from '@angular/router';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-booking-confirmed',
  templateUrl: './booking-confirmed.component.html',
  styleUrls: ['./booking-confirmed.component.css']
})
export class BookingConfirmedComponent implements OnInit {

    prevBooking:Booking;
    prevBookingId:number;
    userId:number=1;

    constructor(private route:ActivatedRoute, private router:Router, private bookingService:BookingService){}

    ngOnInit(){
        if(sessionStorage.getItem('role')==='admin'){
            this.router.navigate(['noauth']);
        }
        this.prevBookingId=+this.route.snapshot.paramMap.get("bookingId");
        this.bookingService.getPreviousBooking(this.prevBookingId).subscribe((data:Booking)=>this.prevBooking=data);
    }

    //Cancels a ticket
    cancelTicket(bookingId:number){
        this.bookingService.cancelTicket(bookingId).subscribe();
        this.router.navigate(['showbookings']);
    }

    //Downloads a ticket
    downloadTicket(bookingId:number){
        this.bookingService.downloadTicket(bookingId).subscribe(
            response => {
                var blob = new Blob([response], {type: 'application/pdf'});
                var filename = 'ticket.pdf';
                saveAs(blob, filename);
            },
            error => {
                console.error(`Error: ${error.message}`);
            }
        );
    }

}
