import { Component, OnInit } from '@angular/core';
import { Flight } from '../model/flight.component';
import { ActivatedRoute, Router } from '@angular/router';
import { FlightService } from '../services/flight.service';

@Component({
  selector: 'app-flight-details',
  templateUrl: './flight-details.component.html',
  styleUrls: ['./flight-details.component.css']
})
export class FlightDetailsComponent implements OnInit {
  flightNo: number;
  flight: Flight;
  constructor(private route: ActivatedRoute,private router: Router,
    private flightService: FlightService) { }

  ngOnInit() {
    this.flight = new Flight();

    this.flightNo = this.route.snapshot.params['flightNo'];

    this.flightService.viewFlight(this.flightNo)
      .subscribe(data => {
        console.log(data)
        this.flight = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['flights']);
  }
}

