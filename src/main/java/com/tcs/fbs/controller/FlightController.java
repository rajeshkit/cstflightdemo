package com.tcs.fbs.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.tcs.fbs.dto.FlightDto;
import com.tcs.fbs.service.FlightService;

@RestController
public class FlightController {
	private FlightService flightService;


	@Autowired
	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}


    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public String health(){
        return "ok";
    }
    @GetMapping("/host")
    @ResponseStatus(code = HttpStatus.OK)
    public String health1() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
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
