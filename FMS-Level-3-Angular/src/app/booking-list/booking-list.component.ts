import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../model/booking.component';
import { BookingService } from '../services/booking.service';
import { Router } from '@angular/router';
import { saveAs } from 'file-saver';


@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.css']
})
export class BookingListComponent implements OnInit {

  public popoverTitle: string = 'Cancel Booking?';
  public popoverMessage: string = 'This action cannot be undone.';
  public confirmClicked: boolean = false;
  public cancelClicked: boolean = false;

  bookingsList:Booking[];
  userId:number;
  currDate:any;

  constructor(private router:Router, private bookingService:BookingService){ }

  ngOnInit(){
      if(sessionStorage.getItem('role')==='admin'){
          this.router.navigate(['noauth']);
      }
      this.userId=+sessionStorage.getItem('userId');
      this.bookingService.getBookingsByUser(this.userId).subscribe((data:Booking[])=>this.bookingsList=data);
      this.currDate=new Date();
  }

  //Cancels a ticket
  cancelTicket(bookingId:number){
      this.bookingService.cancelTicket(bookingId).subscribe();
      location.reload();
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
      console.log("Done");
  }

  depSortRevFlag=true;
  depSortFlag:boolean=false;
  sortByDeparture(){
      this.depSortFlag=true;
      this.dateSortFlag=false;
      this.bookingsList.sort(
          (val1, val2)=>
              String(val1.scheduleFlight.schedule.deptDateTime).localeCompare(String(val2.scheduleFlight.schedule.deptDateTime))
      );
      this.depSortRevFlag=!this.depSortRevFlag;
      if(this.depSortRevFlag){
          this.bookingsList.reverse();
      }
  }

  dateSortRevFlag=true;
  dateSortFlag:boolean=false;
  sortByBookingDate(){
      this.depSortFlag=false;
      this.dateSortFlag=true;
      this.bookingsList.sort(
          (val1, val2)=>
              String(val1.bookingDate).localeCompare(String(val2.bookingDate))
      );
      this.dateSortRevFlag=!this.dateSortRevFlag;
      if(this.dateSortRevFlag){
          this.bookingsList.reverse();
      }
  }

}
