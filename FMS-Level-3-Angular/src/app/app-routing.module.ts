import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookingListComponent } from './booking-list/booking-list.component';
import { CreateBookingComponent } from './create-booking/create-booking.component';
import { UpdateBookingComponent } from './update-booking/update-booking.component';
import { BookingDetailsComponent } from './booking-details/booking-details.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { SignupComponent } from './signup/signup.component';
import { AirportListComponent } from './airport-list/airport-list.component';
import { CreateAirportComponent } from './create-airport/create-airport.component';
import { UpdateAirportComponent } from './update-airport/update-airport.component';
import { AirportDetailsComponent } from './airport-details/airport-details.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';


const routes: Routes = [
  {path: '', redirectTo: 'booking',pathMatch: 'full'},
  {path: 'bookings', component: BookingListComponent},
  {path: 'addBooking', component: CreateBookingComponent},
  {path: 'updateBooking/:id', component: UpdateBookingComponent},
  {path: 'bookingDetails/:id', component: BookingDetailsComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'airports', component: AirportListComponent },
  {path: 'addAirport', component: CreateAirportComponent },
  {path: 'update/:airportCode', component: UpdateAirportComponent },
  {path: 'details/:airportCode', component: AirportDetailsComponent },
  {path: 'flights', component: FlightListComponent },
  {path: 'addFlight', component: CreateFlightComponent },
  {path: 'updateFlight/:flightNo', component: UpdateFlightComponent },
  {path: 'flightDetails/:flightNo', component: FlightDetailsComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
