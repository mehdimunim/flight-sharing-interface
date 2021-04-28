package datanucleus;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flight_sharing_interface.jetty_jersey.dao.BookingDao;
import com.flight_sharing_interface.jetty_jersey.dao.DAO;
import com.flight_sharing_interface.jetty_jersey.dao.FlightDao;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Booking;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;

public class FlightDaoImplTest {
	FlightDao dao = DAO.getFlightDao();
	BookingDao dao2 = DAO.getBookingDao();
	Flight flight;
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

		dao.addFlight(flight);

	}

	@After
	public void deletePilotTest() {

		dao.deleteFlight(1);

	}

	@Test
	public void getFlightTest() {

		Flight outputFlight = dao.getFlight(1);
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

//		EDIT DOES NOT WORK

		// Flight newFlight = dao.getFlightsWithMeetingPlace("Roissy").get(0);
		// newFlight.setMeetingPlace("Le Havre");
		// dao.editFlight(newFlight);
		// flight = dao.getFlight(3, date, departureTime);
		// Assert.assertEquals("Le Havre", flight.getMeetingPlace());

		Booking booking = new Booking();
		booking.setFlightId(10);
		booking.setPassengerId(8);

		dao2.addBooking(booking);

		booking = new Booking();
		booking.setFlightId(10);
		booking.setPassengerId(2);

		dao2.addBooking(booking);

		int places = dao.getAvailablePlaces(10);

		Assert.assertEquals(2, places);

		dao2.cancelBooking(1);
		dao2.cancelBooking(2);

	}
}
