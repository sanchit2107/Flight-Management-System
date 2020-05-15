package com.org.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.org.model.Flight;

import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class FlightTest {
/*
 * setup method
 */
	@Before
	public void initInput()
	{
		
	}
	BigInteger flightId=BigInteger.valueOf(1L);
	 @Test()
	  public final void testEquals() throws NullPointerException {
		  Flight f1=new Flight();
		  assertNotNull(f1);
		  Flight f2=null;
		  Flight f3= new Flight(flightId,"SpiceJet","AUI89",200);
		  Flight f4= new Flight(flightId,"SpiceJet","AUI89",200);
		  assertTrue(f3.equals(f4));
		  assertFalse(f3.equals(f2));
	 }
	@Test()
	public void testFlight()
	{
		Flight flight=new Flight(flightId,"AirIndia","A1111",200);
		assertEquals(flightId,flight.getFlightNo());
		assertEquals("AirIndia",flight.getCarrierName());
		assertEquals("A1111",flight.getFlightModel());
		assertEquals(200,flight.getSeatCapacity());
	}
	@Test
	  public final void testToString() {
		  Flight f1= new Flight(flightId,"SpiceJet","A45RT",200);
		  String result = String.format("Flight [flightNo=%s,carrierName=%7s,flightModel=%5s,seatCapacity=%3s]",
				  f1.getFlightNo(),f1.getCarrierName(), f1.getFlightModel(), f1.getSeatCapacity());
		  System.out.println(result);
		  System.out.println(f1.toString());
		  assertEquals(result, f1.toString());
	  }
}
