import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Airport } from '../model/airport.component';

@Injectable({
  providedIn: 'root'
})

export class AirportService{

  private baseUrl = 'http://localhost:9092/airport';
  constructor(private httpClient:HttpClient){}

  //Returns list of all airports
  getAllAirports():Observable<Airport[]>{
      return this.httpClient.get<Airport[]>(`${this.baseUrl}/allAirport`);
  }

  viewAirport(airportCode: string): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/viewAirport/${airportCode}`);
  }

  addAirport(airport: Object): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl}/addAirport`,airport);
  }

  modifyAirport(airportCode: string, value: any): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}/updateAirport`, value);
  }

  removeAirport(airportCode: string): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/deleteAirport/${airportCode}`, { responseType: 'text' });
  }

  viewAllAirport(): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/allAirport`);
  }

}
