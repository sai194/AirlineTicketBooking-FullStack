import { Injectable } from '@angular/core';
import { Flight } from './../../manage-booking/manage-booking.component';
import { API_URL } from './../../app.constants';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  flight: Flight;
  constructor(private http: HttpClient) { }

  retrieveFlights(fromCity, toCity, departureDate, hrs, mins, passenger, seating) {
    console.log (`${API_URL}/flights/${fromCity}/${toCity}/${departureDate}/${hrs}/${mins}/${passenger}/${seating}`);
    return this.http.get<Flight[]>
    (`${API_URL}/flights/${fromCity}/${toCity}/${departureDate}/${hrs}/${mins}/${passenger}/${seating}`);
  }
}


