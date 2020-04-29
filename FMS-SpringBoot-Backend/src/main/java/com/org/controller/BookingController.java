package com.org.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Booking;
import com.org.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/createBooking")
	public void addBooking(@RequestBody Booking newBooking) {
		
		bookingService.createBooking(newBooking);
	}
	
	@GetMapping("/readAllBooking")
	public Iterable<Booking> readAllBookings() {
		
		return bookingService.displayAllBooking();
	}
	
	@PutMapping("/updateBooking")
	public void modifyBooking(@RequestBody Booking updateBooking) {
		
		bookingService.updateBooking(updateBooking);
	}
	
	@GetMapping("/searchBooking/{id}")
	public Booking searchBookingByID(@PathVariable("id") BigInteger bookingId) {
		
		return bookingService.searchBooking(bookingId);
	}
	
	@DeleteMapping("/deleteBooking/{id}")
	public void deleteBookingByID(@PathVariable("id") BigInteger bookingId) {
		
		bookingService.deleteBooking(bookingId);
	}
}
