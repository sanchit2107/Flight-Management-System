package com.org.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.model.ScheduledFlight;

@Repository
public interface ScheduledFlightDao extends CrudRepository<ScheduledFlight, BigInteger>{

}
