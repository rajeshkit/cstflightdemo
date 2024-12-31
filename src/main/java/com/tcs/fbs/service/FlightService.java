package com.tcs.fbs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tcs.fbs.dto.FlightDto;
import com.tcs.fbs.entity.Flight;
import com.tcs.fbs.repository.FlightRepository;

@Service
public class FlightService {
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private ModelMapper mapper;
	
	public FlightDto createFlight(FlightDto flightDto) {
		System.out.println("Service layer flight dto: "+flightDto);
		//ModelMapper - convert dto - entity / entity to dto
		Flight f=mapper.map(flightDto, Flight.class);
		Flight f1 = flightRepository.save(f);
		return mapper.map(f1, FlightDto.class);
	}
	public List<FlightDto> getAllFlights(){
		List<Flight> listOfFlight=flightRepository.findAll();
		List<FlightDto> listOfFlightDto=listOfFlight
			.stream()
			.map(flight->mapper.map(flight, FlightDto.class))
			.collect(Collectors.toList());
//		List<FlightDto> list=new ArrayList<>();
//		for (Flight flight2 : listOfFlight) {
//			list.add(mapper.map(flight2, FlightDto.class));
//		}
		return listOfFlightDto;
	}
	public FlightDto findFlightById(int flightId) {
		Optional<Flight> optional=flightRepository.findById(flightId);
		if(optional.isEmpty()) {
			throw new RuntimeException();
		}
		return mapper.map(optional.get(),FlightDto.class);
	}
	public List<FlightDto> findFlightByName(String airlineName){
		List<Flight> listOfFlights=flightRepository.findByAirlineName(airlineName);
		
		return listOfFlights
				.stream()
				.map(flight->mapper.map(flight, FlightDto.class))
				.collect(Collectors.toList());
	}
	
	
	
	public String deleteFlightById(int flightId) {
		boolean result=flightRepository.existsById(flightId);
		if(result==false) {
			return "Flight details are not deleted because flight ID is not exists:"+flightId;
		}
		flightRepository.deleteById(flightId);
		return "Flight details are deleted successfully with Flight ID: "+flightId;
	}
	
	public FlightDto updateFlight(FlightDto flightDto) {
		Flight f=mapper.map(flightDto, Flight.class);
		if(!flightRepository.existsById(f.getFlightNumber())) {
			throw new RuntimeException();
		}
		return mapper.map(flightRepository.save(f),FlightDto.class);
	}




}
