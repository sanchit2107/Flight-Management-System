package com.org.service;

import com.org.exceptions.*;
import java.math.BigInteger;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
	public void addFlight(Flight flight) {
		Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
		if (!findById.isPresent()) {
			flightDao.save(flight);
		} else
			throw new RecordAlreadyPresentException("Flight with number: " + flight.getFlightNo() + " already present");
	}

	/*
	 * view all flights
	 */
	public Iterable<Flight> viewAllFlight() {
		return flightDao.findAll();
	}

	/*
	 * search a flight
	 */
	public Flight viewFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightDao.findById(flightNumber);
		if (findById.isPresent()) {
			return findById.get();
		} else
			throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");
	}

	/*
	 * modify a flight
	 */
	public void modifyFlight(Flight flight) {
		Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
		if (findById.isPresent()) {
			flightDao.save(flight);
		} else
			throw new RecordNotFoundException("Flight with number: " + flight.getFlightNo() + " not exists");
	}

	/*
	 * remove a flight
	 */
	public void removeFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightDao.findById(flightNumber);
		if (findById.isPresent()) {
			flightDao.deleteById(flightNumber);
		} else
			throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");

	}
}
