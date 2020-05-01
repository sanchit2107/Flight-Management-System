package com.org.service;

import com.org.service.AirportService;
import java.math.BigInteger;
import java.util.Optional;

import com.org.model.Airport;
import com.org.model.Flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.org.dao.AirportDao;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;

@Service
public class AirportServiceImpl implements AirportService {
	@Autowired
	AirportDao airportDao;

	/*
	 * view all Airports
	 */
	public Iterable<Airport> viewAllAirport() {
		return airportDao.findAll();
	}

	/*
	 * view airport by airportCode
	 */
	public Airport viewAirport(String airportCode) {
		Optional<Airport> findById = airportDao.findById(airportCode);
		if (findById.isPresent()) {
			return findById.get();
		} else
			throw new RecordNotFoundException("Airport with airport code: " + airportCode + "not exists");
	}

	/*
	 * add a airport
	 */
	public void addAirport(Airport airport) {
		Optional<Airport> findById = airportDao.findById(airport.getAirportCode());
		if (!findById.isPresent()) {
			airportDao.save(airport);
		} else
			throw new RecordAlreadyPresentException(
					"Airport with code : " + airport.getAirportCode() + " already present");
	}

	/*
	 * modify an Airport
	 */
	public void modifyAirport(Airport airport) {
		Optional<Airport> findById = airportDao.findById(airport.getAirportCode());
		if (findById.isPresent()) {
			airportDao.save(airport);
		} else
			throw new RecordNotFoundException("Airport with code: " + airport.getAirportCode() + " not exists");
	}

	/*
	 * remove an airport
	 */
	public void removeAirport(String airportCode) {
		Optional<Airport> findById = airportDao.findById(airportCode);
		if (findById.isPresent()) {
			airportDao.deleteById(airportCode);
		} else
			throw new RecordNotFoundException("Airport with code: " + airportCode + " not exists");

	}
}
