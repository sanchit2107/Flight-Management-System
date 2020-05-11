package com.org.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import com.org.exceptions.FlightNotFoundException;
import com.org.exceptions.RecordNotFoundException;
import com.org.exceptions.ScheduledFlightNotFoundException;
import com.org.model.Airport;
import com.org.model.ScheduledFlight;

public interface ScheduledFlightService {
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight);

	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);

	public String removeScheduledFlight(BigInteger id) throws RecordNotFoundException;

	public Iterable<ScheduledFlight> viewAllScheduledFlights();

	public ScheduledFlight viewScheduledFlight(BigInteger id) throws ScheduledFlightNotFoundException;
	// boolean cancelBookings(BigInteger flightId) throws RecordNotFoundException;

	public List<ScheduledFlight> viewScheduleFlights(Airport source, Airport destination, LocalDate flightDate)
			throws FlightNotFoundException;

}
