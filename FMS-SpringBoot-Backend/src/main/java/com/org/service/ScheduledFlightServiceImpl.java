package com.org.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.model.Schedule;
import com.org.model.Airport;
import com.org.model.Booking;
import com.org.dao.ScheduleDao;
import com.org.dao.ScheduledFlightDao;
import com.org.exceptions.FlightNotFoundException;
import com.org.exceptions.RecordNotFoundException;
import com.org.exceptions.ScheduledFlightNotFoundException;
import com.org.model.ScheduledFlight;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {

	/*
	 * Creating DAO object
	 */
	@Autowired
	ScheduledFlightDao dao;

	@Autowired
	ScheduleDao scheduleDao;

	@Autowired
	BookingService bookingService;
	
	private static final Logger logger = LoggerFactory.getLogger(ScheduledFlightService.class);

	/*
	 * Service method to add new Scheduled flight to database
	 */
	@Override
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) {
		return dao.save(scheduledFlight);
	}

	/*
	 * Service method to modify existing Scheduled flight in database
	 */
	@Override
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduleFlight) {
		ScheduledFlight updateScheduleFlight = dao.findById(scheduleFlight.getScheduleFlightId()).get();
		Schedule updateSchedule = scheduleDao.findById(scheduleFlight.getSchedule().getScheduleId()).get();
		updateScheduleFlight.setAvailableSeats(scheduleFlight.getAvailableSeats());
		updateSchedule.setSrcAirport(scheduleFlight.getSchedule().getSrcAirport());
		updateSchedule.setDstnAirport(scheduleFlight.getSchedule().getDstnAirport());
		updateSchedule.setArrDateTime(scheduleFlight.getSchedule().getArrDateTime());
		updateSchedule.setDeptDateTime(scheduleFlight.getSchedule().getDeptDateTime());
		dao.save(updateScheduleFlight);
		return scheduleFlight;
	}

	/*
	 * Service method to remove existing Scheduled flight from database
	 */
	@Override
	public String removeScheduledFlight(BigInteger flightId) throws RecordNotFoundException {
		if (flightId == null)
			throw new RecordNotFoundException("Enter flight Id");
		Optional<ScheduledFlight> scheduleFlight = dao.findById(flightId);
		if (!scheduleFlight.isPresent())
			throw new RecordNotFoundException("Enter a valid Flight Id");
		else {
			// try {
			// cancelBookings(flightId);
			// } catch (RecordNotFoundException e) {
			// System.out.println("No Bookings Found");
			// }
			dao.deleteById(flightId);
		}
		return "Scheduled flight with ID " + flightId + " is not found";
	}

	// @Override
	// public boolean cancelBookings(BigInteger flightId) throws
	// RecordNotFoundException {
	// Iterable<Booking> bookingList = bookingService.displayAllBooking();
	// for (Booking booking : bookingList) {
	// if (booking.getScheduleFlight().getScheduleFlightId().equals(flightId)) {
	// bookingService.deleteBooking(booking.getBookingId());
	// }
	// }
	// return true;
	// }

	/*
	 * Service method to view all Scheduled flights in database
	 */
	@Override
	public Iterable<ScheduledFlight> viewAllScheduledFlights() {
		return dao.findAll();
	}

	/*
	 * Service method to view a Scheduled flight by ID from database
	 */
	@Override
	public ScheduledFlight viewScheduledFlight(BigInteger flightId) throws ScheduledFlightNotFoundException {
		if (flightId == null)
			throw new ScheduledFlightNotFoundException("Enter flight Id");
		Optional<ScheduledFlight> scheduleFlight = dao.findById(flightId);
		if (!scheduleFlight.isPresent())
			throw new ScheduledFlightNotFoundException("Enter a valid Flight Id");
		else
			return scheduleFlight.get();
	}

	@Override
	public List<ScheduledFlight> viewScheduleFlights(Airport source, Airport destination, LocalDate flightDate)
			throws FlightNotFoundException {
		logger.info("" + source);
		logger.info("" + destination);
		logger.info("" + flightDate);
		Iterable<ScheduledFlight> scheduleFlightList = dao.findAll();
		logger.info("Retrieved list of all scheduled flights.");
		List<ScheduledFlight> extractedFlightList = new ArrayList<>();
		for (ScheduledFlight scheduleFlight : scheduleFlightList) {
			if (scheduleFlight.getSchedule().getSrcAirport().equals(source)
					&& scheduleFlight.getSchedule().getDstnAirport().equals(destination)) {
				System.out.println("Schedule"+scheduleFlight.getSchedule().getDeptDateTime());
				System.out.println("User"+flightDate);
				if(scheduleFlight.getSchedule().getDeptDateTime().equals(flightDate))
					extractedFlightList.add(scheduleFlight);
			}
		}
		logger.info("Extracted list of scheduled flights as per parameters.");
		System.out.println(extractedFlightList);
		if (extractedFlightList.size() == 0) {
			logger.error("No Flights Found.");
			throw new FlightNotFoundException("No Flights Found");
		}
		logger.info("Returning list of scheduled flights.");
		return extractedFlightList;
	}

}
