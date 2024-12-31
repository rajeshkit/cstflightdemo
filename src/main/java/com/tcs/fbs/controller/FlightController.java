package com.tcs.fbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.fbs.dto.FlightDto;
import com.tcs.fbs.service.FlightService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class FlightController {
	private FlightService flightService;

	@Autowired
	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}

	@PostMapping("/flight")
	public FlightDto createFlight(@RequestBody FlightDto flightDto) {
		// FlightService flightService=new FlightService();
		FlightDto d = flightService.createFlight(flightDto);
		return d;
	}

	@GetMapping("/flight")
	public List<FlightDto> getAllFlights() {
		List<FlightDto> list = flightService.getAllFlights();
		return list;
	}

	// http://localhost:9090/flight/2333
	@GetMapping("/flight/{flightId}")
	public FlightDto findFlightByNumber(@PathVariable int flightId) {
		return flightService.findFlightById(flightId);
	}

	// http://localhost:9090/flight/indigo
	@GetMapping("/flight/flightname/{flightName}")
	public List<FlightDto> findFlightByName(@PathVariable String flightName) {
		return flightService.findFlightByName(flightName);
		
	}

	// http://localhost:9090/flight/345
	@DeleteMapping("/flight/{flightId}")
	public String deleteFlightById(@PathVariable("flightId") int fId) {

		return flightService.deleteFlightById(fId);
	}

	@PutMapping("/flight")
	public FlightDto updateFlight(@RequestBody FlightDto flightDto) {
		return flightService.updateFlight(flightDto);
	}

}
