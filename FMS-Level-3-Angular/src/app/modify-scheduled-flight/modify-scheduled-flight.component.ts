import { Component, OnInit } from '@angular/core';
import { ScheduledFlight } from '../model/scheduled-flight';
import { Router } from '@angular/router';
import { ScheduledFlightService } from '../services/scheduled-flight.service';

@Component({
  selector: 'app-modify-scheduled-flight',
  templateUrl: './modify-scheduled-flight.component.html',
  styleUrls: ['./modify-scheduled-flight.component.css']
})
export class ModifyScheduledFlightComponent implements OnInit {
  scheduleFlight:ScheduledFlight;
  scheduleFlightId:number;
  show:boolean=false;
  //  modifyScheduleFlight: ScheduledFlight;
  //  mScheduleFlightId: number;
  //  mFlight: number;
  //  mAvailableSeats: number;
  //  mSchedule: number;
  mScheduleFlight:ScheduledFlight;


  constructor(private service: ScheduledFlightService, private router: Router) { }

  ngOnInit(): void {
    this.scheduleFlight=new ScheduledFlight();
  }
  searchScheduleFlight(scheduleFlightId:number):any{
    this.show=true;
    console.log(scheduleFlightId);
    this.service.searchScheduledFlight(this.scheduleFlightId).subscribe((scheduleFlight:ScheduledFlight)=>this.scheduleFlight=scheduleFlight);
  }

  modifyScheduledFlight(sId, aSeats, schedule,flight){
    this.mScheduleFlight={
      scheduleFlightId: sId,
      availableSeats: aSeats,
      flight: flight,
      schedule: schedule};
      console.log(this.mScheduleFlight);
      if(this.mScheduleFlight==null){
        alert("Scheduled Flight hnot modified");
      }
      this.service.modifyScheduledFlight(this.mScheduleFlight).subscribe();
      alert("Scheduled Flight Modified!");
  }

  idValid:boolean=false;
validateId(){
    if(this.scheduleFlightId>999){
        this.idValid=true;
    }
    else if(this.scheduleFlightId<1){
        this.idValid=true;
    }else{
        this.idValid=false;
    }
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
