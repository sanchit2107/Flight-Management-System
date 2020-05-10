import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Airport } from '../model/airport.component';
import { AirportService } from '../services/airport.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-airport-list',
  templateUrl: './airport-list.component.html',
  styleUrls: ['./airport-list.component.css']
})
export class AirportListComponent implements OnInit {
  airports: Observable<Airport[]>;
  constructor(private airportService: AirportService,
  private router: Router) { }
  ngOnInit(){
    this.reloadData();
  }
  reloadData()
  {
    this.airports=this.airportService.viewAllAirport();
  }
  removeAirport(airportCode:string)
  {
    this.airportService.removeAirport(airportCode)
    .subscribe(
      data=>{
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
  }
  airportDetails(airportCode:string)
  {
    this.router.navigate(['details',airportCode]);
  }
  modifyAirport(airportCode:string)
  {
    this.router.navigate(['update',airportCode]);
  }
}
