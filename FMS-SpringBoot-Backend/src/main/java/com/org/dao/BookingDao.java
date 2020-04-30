package com.org.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Booking;

@Repository
public interface BookingDao extends CrudRepository<Booking, BigInteger> {

}
