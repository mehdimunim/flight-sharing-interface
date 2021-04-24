package datanucleus;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flight_sharing_interface.jetty_jersey.dao.PassengerDao;
import com.flight_sharing_interface.jetty_jersey.dao.dn.PassengerDaoImpl;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Passenger;

public class PassengerDaoImplTest {
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("flight-sharing-interface");
	PassengerDao dao = new PassengerDaoImpl(pmf);
	Passenger passenger;

	@Before
	public void register() {
		passenger = new Passenger();
		passenger.setId(100);

		passenger.setFirst_name("Jim");
		passenger.setLast_name("Cromwell");
		passenger.setCivil_statut("widower");
		passenger.setMail_adresse("jim.cromwell@gmail.com");

		dao.register(passenger);

	}

	@After
	public void clear() {
		dao.clearDB();
	}

	@Test
	public void loggingTest() {

		Passenger outputPassenger = dao.loging(100);

		Assert.assertEquals(outputPassenger.getFirst_name(), "Jim");

		Passenger nullPassenger = dao.loging(1);

		Assert.assertNull(nullPassenger);

	}

}
