import { Component, OnInit } from '@angular/core';
import { FlightService } from './../service/data/flight.service';
import { BasicAuthenticationService } from './../service/basic-authentication.service';
import { TicketService } from './../service/data/ticket.service';

@Component({
  selector: 'app-manage-booking',
  templateUrl: './manage-booking.component.html',
  styleUrls: ['./manage-booking.component.css']
})
export class ManageBookingComponent implements OnInit {

  fromCity: string;
  toCity: string;
  departureDate: Date;
  passenger: number;
  seatingClass: string;
  flights: Flight[];
  tickets: Ticket[];
  fromCityList = ['NY', 'SFO', 'CLT'];
  toCityList = ['LA', 'LV'];
  timeHrs = [ 0, 1, 2, 3, 4, 5 , 6, 7,
    8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
     18, 19, 20, 21, 22, 23];
  timeMins = [0, 15, 30, 45];
  localUser: string;
  timeHr: number;
  timeMin: number;
  seatingClassList = ['Business', 'Economy'];
  passengerCountList = [ 1, 2, 3, 4, 5 , 6, 7,  8, 9];
  searchErrorMsg = '';
  searchError = false;
  selectFlightIds = '';
  selectTicketIds = '';

  constructor(private flightService: FlightService,
    private ticketService: TicketService,
    private basicAuthenticationService: BasicAuthenticationService) { }

  ngOnInit() {
  this.localUser = this.basicAuthenticationService.getAuthenticatedUser();
   this.searchFlights();
   this.getTicketsForUser();
  }

  searchFlights() {
    console.log(`${this.fromCity},${this.toCity}`);
    if ( !this.fromCity || !this.toCity ||  !this.departureDate || !this.timeHr
      || !this.timeMin  || !this.passenger || !this.seatingClass) {
      this.searchErrorMsg = 'Enter All search fields!!!';
      this.searchError = true;
      return;
    }
    this.searchErrorMsg = '';
    this.searchError = false;
    this.flightService.retrieveFlights
    (this.fromCity, this.toCity, this.departureDate,
      this.timeHr, this.timeMin, this.passenger, this.seatingClass)
    .subscribe(response => {
      console.log(response);
      this.flights = response;
    });
  }

  printDate(filterVal: any) {
    console.log(filterVal);
  }

  setFromCity(filterVal: any) {
    console.log(filterVal);
    this.fromCity = filterVal;
  }

  setToCity(filterVal: any) {
    console.log(filterVal);
    this.toCity = filterVal;
  }
  setTimeHr(filterVal: any) {
    console.log(filterVal);
    this.timeHr = filterVal;
  }

  setTimeMin(filterVal: any) {
    console.log(filterVal);
    this.timeMin = filterVal;
  }
  setSeatingClass(filterVal: any) {
    console.log(filterVal);
    this.seatingClass = filterVal;
  }

  setPassengerCount(filterVal: any) {
    console.log(filterVal);
    this.passenger = filterVal;
  }

  getTicketsForUser() {
    this.ticketService.retrieveTickets(this.localUser)
    .subscribe(response => {
      console.log(response);
      this.tickets = response;
    });
  }

  selection(row: Flight, filterVal: any) {
    console.log(row);
    console.log(filterVal);
    if (!row.selected) {
      row.selected = true;
    } else {
      row.selected = false;
    }
    console.log(row);
  }
  selectionTickets(row: Ticket, filterVal: any) {
    console.log(row);
    console.log(filterVal);
    if (!row.selected) {
      row.selected = true;
    } else {
      row.selected = false;
    }
    console.log(row);
  }

  bookTicket() {

    // tslint:disable-next-line:prefer-const
    for (let  row of  this.flights ) {
     if (row.selected) {
      console.log(row);
      this.selectFlightIds = this.selectFlightIds + ',' + row.id;
     }
   }
   console.log(this.selectFlightIds);
   this.ticketService.createTickets(this.localUser, this.passenger, this.selectFlightIds)
   .subscribe (
     data => {
       console.log(data);
       this.getTicketsForUser();
       this.searchFlights();
       this.selectFlightIds = '';
     }
   );
   this.getTicketsForUser();
  }

  cancelTicket() {
    // tslint:disable-next-line:prefer-const
    for (let  row of  this.tickets ) {
      if (row.selected) {
       console.log(row);
       this.selectTicketIds = this.selectTicketIds + ',' + row.id;
      }
    }
    this.ticketService.cancelTickets(this.localUser, this.selectTicketIds)
    .subscribe (
      data => {
        console.log(data);
        this.getTicketsForUser();
        this.searchFlights();
        this.selectTicketIds = '';
      }
    );
    this.getTicketsForUser();
   }


}

export class Flight {
  constructor(
    public id: number,
    public airlines: string,
    public fromCity: string,
    public toCity: string,
    public departureDate: Date,
    public arrivalDate: Date,
    public passengerCount: number,
    public seatingClass: string,
    public price: number,
    public currentPassengerCount: number,
    public selected: boolean,
    public hrs: number,
    public mins: number,
    public arrivalHrs: number,
    public arrivalMins: number
  ) {}
}

export class Ticket {
  constructor(
    public id: number,
    public airlines: string,
    public fromCity: string,
    public toCity: string,
    public departureDate: Date,
    public arrivalDate: Date,
    public passengerCount: number,
    public seatingClass: string,
    public price: number,
    public currentPassengerCount: number,
    public userName: string,
    public totalPrice: number,
    public selected: boolean,
    public hrs: number,
    public mins: number,
    public arrivalHrs: number,
    public arrivalMins: number,
    public flightId: number
  ) {}
}
