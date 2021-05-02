package datanucleus;

import java.sql.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flight_sharing_interface.jetty_jersey.dao.DAO;
import com.flight_sharing_interface.jetty_jersey.dao.PassengerDao;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Passenger;

public class PassengerDaoImplTest {
	PassengerDao passengerDao = DAO.getPassengerDao();
	Passenger passenger;
	long id = 1;

	@Before
	public void addPassengerTest() {
		Date date = Date.valueOf("1999-05-03");
		passenger = new Passenger("jim", "Cromwell", "widower", date, "jim");
		passenger.setEmail("another email");
		Assert.assertEquals(passenger.getFirstName(), "jim");

		passengerDao.addPassenger(passenger);

		Assert.assertNotEquals(0, passenger.getPassengerId());

	}

	@After
	public void deletePassengerTest() {
		passengerDao.deletePassenger(1);
	}

	@Test
	public void getPassengerTest() {

		Passenger outputPassenger = passengerDao.getPassenger(1);

		Assert.assertEquals(1, outputPassenger.getPassengerId());

		Assert.assertEquals("jim", outputPassenger.getFirstName());

		Assert.assertEquals("another email", outputPassenger.getEmail());

	}

}
