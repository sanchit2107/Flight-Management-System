package com.org.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.org.exceptions.InvalidBookingException;
import com.org.model.Booking;
import com.org.model.Passenger;


/**
 * @author SANCHIT SINGHAL
 *
 */

@Service("ticketService")
public class TicketService {
	
	@Autowired
	BookingService bookingService;

	private String FILE;
	BigInteger bookingId;
	
	public String generate(BigInteger bookingId) throws FileNotFoundException, DocumentException, InvalidBookingException {
		this.bookingId=bookingId;
		Document document=new Document();
		FILE="eTickets/FRSticket"+bookingId+".pdf";
		PdfWriter.getInstance(document, new FileOutputStream(FILE));
		document.open();
		addMetaData(document);
		addContent(document);
		document.close();
		return FILE;
	}
	
	private void addMetaData(Document document) {
		document.addTitle("FRS E-Ticket");
		document.addAuthor("FRS App");
	}
	
	private void addContent(Document document) throws DocumentException, InvalidBookingException {
		Booking booking=bookingService.viewBooking(bookingId);
		Paragraph paragraph=new Paragraph("FRS ETicket: "+bookingId);
		PdfPTable table=new PdfPTable(2);
		table.addCell("Booking Id:");
		table.addCell(""+booking.getBookingId());
		table.addCell("Booking Date:");
		table.addCell(""+booking.getBookingDate());
		table.addCell("Booking Cost:");
		table.addCell(""+booking.getTicketCost());
		table.addCell("Booking Status: ");
		if(booking.getBookingState()) {
			table.addCell("Confirm");
		}else {
			table.addCell("Cancelled");
		}
		table.addCell("Flight Id:");
		table.addCell(""+booking.getScheduleFlight().getScheduleFlightId());
		table.addCell("Source Airport: ");
		table.addCell(""+booking.getScheduleFlight().getSchedule().getSrcAirport().getAirportName());
		table.addCell("Destination Airport: ");
		table.addCell(""+booking.getScheduleFlight().getSchedule().getDstnAirport().getAirportName());
		table.addCell("Departure Time:");
		table.addCell(""+booking.getScheduleFlight().getSchedule().getDeptDateTime());
		table.addCell("Arrival Time:");
		table.addCell(""+booking.getScheduleFlight().getSchedule().getArrDateTime());
		paragraph.add(table);
		document.add(paragraph);
		paragraph=new Paragraph("Passenger Details: ");
		for(Passenger passenger: booking.getPassengerList()) {		
			table=new PdfPTable(2);
			table.addCell("Passenger Name:");
			table.addCell(""+passenger.getPassengerName());
			table.addCell("Passenger Age:");
			table.addCell(""+passenger.getPassengerAge());
			table.addCell("Passenger UIN:");
			table.addCell(""+passenger.getPassengerUIN());
			paragraph.add(table);
		}
		document.add(paragraph);
	}
	
}
