import { Component, OnInit } from '@angular/core';
import { Airport } from '../model/airport.component';
import { ActivatedRoute, Router } from '@angular/router';
import { AirportService } from '../services/airport.service';

@Component({
  selector: 'app-update-airport',
  templateUrl: './update-airport.component.html',
  styleUrls: ['./update-airport.component.css']
})
export class UpdateAirportComponent implements OnInit {
  airportCode:string;
  airport:Airport;
  constructor(private route: ActivatedRoute,private router: Router,
    private airportService: AirportService) { }

  ngOnInit(){
    this.airport = new Airport();

    this.airportCode= this.route.snapshot.params['airportCode'];

    this.airportService.viewAirport(this.airportCode)
      .subscribe(data => {
        console.log(data)
        this.airport = data;
      }, error => console.log(error));
  }
  updateAirport() {
    this.airportService.modifyAirport(this.airportCode, this.airport)
      .subscribe(data => console.log(data), error => console.log(error));
    this.airport = new Airport();
    this.gotoList();
  }

  onSubmit() {
    this.updateAirport();
  }

  gotoList() {
    this.router.navigate(['/airports']);
  }
}

