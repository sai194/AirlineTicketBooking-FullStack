package com.sye.microservices.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tickets")
public class Ticket {
	
	@Id
    @GeneratedValue
    @Column(name = "ticket_id")
    private Long id;
	private String airlines;
	private String fromCity;
	private String toCity;
	private Date departureDate;
	private Date arrivalDate;
	private Long passengerCount;
	private String seatingClass;
	private Double price;
	private Double totalPrice;
	@Transient
	private Long currentPassengerCount;
	private String userName;
	private int active;
	private Long hrs;
	private Long mins;
	private Long arrivalHrs;
	private Long arrivalMins;
	private Long flightId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Long getPassengerCount() {
		return passengerCount;
	}
	public void setPassengerCount(Long passengerCount) {
		this.passengerCount = passengerCount;
	}
	public String getSeatingClass() {
		return seatingClass;
	}
	public void setSeatingClass(String seatingClass) {
		this.seatingClass = seatingClass;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getCurrentPassengerCount() {
		return currentPassengerCount;
	}
	public void setCurrentPassengerCount(Long currentPassengerCount) {
		this.currentPassengerCount = currentPassengerCount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Long getHrs() {
		return hrs;
	}
	public void setHrs(Long hrs) {
		this.hrs = hrs;
	}
	public Long getMins() {
		return mins;
	}
	public void setMins(Long mins) {
		this.mins = mins;
	}

	public Long getArrivalHrs() {
		return arrivalHrs;
	}
	public void setArrivalHrs(Long arrivalHrs) {
		this.arrivalHrs = arrivalHrs;
	}
	public Long getArrivalMins() {
		return arrivalMins;
	}
	public void setArrivalMins(Long arrivalMins) {
		this.arrivalMins = arrivalMins;
	}
	
	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", airlines=" + airlines + ", fromCity=" + fromCity + ", toCity=" + toCity
				+ ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", passengerCount="
				+ passengerCount + ", seatingClass=" + seatingClass + ", price=" + price + ", currentPassengerCount="
				+ currentPassengerCount + ", userName=" + userName + "]";
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(String airlines, String fromCity, String toCity, Date departureDate, Date arrivalDate,
			Long passengerCount, String seatingClass, Double price, String userName,
			int active,Long hrs,Long mins,Long arrivalHrs,Long arrivalMins,Long flightId) {
		super();
		this.airlines = airlines;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.passengerCount = passengerCount;
		this.seatingClass = seatingClass;
		this.price = price;
		this.userName = userName;
		this.active=active;
		this.totalPrice=price*passengerCount;
		this.hrs= hrs;
		this.mins = mins;
		this.arrivalHrs =arrivalHrs;
		this.arrivalMins =arrivalMins;
		this.flightId =flightId;
		
	}
	
	

}
