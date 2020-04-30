package com.org.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Booking;
import com.org.service.BookingService;

@RestController
@RequestMapping("/USer")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/createUser")
	public void addUser(User newUser) {
		
		UserService.createUser(newUser);
	}
	
	@GetMapping("/readAllUsers")
	public Iterable<User> readAllUsers() {
		
		return UserService.viewAllUser();
	}
	
	@PutMapping("/updateBooking")
	public void modifyBooking(Booking updateBooking) {
		
		bookingService.updateBooking(updateBooking);
	}
	
	@GetMapping("/searchUser/{id}")
	public Booking searchUserByID(@PathVariable("id") BigInteger userId) {
		
		return UserService.viewUser(userId);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUserByID(@PathVariable("id") BigInteger userId) {
		
		UserService.deleteUser(userId);
	}
}
