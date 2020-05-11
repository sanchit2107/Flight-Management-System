package com.org.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.org.model.Airport;
import com.org.model.Flight;
import com.org.model.Schedule;
import com.org.model.ScheduledFlight;

import mockit.integration.junit4.JMockit;

/**
 * Test class for ScheduledFlight
 */
@RunWith(JMockit.class)
public class ScheduledFlightTest {
	/**
	   * setup method.
	   */
	  @Before
	  public void initInput() {

	  }
	  
	  /**
	   * Tests the equals/hashcode methods of the ScheduledFlight class.
	   * throws @NullPointerException to check hashcode of null value (line: 50)
	   */
	  @Test()
	  public final void testEquals() throws NullPointerException {
		  Airport airport1= new Airport("A101","Spain","Spain Airport");
		  Airport airport2= new Airport("A102","India","IGI Airport");
		  Flight flight= new Flight(new BigInteger("101"),"C101","M101",200);
		  Schedule schedule= new Schedule(new BigInteger("1"),airport1,airport2,"12-06-2020","13-06-2020");
		  ScheduledFlight sFlight1 = new ScheduledFlight();
		  assertNotNull(sFlight1);
		  ScheduledFlight sFlight2 = null;
		  ScheduledFlight sFlight3= new ScheduledFlight(new BigInteger("101"),flight,120,schedule);
		  ScheduledFlight sFlight4= new ScheduledFlight(new BigInteger("101"),flight,120,schedule);
		  assertTrue(sFlight3.equals(sFlight4));
		  assertFalse(sFlight3.equals(sFlight2));
		//  assertEquals(sFlight2.hashCode(), sFlight3.hashCode());
	  }
	  
	  /**
	   * Tests the toString() methods of the ScheduledFlight class.
	   */
	  @Test
	  public final void testToString() {
		  Airport airport1= new Airport("A101","Spain","Spain Airport");
		  Airport airport2= new Airport("A102","India","IGI Airport");
		  Flight flight= new Flight(new BigInteger("101"),"C101","M101",200);
		  Schedule schedule= new Schedule(new BigInteger("1"),airport1,airport2,"12-06-2020","13-06-2020");
		  ScheduledFlight sFlight1= new ScheduledFlight(new BigInteger("101"),flight,120,schedule);
		  String result = String.format("ScheduledFlight [scheduleFlightId=%3s, flight=%15s, availableSeats=%3s, schedule=%20s]",
				  sFlight1.getScheduleFlightId(), sFlight1.getFlight(), 
				  sFlight1.getAvailableSeats(), sFlight1.getSchedule());
		  assertEquals(result, sFlight1.toString());
	  }
	  
	  /**
	   * Testing add ScheduledFlight 
	   */
	  @Test
	  public final void testScheduledFlight() {
		  Airport airport1= new Airport("A101","Spain","Spain Airport");
		  Airport airport2= new Airport("A102","India","IGI Airport");
		  BigInteger b1= new BigInteger("101");
		  Flight flight= new Flight(b1,"C101","M101",200);
		  Schedule schedule= new Schedule(new BigInteger("1"),airport1,airport2,"12-06-2020","13-06-2020");
		  ScheduledFlight sFlight1= new ScheduledFlight(b1,flight,120,schedule);
		  assertEquals(b1, sFlight1.getScheduleFlightId());
		  assertEquals(120, sFlight1.getAvailableSeats());
		  assertEquals(flight, sFlight1.getFlight());
		  assertEquals(schedule, sFlight1.getSchedule());
	  }
	  
}


