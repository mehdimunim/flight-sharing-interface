package datanucleus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.flight_sharing_interface.jetty_jersey.dao.FlightDao;
import com.flight_sharing_interface.jetty_jersey.dao.dn.FlightDaoImpl;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;

public class FlightDaoImplTest {
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("flight-sharing-interface");
	static List<Integer> flightsId = new ArrayList<Integer>();
	FlightDao flightDAO = new FlightDaoImpl(pmf);
	static int nelements;

	public static void flightGenerator(int nelements) {
		/**
		 * Generate a random list of flights of size nelements
		 */
		for (int i = 1; i <= nelements; i++) {

			Flight flight = new Flight();

			double random = Math.random();
			double price = 1000 * random;
			int id = (int) (price);
			int places = (int) (100 * random);
			int year = 2021;
			int month = (int) (12 * random) + 1;
			int day = (int) (28 * random) + 1;
			int hour_de = (int) (12 * random) + 1;
			int hour_ar = (int) (12 * random) + 12;
			int minutes_de = (int) (30 * random) + 1;
			int minutes_ar = (int) (30 * random) + 30;

			LocalDateTime departure = LocalDateTime.of(year, month, day, hour_de, minutes_de);
			LocalDateTime arrival = LocalDateTime.of(year, month, day, hour_ar, minutes_ar);

			flight.setMeeting_place("Neverland");
			flight.setPrice(price);
			flight.setId(id);
			flight.setAvailabePlaces(places);
			flight.setDepartureDateTime(departure);
			flight.setDeparture_aerodrome("departure");
			flight.setArrivalDateTime(arrival);
			flight.setDestination_aerodrome("arrival");

			flightsId.add(flight.getId());

		}
	}

//	public void initDB() {
//		/**
//		 * Adding random flights to data base
//		 */
//		// generate nelements flights and add them to flights
//		nelements = 30;
//		flightGenerator(nelements);
//		for (int id : flightsId) {
//			flightDAO.addFlight(flight);
//			System.out.println("done");
//		}
//	}

	public void clearDB() {
		/**
		 * Removing all flights form data base
		 */
		if (flightsId != null) {
			for (int id : flightsId) {

				flightDAO.deleteFlight(id);
			}
		}
	}

	@Test
	public void basicTest() {
		Flight flight = new Flight();
		flight.setAvailabePlaces(200);
		flight.setId(100);

		// testing adding and getting from ID
		flightDAO.addFlight(flight);

		Flight flightOutput = flightDAO.getFlightInfo(100);
		Assert.assertEquals(200, flightOutput.getAvailabePlaces());

		// testing clearing from DB
		flightDAO.deleteFlight(100);
		Assert.assertNull(flightDAO.getFlightInfo(100));
	}

	@Test
	public void complexTest() {
		Flight flightInput = new Flight();
		flightInput.setId(1);
		flightInput.setMeeting_place("Neverland");

		flightsId.add(flightInput.getId());
		flightDAO.addFlight(flightInput);

		Flight flightOutput = flightDAO.getFlightInfo(flightsId.get(0));
		Assert.assertEquals("Neverland", flightOutput.getMeeting_place());
		clearDB();
	}

	@Test
	public void getFromCriteriaTest() {
		Flight flight = new Flight();

		flight.setAvailabePlaces(200);
		flight.setId(101);

		String departure_aerodrome = "Paris";
		LocalDateTime departureDateTime = LocalDateTime.of(2021, 03, 20, 4, 0);
		LocalDateTime arrivalDateTime = LocalDateTime.of(2021, 03, 20, 6, 0);

		flight.setDeparture_aerodrome(departure_aerodrome);
		flight.setDepartureDateTime(departureDateTime);
		flight.setArrivalDateTime(arrivalDateTime);

		flightDAO.addFlight(flight);

		List<Flight> list = flightDAO.getFlightsFromCriteria(departure_aerodrome, departureDateTime, arrivalDateTime);
		Assert.assertEquals(1, list.size());
		for (Flight f : list) {
			Assert.assertEquals("Paris", f.getDeparture_aerodrome());
		}
		clearDB();

	}

}
