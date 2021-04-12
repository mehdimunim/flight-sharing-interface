package datanucleus;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.flight_sharing_interface.jetty_jersey.dao.AircraftDao;
import com.flight_sharing_interface.jetty_jersey.dao.DAO;
import com.flight_sharing_interface.jetty_jersey.dao.dn.AircraftDaoImpl;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Aircraft;

public class AircraftDaoImplTest {

	@Test
	public void testAircraft() {

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("flight-sharing-interface");
		AircraftDao aircraftDao = new AircraftDaoImpl(pmf);

		Assert.assertNull(aircraftDao.getAircraftInfo(0));

		Aircraft aircraft = new Aircraft();
		aircraft.getAircrafts().add(new Aircraft("Boeing 717 "));
		aircraft.getAircrafts().add(new Aircraft("North American XB-45"));
		long id = DAO.getAircraftDao().addAircraftInfo(aircraft);

		Assert.assertEquals(2, DAO.getAircraftDao().getAircraftInfo(id).getAircrafts().size());
	}
}