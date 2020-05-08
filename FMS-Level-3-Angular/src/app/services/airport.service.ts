import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Airport } from '../model/app.airport';

@Injectable({
  providedIn: 'root'
})

export class AirportService{

  constructor(private httpClient:HttpClient){}

  //Returns list of all airports
  getAllAirports():Observable<Airport[]>{
      return this.httpClient.get<Airport[]>('http://localhost:9092/airport/allAirport');
  }

}
