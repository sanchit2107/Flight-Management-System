import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../model/booking.component';
import { BookingService } from '../services/booking.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.css']
})
export class BookingListComponent implements OnInit {

  bookings: Observable<Booking[]>;
  constructor(private bookingService: BookingService, private router: Router) {}
  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.bookings = this.bookingService.getBookingsList();
  }

  deleteBooking(bookingId: number) {
    this.bookingService.deleteBooking(bookingId)
    .subscribe(
      data=> {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error)
    );
  }

  bookingDetails(bookingId: number) {
    this.router.navigate(['bookingDetails', bookingId]);
  }

  updateBooking(bookingId: number) {
    this.router.navigate(['updateBooking', bookingId])
    .then(() => {
      window.location.reload();
    });
  }
}
