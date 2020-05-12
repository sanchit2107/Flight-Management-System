package com.org.service;

import com.org.exceptions.*;
import java.math.BigInteger;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.org.dao.FlightDao;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.model.Flight;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	FlightDao flightDao;

	/*
	 * add a flight
	 */
	@Override
	public ResponseEntity<Flight> addFlight(Flight flight) {
		Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
		try {
		if (!findById.isPresent()) {
			flightDao.save(flight);
			return new ResponseEntity<Flight>(flight,HttpStatus.OK);
		} else
			throw new RecordAlreadyPresentException("Flight with number: " + flight.getFlightNo() + " already present");
	}
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * view all flights
	 */
	@Override
	public Iterable<Flight> viewAllFlight() {
		return flightDao.findAll();
	}

	/*
	 * search a flight
	 */
	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightDao.findById(flightNumber);
		if (findById.isPresent()) {
			return findById.get();
		}
		else
			throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");
	    }
		/*catch(RecordNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}*/

	/*
	 * modify a flight
	 */
	@Override
	public Flight modifyFlight(Flight flight) {
		Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
		if (findById.isPresent()) {
			flightDao.save(flight);
		} else
			throw new RecordNotFoundException("Flight with number: " + flight.getFlightNo() + " not exists");
		return flight;
	}

	/*
	 * remove a flight
	 */
	public String removeFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightDao.findById(flightNumber);
		if (findById.isPresent()) {
			flightDao.deleteById(flightNumber);
			return "Flight removed!!";
		} else
			throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");

	}
}
