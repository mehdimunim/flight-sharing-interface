package datanucleus;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flight_sharing_interface.jetty_jersey.dao.AircraftDao;
import com.flight_sharing_interface.jetty_jersey.dao.BookingDao;
import com.flight_sharing_interface.jetty_jersey.dao.DAO;
import com.flight_sharing_interface.jetty_jersey.dao.FlightDao;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Aircraft;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Booking;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;

public class FlightDaoImplTest {
	FlightDao dao = DAO.getFlightDao();
	BookingDao dao2 = DAO.getBookingDao();
	AircraftDao dao3 = DAO.getAircraftDao();

	Flight flight;
	long flightId;
	Date date;
	Time departureTime;
	Time arrivalTime;

	@Before
	public void addFlightTest() {

		flight = new Flight();

		date = Date.valueOf("2020-04-27");

		arrivalTime = Time.valueOf("06:00:00");
		departureTime = Time.valueOf("08:00:00");

		flight.setDepartureAerodrome("Paris");
		flight.setArrivalAerodrome("Berlin");

		flight.setDepartureDate(date);
		flight.setArrivalDate(date);

		flight.setDepartureTime(departureTime);
		flight.setArrivalTime(arrivalTime);

		flight.setPilotId(1);

		flight.setAircraftId(1);

		flight.setMeetingPlace("Roissy");

		flight.setPrice(100);

		dao.addFlight(flight);

		flightId = flight.getFlightId();

	}

	@After
	public void deletePilotTest() {

		dao.deleteFlight(flightId);

	}

	@Test
	public void getFlightTest() {

		// GET FLIGHTS

		Flight outputFlight = dao.getFlight(flightId);
		Assert.assertEquals("Roissy", outputFlight.getMeetingPlace());

		outputFlight = dao.getFlight(1, date, departureTime);
		Assert.assertEquals("Roissy", outputFlight.getMeetingPlace());

		List<Flight> outputFlights = dao.getAllFlights();
		Assert.assertEquals(1, outputFlights.size());

		outputFlights = dao.getFlightsWithDeparture("Paris");
		Assert.assertEquals("Roissy", outputFlights.get(0).getMeetingPlace());

		outputFlights = dao.getFlightsWithDateTime(date, departureTime);
		Assert.assertEquals("Roissy", outputFlights.get(0).getMeetingPlace());

		outputFlights = dao.getFlightsWithMeetingPlace("Roissy");
		Assert.assertEquals("Roissy", outputFlights.get(0).getMeetingPlace());

		outputFlights = dao.getPlannedFlights(1);
		Assert.assertEquals("Roissy", outputFlights.get(0).getMeetingPlace());

		// TEST EDIT

		// Creating newFlight with the fields we want to update
		Flight newFlight = new Flight();
		newFlight.setFlightId(flightId);
		newFlight.setMeetingPlace("EIDD");
		newFlight.setPrice(1000);

		outputFlight = dao.getFlight(flight.getFlightId());
		// test before edit
		Assert.assertEquals(100, outputFlight.getPrice(), 1);
		Assert.assertEquals("Roissy", outputFlight.getMeetingPlace());

		dao.editFlight(newFlight);

		// test after edit
		outputFlight = dao.getFlight(flightId);
		Assert.assertEquals("EIDD", outputFlight.getMeetingPlace());
		Assert.assertEquals(1000, outputFlight.getPrice(), 1);

		// TEST getAvailablePlaces

		// Without bookings

		Aircraft aircraft = new Aircraft();
		aircraft.setModel("SR-71");
		aircraft.setOwner("Hassna");
		aircraft.setNumberOfPlaces(10);

		dao3.addAircraft(aircraft);

		flight = new Flight();
		flight.setDepartureAerodrome("Berlin");
		flight.setArrivalAerodrome("Paris");
		flight.setPrice(100);
		flight.setAircraftId(aircraft.getAircraftId());

		dao.addFlight(flight);

		int places = dao.getAvailablePlaces(flight.getFlightId());

		// the flight is empty
		Assert.assertEquals(10, places);

		// With bookings

		Booking booking = new Booking();
		booking.setFlightId(flight.getFlightId());
		booking.setPassengerId(8);

		dao2.addBooking(booking);

		booking = new Booking();
		booking.setFlightId(flight.getFlightId());
		booking.setPassengerId(2);

		dao2.addBooking(booking);

		places = dao.getAvailablePlaces(flight.getFlightId());

		Assert.assertEquals(8, places);

		dao2.cancelBooking(1);
		dao2.cancelBooking(2);
		dao.deleteFlight(flight.getFlightId());
		dao3.deleteAircraft(aircraft.getAircraftId());

	}
}
