import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ScheduledFlight } from '../model/scheduled-flight';

@Injectable({
  providedIn: 'root'
})

export class ScheduledFlightService {
  private SFurl: string;
  constructor(private http: HttpClient) { 
  }

  addScheduleFlight(scheduleFlight:ScheduledFlight,srcAirport,dstnAirport,deptDateTime,arrDateTime){
    let form=new FormData();
    form.append("scheduleFlightId", String(scheduleFlight.scheduleFlightId))
    form.append("availableSeats",String(scheduleFlight.availableSeats))
    form.append("flight",String(scheduleFlight.flight))
    form.append("schedule",String(scheduleFlight.schedule));
    let params = new HttpParams()
    .set('srcAirport', srcAirport)
    .set('dstnAirport', dstnAirport)
    .set('deptDateTime', deptDateTime)
    .set('arrDateTime', arrDateTime);
    console.log(scheduleFlight);
    console.log(params.toString());
   // console.log(form);
    return this.http.post('http://localhost:9092/scheduledFlight/add?',form,{params});
  }

  searchScheduledFlight(scheduledFlightId: number) {
    return this.http.get('http://localhost:9092/scheduledFlight/search?flightId='+scheduledFlightId);
  }

  showScheduleFlights(): Observable<any> {
    return this.http.get('http://localhost:9092/scheduledFlight/viewAll');
  }

  removeScheduleFlight(scheduleFlightId:number){
    return this.http.delete('http://localhost:9092/scheduledFlight/delete?flightId='+scheduleFlightId);
 }

 modifyScheduledFlight(scheduleFlight:ScheduledFlight){
   let mForm= new FormData();
   mForm.append("scheduleFlightId",String(scheduleFlight.scheduleFlightId))
   mForm.append("schedule",String(scheduleFlight.schedule))
   mForm.append("flight",String(scheduleFlight.flight))
   mForm.append("availableSeats",String(scheduleFlight.availableSeats))
   return this.http.put('http://localhost:9092/scheduledFlight/modify?',mForm);
 }

}
