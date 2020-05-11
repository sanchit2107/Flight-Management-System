import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { CreateBookingComponent } from './create-booking/create-booking.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { BookingDetailsComponent } from './booking-details/booking-details.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UpdateBookingComponent } from './update-booking/update-booking.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { SignupComponent } from './signup/signup.component';
import { PasswordStrengthMeterModule } from 'angular-password-strength-meter';
import { CreateAirportComponent } from './create-airport/create-airport.component';
import { AirportListComponent } from './airport-list/airport-list.component';
import { AirportDetailsComponent } from './airport-details/airport-details.component';
import { UpdateAirportComponent } from './update-airport/update-airport.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { SearchScheduledFlightComponent } from './search-scheduled-flight/search-scheduled-flight.component';
import { AddScheduledFlightComponent } from './add-scheduled-flight/add-scheduled-flight.component';
import { ShowScheduledFlightsComponent } from './show-scheduled-flights/show-scheduled-flights.component';
import { ModifyScheduledFlightComponent } from './modify-scheduled-flight/modify-scheduled-flight.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { ListUserComponent } from './list-user/list-user.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    CreateBookingComponent,
    BookingListComponent,
    BookingDetailsComponent,
    UpdateBookingComponent,
    HomeComponent,
    LoginComponent,
    LogoutComponent,
    SignupComponent,
    CreateAirportComponent,
    AirportListComponent,
    AirportDetailsComponent,
    UpdateAirportComponent,
    CreateFlightComponent,
    FlightDetailsComponent,
    FlightListComponent,
    UpdateFlightComponent,
    SearchScheduledFlightComponent,
    AddScheduledFlightComponent,
    ModifyScheduledFlightComponent,
    ShowScheduledFlightsComponent,
    UserDetailsComponent,
    CreateUserComponent,
    UpdateUserComponent,
    ListUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    PasswordStrengthMeterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
