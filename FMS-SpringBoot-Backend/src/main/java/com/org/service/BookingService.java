package com.org.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.BookingDao;
import com.org.exception.RecordAlreadyPresentException;
import com.org.exception.RecordNotFoundException;
import com.org.model.Booking;

@Service
public class BookingService {
	
	@Autowired
	BookingDao dao;
	
	/*
	 * making new Booking
	 */
	public void createBooking(Booking newBooking) {
		
		Optional<Booking> findBookingById = dao.findById(newBooking.getBookingId());
		if(!findBookingById.isPresent())
			dao.save(newBooking);
		else
			throw new RecordAlreadyPresentException("Booking with Booking Id: "+ newBooking.getBookingId() +" already exists!!");
		
	}
	
	/*
	 * show all bookings
	 */
	public  Iterable<Booking> displayAllBooking() {
	
		return dao.findAll();
	}
	
	/*
	 * delete booking by BookingId
	 */
	public void deleteBooking(BigInteger bookingId) {
		
		Optional<Booking> findBookingById = dao.findById(bookingId);
		if(findBookingById.isPresent())
			dao.deleteById(bookingId);
		else
			throw new RecordNotFoundException("Booking with Booking Id: "+ bookingId +" not exists!!");
	}
	
	/*
	 * search booking by BookingID
	 */
	public Booking searchBooking(BigInteger bookingId) {
		
		Optional<Booking> findBookingById = dao.findById(bookingId);
		if(findBookingById.isPresent())
			return findBookingById.get();
		else
			throw new RecordNotFoundException("Booking with Booking Id: "+ bookingId +" not exists!!");
	}
	
	/*
	 * update booking made
	 */
	public void updateBooking(Booking updateBooking) {
		
		Optional<Booking> findBookingById = dao.findById(updateBooking.getBookingId());
		if(findBookingById.isPresent())
			dao.save(updateBooking);
		else
			throw new RecordNotFoundException("Booking with Booking Id: "+ updateBooking.getBookingId() +" not exists!!");
		
	}
}
