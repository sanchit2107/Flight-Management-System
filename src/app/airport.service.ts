import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AirportService {

  private baseUrl = 'http://localhost:9092/airport';

  constructor(private http: HttpClient) { }

  viewAirport(airportCode: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/viewAirport/${airportCode}`);
  }

  addAirport(airport: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/addAirport`,airport);
  }

  modifyAirport(airportCode: string, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/updateAirport`, value);
  }

  removeAirport(airportCode: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deleteAirport/${airportCode}`, { responseType: 'text' });
  }

  viewAllAirport(): Observable<any> {
    return this.http.get(`${this.baseUrl}/allAirport`);
  }
}
