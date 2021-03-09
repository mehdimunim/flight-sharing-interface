package com.example.jetty_jersey.ws;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.jetty_jersey.dao.Flight;
import com.example.jetty_jersey.dao.Passenger;
import com.example.jetty_jersey.dao.Pilot;
import com.example.jetty_jersey.ws.ExampleResource.ExampleClass;

@Path("/flightResource")
public class flightResource {
	

	public static class Aircraft {
		public String tailnumber;
	}
	
	//seulement ces 2 champs pour simplifier le bouchon
	public static class Flight {
		public int id;
		public String departure_aerodrome;
	}
	
	public static class flightsWished {
		public String departure_aerodrome;
		public LocalDate from;
		public LocalDate to;
	}
	
	public static class flightInfo {
		public LocalDateTime duration;
		public int availabePlaces;
		public double price; 
		public String meeting_place; 
		public String departure_aerodrome; 
		public String destination_aerodrome; 
		public LocalDateTime departureTime; 
		public LocalDate departureDate; 
		public LocalDate arrivalDate; 
		public LocalDateTime arrivalTime; 
		public Pilot pilot; 
		public List<Passenger> passengers = new ArrayList<Passenger>() ; 
		public int id;		
	}
	
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/aircraft")
	public List<Aircraft> getAircraft() {
		 List<Aircraft>  fleet = new ArrayList<Aircraft>();
		 
		 Aircraft a = new Aircraft();
		 a.tailnumber ="F5GHA";
		 fleet.add(a);
		
		 Aircraft b = new Aircraft();
		 a.tailnumber ="F6ZBA";
		 fleet.add(b);

		return fleet;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight-sharing/flights")
	public List<Flight> getFlight() {
		List<Flight>  fleet = new ArrayList<Flight>();
		 
		 Flight f1 = new Flight();
		 f1.id = 124;
		 f1.departure_aerodrome = "London";
		 fleet.add(f1);
		
		 Flight f2 = new Flight();
		 f2.id = 255;
		 f2.departure_aerodrome = "Marseille";
		 fleet.add(f2);

		return fleet;
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight-sharing/sign-in/pilot/{pilotId}/plane/{planeId}/flight/{flightId}")
	public void addFlight(Flight flight) {
		 flight.id = 124;
		 flight.departure_aerodrome = "London";

	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/flight-sharing/sign-in/pilot/{pilotId}/edit-flight/plane/{planeId}/flight/{flightId}")
	public void deleteFlight(Flight flight) {
		System.out.println("this flight was deleted");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/flight-sharing/pilot/{pilotId}/flight/{flightId}/booking/{bookingId}/information")
	public void changeFlightInfo(Flight flight) {
		System.out.println("flight information has been changed. Flight ID :  " + flight.id + "Departure Aerodrome : " + flight.departure_aerodrome);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight-sharing/pilot/{pilotId}/flightPlanned")
	public List<Flight> getFlighPlanned() {
		 List<Flight>  fleet = new ArrayList<Flight>();
		 
		 Flight f1 = new Flight();
		 f1.id = 124;
		 f1.departure_aerodrome = "London";
		 fleet.add(f1);
		
		 Flight f2 = new Flight();
		 f2.id = 255;
		 f2.departure_aerodrome = "London";
		 fleet.add(f2);

		return fleet;
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight-sharing/search-flight/flights")
	public List<flightsWished> getFlighsWished() {
		 List<flightsWished>  fleet = new ArrayList<flightsWished>();
		 
		 flightsWished f1 = new flightsWished();
		 f1.departure_aerodrome = "London";
		 f1.from = LocalDate.of(2017, 1, 13);
		 f1.to =  LocalDate.of(2017, 1, 13); 
		 fleet.add(f1);
		 
		 flightsWished f2 = new flightsWished();
		 f1.departure_aerodrome = "Marseille";
		 f1.from = LocalDate.of(2020, 2, 12);
		 f1.to =  LocalDate.of(2020, 2, 12); 
		 fleet.add(f2);
			
		return fleet;
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight-sharing/pilot/{pilotId}/flight/{flightId}/information")
	public void getFlighInfo(Flight flight) {
		 List<flightInfo>  fleet = new ArrayList<flightInfo>();
		
		 flightInfo f1 = new flightInfo();
		 	f1.duration = LocalDateTime.of(2019, 03, 28, 14, 33, 48, 123456789);
			f1.availabePlaces = 6;
			f1.price = 250; 
			f1.meeting_place = "Marseille"; 
			f1.departure_aerodrome = "Marseille Aeroport M1"; 
			f1.destination_aerodrome = "Marseille Aeroport M6"; 
			f1.departureTime =LocalDateTime.of(2019, 03, 28, 14, 33, 48, 123456789); 
			f1.departureDate = LocalDate.of(2020, 2, 12); ; 
			f1.arrivalDate = LocalDate.of(2020, 2, 12);
			f1.arrivalTime = LocalDateTime.of(2019, 03, 28, 14, 33, 48, 123456789); 
			f1.id = 233;
			fleet.add(f1);
		System.out.println("All flight information");
	}


}