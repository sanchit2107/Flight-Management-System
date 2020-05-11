package com.org.service;

import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.BookingDao;
import com.org.exceptions.FmsException;
import com.org.exceptions.InvalidBookingException;
import com.org.model.Booking;
import com.org.model.ScheduledFlight;


/**
 * @author: SANCHIT SINGHAL
 *  description: Implementation of the service interface for booking. 
 *  created date:
 */
@Service("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDao bookingRepository;

	@Autowired
	ScheduledFlightService scheduleFlightService;

	private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	/*
	 * Author: SANCHIT Description: Sends a booking to the repository. Input: Booking
	 * object. Output: Added booking object. Created Date: Last Modified:
	 * -
	 */
	@Override
	public Booking addBooking(Booking booking) throws Exception {
		BigInteger flightId = booking.getScheduleFlight().getScheduleFlightId();
		Integer decreaseCount = booking.getPassengerCount();
		logger.info("Decreasing Available Seats in Flight: "+flightId);
		scheduleFlightService.viewScheduledFlight(flightId)
				.setAvailableSeats(scheduleFlightService.viewScheduledFlight(flightId).getAvailableSeats()-decreaseCount);
		logger.info("Storing Booking.");
		return bookingRepository.save(booking);
	}

	/*
	 * Author: SANCHIT Description: Retrieves the list of all bookings. Input: -
	 * Output: List of Bookings. Created Date: Last Modified: -
	 */
	@Override
	public List<Booking> viewBooking() throws InvalidBookingException {
		List<Booking> bookings = bookingRepository.findAll();
		logger.info("Retrieved all bookings.");
		if (bookings.isEmpty()) {
			logger.error("No Bookings found.");
			throw new InvalidBookingException("No Bookings Found.");
		}
		logger.info("Returning retrieved Bookings.");
		return bookings;
	}

	/*
	 * Author: SANCHIT SINGHAL Description: Retrieves a booking by its id. Input: Booking Id.
	 * Output: Booking object. Created Date: Last Modified: -
	 */
	@Override
	public Booking viewBooking(BigInteger bookingId) throws InvalidBookingException {
		Booking booking;
		try {
			booking = bookingRepository.findById(bookingId).get();
		} catch (NoSuchElementException exception) {
			logger.error("No Bookings found.");
			throw new InvalidBookingException("No Bookings Found.");
		}
		logger.info("Retrieved Booking by Booking id: " + bookingId);
		logger.info("Returning Booking.");
		return booking;
	}

	/*
	 * Author: SANCHIT Description: Retrieves the bookings made by the user. Input:
	 * User Id. Output: List of bookings, Created Date: Last Modified: -
	 */

	@Override
	public List<Booking> viewBookingsByUser(BigInteger userId) throws InvalidBookingException {
		List<Booking> bookings;
		bookings = bookingRepository.findByUserId(userId);
		if (bookings.size() == 0) {
			logger.error("No Bookings found.");
			throw new InvalidBookingException("No Bookings Found.");
		}
		logger.info("Retrieved all Bookings made by User Id: " + userId);
		logger.info("Returning Bookings.");
		return bookings;
	}

	/*
	 * Author: SANCHIT SINGHAL Description: Cancels a booking. Input: Booking Id. Output:
	 * True if boolean is removed. Created Date: Last Modified: -
	 */
	@Override
	public boolean deleteBooking(BigInteger bookingId) throws InvalidBookingException, FmsException {
		Booking booking;
		try {
			booking = bookingRepository.findById(bookingId).get();
		} catch (NoSuchElementException exception) {
			logger.error("No Bookings found.");
			throw new InvalidBookingException("No Bookings Found.");
		}
		logger.info("Retrieved Booking by Booking id: " + bookingId);
		booking.setBookingState(false);
		BigInteger flightId = booking.getScheduleFlight().getScheduleFlightId();
		Integer increaseCount = booking.getPassengerCount();
		logger.info("Decreasing Available Seats in Flight: "+flightId);
		scheduleFlightService.viewScheduledFlight(flightId)
				.setAvailableSeats(scheduleFlightService.viewScheduledFlight(flightId).getAvailableSeats()+increaseCount);
		bookingRepository.save(booking);
		logger.info("Cancelled Booking.");
		return true;
	}

	/*
	 * Author: SANCHIT SINGHAL Description: Validates if seats are available in a flight
	 * against the current booking. Input: ScheduleFlight object, Passenger Count
	 * Output: True if seats are available, else false. Created Date: 
	 * Last Modified: -
	 */
	@Override
	public boolean validatePassengerCount(ScheduledFlight scheduleFlight, Integer passengerChange)
			throws InvalidBookingException {
		if (passengerChange > scheduleFlight.getAvailableSeats()) {
			logger.info("Checked for seats. Seats not available.");
			throw new InvalidBookingException("Seats not available.");
		}
		logger.info("Checked for Seats. Seats available.");
		return true;
	}

}