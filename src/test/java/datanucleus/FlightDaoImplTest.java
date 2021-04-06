package datanucleus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.example.jetty_jersey.dao.FlightDao;
import com.example.jetty_jersey.dao.dn.FlightDaoImpl;
import com.example.jetty_jersey.dao.objects.Flight;

public class FlightDaoImplTest {
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("flight-sharing-interface");
	static List<Flight> flights = new ArrayList<Flight>();
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

			flights.add(flight);
			// debug
			System.out.println(flight.getAvailabePlaces());

		}
	}

	public void initDB() {
		/**
		 * Adding random flights to data base
		 */
		// generate nelements flights and add them to flights
		nelements = (int) (20 * Math.random()) + 1;
		flightGenerator(nelements);
		for (Flight flight : flights) {
			flightDAO.addFlight(flight);
		}
	}

	public void clearDB() {
		/**
		 * Removing all flights form data base
		 */
		if (flights != null) {
			for (Flight flight : flights) {

				flightDAO.deleteFlight(flight.getId());
			}
		}
	}

	@Test
	public void getFlightInfoTest() {
		Flight flight = new Flight();

		flight.setAvailabePlaces(200);
		flight.setId(100);

		flightDAO.addFlight(flight);

		Flight flightOutput = flightDAO.getFlightInfo(100);
		Assert.assertEquals(200, flightOutput.getAvailabePlaces());
		flights.add(flightOutput);
		clearDB();
	}

	@Test
	public void complexFlightInfoTest() {
		initDB();

		Flight flight = flights.get(0);
		Flight flightOuput = flightDAO.getFlightInfo(flight.getId());
		Assert.assertEquals("Neverland", flightOuput.getMeeting_place());
		clearDB();
	}

	@Test
	public void getFlightsFromCriteria() {
		Flight flight = new Flight();

		flight.setAvailabePlaces(200);
		flight.setId(101);

		String departure_aerodrome = "Paris";
		LocalDateTime departureDateTime = LocalDateTime.of(2021, 03, 20, 4, 0);
		LocalDateTime arrivalDateTime = LocalDateTime.of(2021, 03, 20, 6, 0);

		flightDAO.addFlight(flight);

		List<Flight> list = flightDAO.getFlightsFromCriteria(departure_aerodrome, departureDateTime, arrivalDateTime);
		Assert.assertEquals(1, list.size());
		for (Flight f : list) {
			Assert.assertEquals("Paris", f.getDeparture_aerodrome());
		}
		clearDB();

	}

}
