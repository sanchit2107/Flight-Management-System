package com.org.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Booking;
import com.org.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@RequestMapping("/createBooking")
	public void addBooking(Booking newBooking) {
		
		bookingService.createBooking(newBooking);
	}
	
	@RequestMapping("/readAllBooking")
	public Iterable<Booking> readAllBookings() {
		
		return bookingService.displayAllBooking();
	}
	
	@RequestMapping("/updateBooking")
	public void modifyBooking(Booking updateBooking) {
		
		bookingService.updateBooking(updateBooking);
	}
	
	@RequestMapping("/searchBooking/{id}")
	public Booking searchBookingByID(@PathVariable("id") BigInteger bookingId) {
		
		return bookingService.searchBooking(bookingId);
	}
	
	@RequestMapping("/deleteBooking/{id}")
	public void deleteBookingByID(@PathVariable("id") BigInteger bookingId) {
		
		bookingService.deleteBooking(bookingId);
	}
}
