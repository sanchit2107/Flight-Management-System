package com.org.service;

import java.math.BigInteger;
import java.util.List;

import com.org.exceptions.FmsException;
import com.org.exceptions.InvalidBookingException;
import com.org.model.Booking;
import com.org.model.ScheduledFlight;


public interface BookingService {

	public Booking addBooking(Booking booking)throws Exception;

	public List<Booking> viewBooking()throws InvalidBookingException;

	public Booking viewBooking(BigInteger bookingId)throws InvalidBookingException;
	
	public List<Booking> viewBookingsByUser(BigInteger userId)throws InvalidBookingException;

	public boolean deleteBooking(BigInteger bookingId)throws InvalidBookingException, FmsException;

	public boolean validatePassengerCount(ScheduledFlight scheduleFlight, Integer passengerChange)throws InvalidBookingException;

}
