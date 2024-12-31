package com.tcs.fbs.dto;

public class FlightDto {
	private int flightNumber;
	private String airlineName;
	private int totalSeat;
	public FlightDto() {
		
	}
	public FlightDto(int flightNumber, String airlineName, int totalSeat) {
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
		return "FlightDto [flightNumber=" + flightNumber + ", airlineName=" + airlineName + ", totalSeat=" + totalSeat
				+ "]";
	}
	
}
