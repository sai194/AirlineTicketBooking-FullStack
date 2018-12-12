import { Injectable } from '@angular/core';
import { API_URL } from './../../app.constants';
import { HttpClient } from '@angular/common/http';
import { Ticket } from './../../manage-booking/manage-booking.component';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(private http: HttpClient) { }

  retrieveTickets(userName) {
    return this.http.get<Ticket[]>(`${API_URL}/tickets/${userName}`);
  }


  cancelTickets(username, ids) {
    return this.http.put(
          `${API_URL}/tickets/${username}`
                , ids);
  }

  createTickets(username, passengerCount, ids) {
    console.log(ids);
    return this.http.post(
              `${API_URL}/tickets/${username}/${passengerCount}`
                , ids);
  }
}
