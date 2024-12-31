package com.tcs.fbs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Flight {
	@Id
	private int flightNumber;
	private String airlineName;
	private int totalSeat;
	public Flight() {
		
	}
	public Flight(int flightNumber, String airlineName, int totalSeat) {
		super();
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.totalSeat = totalSeat;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public int getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", airlineName=" + airlineName + ", totalSeat=" + totalSeat
				+ "]";
	}
	

}
