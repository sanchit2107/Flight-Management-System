import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Passenger } from '../model/passenger.component';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private httpClient:HttpClient){}

    //Finds flights for booking
    findFlights(src:string, dest:string, date:string){
        return this.httpClient.get("http://localhost:9092/booking/find?source_airport="+src+"&destination_airport="+dest+"&journey_date="+date);
    }

    //Adds a new bookings
    addBooking(passengerList:Passenger[], flightId:any, userId:any){
        let form=new FormData();
        //form.append("prodId", data.prodId);
        for(let i=0; i<passengerList.length; i++){
            form.append("passengerList["+i+"].passengerName", passengerList[i].passengerName);
            form.append("passengerList["+i+"].passengerAge", String(passengerList[i].passengerAge));
            form.append("passengerList["+i+"].passengerUIN", String(passengerList[i].passengerUIN));
        }
        return this.httpClient.post("http://localhost:9092/booking/add/?flightId="+flightId+"&userId="+userId, form);
    }

    //Returns bookings made by user
    getBookingsByUser(userId:number){
        return this.httpClient.get("http://localhost:9092/booking/getbyuserid?userId="+userId);
    }

    //Downloads ticket pdf
    downloadTicket(bookingId:number): Observable<Blob> {
        return this.httpClient.get("http://localhost:9092/booking/download?booking_id="+bookingId, {
            responseType: "blob"
          });
    }

    //Cancels a booking
    cancelTicket(bookingId:number){
        return this.httpClient.delete("http://localhost:9092/booking/cancel?bookingId="+bookingId);
    }

    //Retrieves last booking by user
    getPreviousBooking(bookingId:number){
        return this.httpClient.get("http://localhost:9092/booking/getbyid?bookingId="+bookingId);
    }

}
