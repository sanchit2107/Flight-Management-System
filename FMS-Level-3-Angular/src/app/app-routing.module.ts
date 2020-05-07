import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookingListComponent } from './booking-list/booking-list.component';
import { CreateBookingComponent } from './create-booking/create-booking.component';
import { UpdateBookingComponent } from './update-booking/update-booking.component';
import { BookingDetailsComponent } from './booking-details/booking-details.component';


const routes: Routes = [
  {path: '', redirectTo: 'booking', pathMatch: 'full'},
  {path: 'bookings', component: BookingListComponent},
  {path: 'add', component: CreateBookingComponent},
  {path: 'update/:id', component: UpdateBookingComponent},
  {path: 'details/:id', component: BookingDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
