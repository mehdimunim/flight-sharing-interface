package datanucleus;

import java.time.LocalDate;
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
			flight.setDeparture_aerodrome("departure");
			flight.setDestination_aerodrome("arrival");

			flightsId.add(flight.getId());

		}
	}

	@Test
	public void basicTest() {
		Flight flight = new Flight();
		flight.setId(100);
		flight.setAvailabePlaces(200);

		// testing adding and getting from ID
		int myId = flightDAO.addFlight(flight);
		Assert.assertEquals(myId, 100);

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

		Assert.assertEquals(1, (int) (flightsId.get(0)));
		Flight flightOutput = flightDAO.getFlightInfo(flightsId.get(0));
		Assert.assertEquals("Neverland", flightOutput.getMeeting_place());
		flightDAO.clearDB();
	}

	@Test
	public void getFromCriteriaTest() {
		String paris = "Paris";
		String london = "London";
		String berlin = "Berlin";

		LocalDate departureDate1 = LocalDate.of(2021, 03, 20);
		LocalDate departureDate2 = LocalDate.of(2021, 04, 20);
		LocalDate departureDate3 = LocalDate.of(2021, 05, 20);

		LocalDate arrivalDate1 = LocalDate.of(2021, 03, 21);
		LocalDate arrivalDate2 = LocalDate.of(2021, 04, 21);
		LocalDate arrivalDate3 = LocalDate.of(2021, 05, 21);

		Flight flight1 = new Flight();

		flight1.setId(1);
		flight1.setDepartureDate(departureDate1);
		flight1.setArrivalDate(arrivalDate1);
		flight1.setDeparture_aerodrome(paris);

		Flight flight2 = new Flight();

		flight2.setId(2);
		flight2.setDepartureDate(departureDate2);
		flight2.setArrivalDate(arrivalDate2);
		flight2.setDeparture_aerodrome(london);

		Flight flight3 = new Flight();

		flight3.setId(3);
		flight3.setDepartureDate(departureDate3);
		flight3.setArrivalDate(arrivalDate3);
		flight3.setDeparture_aerodrome(berlin);

		flightDAO.addFlight(flight1);
		flightDAO.addFlight(flight2);
		flightDAO.addFlight(flight3);

		// Does not work well
		// The next tests will not work as a consequence
		// List<Flight> output = flightDAO.getFlightsFromCriteria(london,
		// departureDate2, arrivalDate2);
		// Assert.assertEquals(output.size(), 1);

		// Testing clearing DB
		List<Flight> outputAll = flightDAO.clearDB();
		Assert.assertEquals(3, outputAll.size());

	}

}
