package com.example.jetty_jersey.dao;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DAO implements FlightDAO, PassengerDAO {

	/////////////////// FLIGHT///////////////////////////

	public List<Flight> getFlighsFromCriteria(String departure_aerodrome, LocalDateTime departureDateTime,
			LocalDateTime arrivalDateTime) {

		List<Flight> flightsList = new ArrayList<Flight>();

		Flight f1 = new Flight();
		f1.departure_aerodrome = "London";
		f1.departureDateTime = LocalDateTime.of(2020, Month.MAY, 25, 19, 30);
		f1.arrivalDateTime = LocalDateTime.of(2020, Month.MAY, 25, 20, 30);
		flightsList.add(f1);

		Flight f2 = new Flight();
		f2.departure_aerodrome = "Marseille";
		f2.departureDateTime = LocalDateTime.of(2020, Month.JANUARY, 25, 14, 30);
		f2.arrivalDateTime = LocalDateTime.of(2020, Month.JANUARY, 25, 15, 30);
		flightsList.add(f2);

		return flightsList;
	}

	public List<Flight> getFlightInfo(int flightId) {

		List<Flight> listFlights = new ArrayList<>();
		Flight flight = new Flight(1234, 150, "23 Street Neville", "London", "Manchester", 6, null, null,
				LocalDateTime.of(2020, Month.MAY, 25, 13, 30), LocalDateTime.of(2020, Month.MAY, 25, 17, 30));
		
		listFlights.add(flight);
		return listFlights;
	}

	public void editFlight(int flightId) {
		System.out.println("Flight information has been changed. Flight ID :  " + flightId);
	}

	@Override
	public void addFlight(int pilotId) {
		System.out.println("The flight has been added successfully by the pilot " + pilotId);
	}

	@Override
	public void deleteFlight(int flightId) {
		System.out.println("The flight " + flightId + " has been deleted successfully ! ");

	}

	/////////////////// PASSENGER ///////////////////////////

	@Override
	public void bookFlights(List<Flight> flights) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Flight> getBookedFlight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register(Passenger passenger) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelABooking(Booking booking) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loging(Passenger passenger) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFlight(Flight flight) {
		// TODO Auto-generated method stub
		
	}

}
