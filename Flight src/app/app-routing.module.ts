import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FlightListComponent } from './flight-list/flight-list.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';


const routes: Routes = [{ 
  path: '', redirectTo: 'flight', pathMatch: 'full' },
{ path: 'flights', component: FlightListComponent },
{ path: 'add', component: CreateFlightComponent },
{ path: 'update/:flightNo', component: UpdateFlightComponent },
{ path: 'details/:flightNo', component: FlightDetailsComponent },];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
