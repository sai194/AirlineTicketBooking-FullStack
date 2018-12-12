package com.sye.microservices.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "flights")
public class Flight {
	
	@Id
    @GeneratedValue
    @Column(name = "flight_id")
    private Long id;
	private String airlines;
	private String fromCity;
	private String toCity;
	@Temporal(TemporalType.DATE)
	private Date departureDate;
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;
	private Long passengerCount;
	private String seatingClass;
	private Double price;
	@Transient
	private Long currentPassengerCount;
	private Long hrs;
	private Long mins;
	private Long arrivalHrs;
	private Long arrivalMins;
	
	
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
	@Override
	public String toString() {
		return "Flight [id=" + id + ", airlines=" + airlines + ", fromCity=" + fromCity + ", toCity=" + toCity
				+ ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", passengerCount="
				+ passengerCount + ", seatingClass=" + seatingClass + ", price=" + price + ", currentPassengerCount="
				+ currentPassengerCount + "]";
	}
	public Flight(String airlines, String fromCity, String toCity, Date departureDate, Date arrivalDate,
			Long passengerCount, Double price,String seatingClass, Long hrs,Long mins, Long arrivalHrs,Long arrivalMins) {
		super();
		this.airlines = airlines;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.passengerCount = passengerCount;
		this.price = price;
		this.seatingClass= seatingClass;
		this.hrs= hrs;
		this.mins = mins;
		this.arrivalHrs =arrivalHrs;
		this.arrivalMins =arrivalMins;
	}
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
