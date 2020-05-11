package com.org.controller;

import java.math.BigInteger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.org.exceptions.FlightNotFoundException;
import com.org.exceptions.FmsException;
import com.org.exceptions.InvalidAirportException;
import com.org.exceptions.InvalidBookingException;
import com.org.model.Airport;
import com.org.model.Booking;
import com.org.model.Passenger;
import com.org.model.ScheduledFlight;
import com.org.service.AirportService;
import com.org.service.BookingService;
import com.org.service.ScheduledFlightService;
import com.org.service.TicketService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@Autowired
	AirportService airportService;

	@Autowired
	ScheduledFlightService scheduleFlightService;

	@Autowired
	TicketService ticketService;

	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

	// To add a booking
	@PostMapping("/add")
	public ResponseEntity<Booking> addBooking(@ModelAttribute Booking booking,
			@RequestParam("flightId") BigInteger flightId, @RequestParam("userId") BigInteger userId) throws FmsException {
		booking.setUserId(userId);
		booking.setPassengerCount(booking.getPassengerList().size());
		for (Passenger passenger : booking.getPassengerList())
			passenger.setPassengerState(true);
		booking.setBookingDate(LocalDateTime.now());
		booking.setBookingState(true);
		booking.setScheduleFlight(scheduleFlightService.viewScheduledFlight(flightId));
		booking.setTicketCost(
				scheduleFlightService.viewScheduledFlight(flightId).getTicketCost() * booking.getPassengerCount());
		logger.info("Adding Booking.");
		try {
			booking = bookingService.addBooking(booking);
		} catch (Exception e) {
			logger.info("Data Not Added.");
			return new ResponseEntity("Data not added", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (booking == null) {
			logger.error("Unable to add booking.");
			return new ResponseEntity("Data not added", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			logger.info("Booking Added.");
			return new ResponseEntity<Booking>(booking, HttpStatus.OK);
		}
	}

	// To retrieve a booking by userId
	@GetMapping("/getbyuserid")
	public ResponseEntity<List<Booking>> getBookingsByUser(@RequestParam("userId") BigInteger userId) {
		List<Booking> bookingList;
		try {
			logger.info("Retrieving Bookings.");
			bookingList = bookingService.viewBookingsByUser(userId);
		} catch (InvalidBookingException exception) {
			logger.error("No Bookings Found.");
			return new ResponseEntity("No Bookings Found.", HttpStatus.BAD_REQUEST);
		}
		logger.info("Returning Bookings by user: " + userId);
		return new ResponseEntity<List<Booking>>(bookingList, HttpStatus.OK);
	}

	//Returns the previous booking
	@GetMapping("/getprev")
	public ResponseEntity<Booking> getLastBooking(@RequestParam("userId") BigInteger userId) {
		List<Booking> bookingList;
		try {
			logger.info("Retrieving Bookings.");
			bookingList = bookingService.viewBookingsByUser(userId);
		} catch (InvalidBookingException exception) {
			logger.error("No Bookings Found.");
			return new ResponseEntity("No Bookings Found.", HttpStatus.BAD_REQUEST);
		}
		logger.info("Retrieving Last Booking");
		return new ResponseEntity<Booking>(bookingList.get(bookingList.size() - 1), HttpStatus.OK);
	}

	//Retrieves all bookings
	@GetMapping("/getall")
	public ResponseEntity<List<Booking>> getBookings() {
		List<Booking> bookingList;
		try {
			logger.info("Retrieving Bookings.");
			bookingList = bookingService.viewBooking();
		} catch (InvalidBookingException exception) {
			logger.error("No Bookings Found.");
			return new ResponseEntity("No Bookings Found.", HttpStatus.BAD_REQUEST);
		}
		logger.info("Returning Bookings.");
		return new ResponseEntity<List<Booking>>(bookingList, HttpStatus.OK);
	}

	// To cancel a booking
	@DeleteMapping("/cancel")
	public ResponseEntity<Boolean> cancelBooking(@RequestParam("bookingId") BigInteger bookingId) {
		try {
			logger.info("Cancelling Booking.");
			bookingService.deleteBooking(bookingId);
		} catch (InvalidBookingException | FmsException exception) {
			logger.info("Unable to Cancel.");
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("Booking Cancelled.");
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	//Finds all available flights
	@GetMapping("/find")
	public ResponseEntity<List<ScheduledFlight>> flightSearch(@RequestParam("source_airport") String srcCode,
			@RequestParam("destination_airport") String destCode, @RequestParam("journey_date") String doj) {
		logger.info("Preparing Flight Search Parameters.");
		Airport sourceAirport;
		Airport destinationAirport;
		LocalDate journeyDate;
		try {
			sourceAirport = airportService.viewAirport(srcCode);
			destinationAirport = airportService.viewAirport(destCode);
			journeyDate = LocalDate.parse(doj);
			logger.info("Prepared Flight Search Parameters.");
			airportService.compareAirport(sourceAirport, destinationAirport);
		} catch (InvalidAirportException exception) {
			logger.error("Airport not found.");
			return new ResponseEntity("No Airports Found.", HttpStatus.BAD_REQUEST);
		}
		logger.info("Returning View Flights View.");
		try {
			return new ResponseEntity<List<ScheduledFlight>>(
					scheduleFlightService.viewScheduleFlights(sourceAirport, destinationAirport, journeyDate),
					HttpStatus.OK);
		} catch (FlightNotFoundException e) {
			logger.error("No Flights Available.");
			return new ResponseEntity("No Flights Found.", HttpStatus.BAD_REQUEST);
		}
	}

	//Finds booking by id
	@GetMapping("getbyid")
	public ResponseEntity<Booking> getBookingById(@RequestParam("bookingId") BigInteger bookingId) {
		try {
			logger.info("Returning Booking.");
			return new ResponseEntity<Booking>(bookingService.viewBooking(bookingId), HttpStatus.OK);
		} catch (InvalidBookingException e) {
			logger.error("Booking Not Found");
			return new ResponseEntity("Booking not found.", HttpStatus.BAD_REQUEST);
		}
	}

	//Generated ticket pdf and sends it
	@GetMapping("download")
	public ResponseEntity<String> download(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("booking_id") BigInteger bookingId) {
		logger.info("Downloading Ticket");
		String filePath;
		try {
			logger.info("Generating eTicket for id: " + bookingId);
			filePath = ticketService.generate(bookingId);
			ServletContext context = request.getServletContext();
			File downloadFile = new File(filePath);
			FileInputStream inputStream = new FileInputStream(downloadFile);
			String mimeType = context.getMimeType(filePath);
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}
			logger.info("MIME type: " + mimeType);
			response.setContentType(mimeType);
			response.setContentLength((int) downloadFile.length());
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
			response.setHeader(headerKey, headerValue);
			OutputStream outStream = response.getOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
			inputStream.close();
			outStream.close();
		} catch (DocumentException | InvalidBookingException | IOException e) {
			logger.error("Error Generating Ticket");
			return new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("Returning show booking view.");
		return new ResponseEntity<String>("Error", HttpStatus.OK);
	}
}
