package datanucleus;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.flight_sharing_interface.jetty_jersey.dao.ActionDao;
import com.flight_sharing_interface.jetty_jersey.dao.DAO;
import com.flight_sharing_interface.jetty_jersey.dao.dn.ActionDaoImpl;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Action;

public class ActionDaoImplTest {

	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("flight-sharing-interface");
		ActionDao actionDao = new ActionDaoImpl(pmf);

		Assert.assertEquals(0, actionDao.getActions("user1").size());

		Action action = new Action();
		action.setUsername("user1");
		action.setTitle("A title");
		action.setContent("A content");

		actionDao.addAction(action);

		Assert.assertEquals(1, actionDao.getActions("user1").size());

		System.out.print("Hello");
	}

}
