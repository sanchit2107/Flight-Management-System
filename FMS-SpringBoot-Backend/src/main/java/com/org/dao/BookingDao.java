package com.org.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Booking;

@Repository("bookingDao")
public interface BookingDao extends JpaRepository<Booking, BigInteger> {
	
	/*	
	 *  Author: SANCHIT SINGHAL
	 *  Description: Retrieves bookings by user id.
	 *  Input: User Id
	 *  Output: List of Bookings
	 */
	List<Booking> findByUserId(BigInteger userId);
	
}