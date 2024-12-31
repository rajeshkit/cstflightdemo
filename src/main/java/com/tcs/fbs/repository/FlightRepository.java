package com.tcs.fbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.fbs.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{
	public List<Flight> findByAirlineName(String airlineName);
	// select * from flight where airlinename="indigo"
}
