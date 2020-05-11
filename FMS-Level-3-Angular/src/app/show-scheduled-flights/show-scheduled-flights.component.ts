import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ScheduledFlightService } from '../services/scheduled-flight.service';
import { ScheduledFlight } from '../model/scheduled-flight';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-show-scheduled-flights',
  templateUrl: './show-scheduled-flights.component.html',
  styleUrls: ['./show-scheduled-flights.component.css']
})
export class ShowScheduledFlightsComponent implements OnInit {

  public confirmClicked: boolean = false;
  public cancelClicked: boolean = false;
  scheduleFlights: Observable<ScheduledFlight[]>;

  constructor(private router: Router, private service: ScheduledFlightService) { }

  ngOnInit(): void {
    this.service.showScheduleFlights().subscribe(
      (data:Observable<ScheduledFlight[]>)=>this.scheduleFlights=data
    );
  }

  removeScheduleFlight(scheduleFlightId:number){
    this.service.removeScheduleFlight(scheduleFlightId).subscribe();
    alert("Deleted");
    location.reload();
}

  add(){

    this.router.navigate(['/scheduledFlight/add']);

  }

  view(){

    this.router.navigate(['/scheduledFlight/show']);

  }

  search(){

    this.router.navigate(['/scheduledFlight/search']);

  }

}
