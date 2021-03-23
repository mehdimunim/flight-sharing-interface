package datanucleus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.jetty_jersey.dao.Flight;
import com.example.jetty_jersey.dao.FlightDAO;
import com.example.jetty_jersey.dao.dn.FlightDaoImpl;

public class FlightDaoImplTest {
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("flight-sharing-interface");
	List<Flight> flights;
	FlightDAO flightDAO = new FlightDaoImpl(pmf);

	public static List<Flight> flightGenerator(int nelements) {
		/**
		 * Generate a random list of flights of size nelements
		 */
		ArrayList<Flight> flights = new ArrayList<Flight>();
		for (int i = 0; i < nelements; i++) {

			Flight flight = new Flight();

			double random = Math.random();
			double price = 1000 * random;
			int id = (int) (price);
			int places = (int) (100 * random);
			int year = 2021;
			int month = (int) (13 * random) + 1;
			int day = (int) (28 * random) + 1;
			int hour_de = (int) (13 * random) + 1;
			int hour_ar = (int) (13 * random) + 12;
			int minutes_de = (int) (31 * random) + 1;
			int minutes_ar = (int) (31 * random) + 30;

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

		}
		return flights;
	}

	@Before
	public void initDB() {
		/**
		 * Adding random flights to data base
		 */
		int nelements = (int) (20 * Math.random());
		flights = flightGenerator(nelements);
		flights.addAll(flights);
		for (Flight flight:flights) {
			flightDAO.addFlight(flight);
		}
	}

	@After
	public void clearDB() {
		/**
		 * Removing all flights form data base
		 */
		for (Flight flight : flights) {
			flightDAO.deleteFlight(flight.getId());
		}
	}

	@Test
	public void getFlightInfoTest() {

		int id = flights.get(0).getId();
		List<Flight> list = flightDAO.getFlightInfo(id);

		Assert.assertEquals(1, list.size());
		for (Flight f : list) {
			Assert.assertEquals("Neverland", f.getMeeting_place());
		}
	}

	@Test
	public void getFlightsFromCriteria() {

		LocalDateTime departure = flights.get(0).getDepartureDateTime();
		LocalDateTime arrival = flights.get(0).getArrivalDateTime();
		List<Flight> list = flightDAO.getFlighsFromCriteria("departure", departure, arrival);
		Assert.assertEquals(1, list.size());
		System.out.print("hello");
		for (Flight f : list) {
			Assert.assertEquals(200, f.getAvailabePlaces());
		}

	}

}
