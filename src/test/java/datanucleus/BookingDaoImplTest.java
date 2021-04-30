package datanucleus;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flight_sharing_interface.jetty_jersey.dao.BookingDao;
import com.flight_sharing_interface.jetty_jersey.dao.DAO;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Booking;

public class BookingDaoImplTest {

	BookingDao bookingDao = DAO.getBookingDao();
	Booking booking;

	@Before
	public void addBookingTest() {
		booking = new Booking();
		booking.setFlightId(2);
		booking.setPassengerId(12);

		bookingDao.addBooking(booking);

	}

	@After
	public void cancelBookingTest() {
		bookingDao.cancelBooking(booking.getBookingId());
	}

	@Test
	public void getBookingTest() {

		// The sequence of id has a memory even after some were deleted

		Booking outputBooking = bookingDao.getBooking(booking.getBookingId());

		Assert.assertEquals(2, outputBooking.getFlightId());

	}

}
