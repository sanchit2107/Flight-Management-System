import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AirportListComponent } from './airport-list/airport-list.component';
import { CreateAirportComponent } from './create-airport/create-airport.component';
import { UpdateAirportComponent } from './update-airport/update-airport.component';
import { AirportDetailsComponent } from './airport-details/airport-details.component';


const routes: Routes = [{ path: '', redirectTo: 'employee', pathMatch: 'full' },
{ path: 'airports', component: AirportListComponent },
{ path: 'add', component: CreateAirportComponent },
{ path: 'update/:airportCode', component: UpdateAirportComponent },
{ path: 'details/:airportCode', component: AirportDetailsComponent },];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
