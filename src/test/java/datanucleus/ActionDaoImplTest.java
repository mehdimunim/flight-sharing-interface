package datanucleus;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.example.jetty_jersey.dao.Action;
import com.example.jetty_jersey.dao.ActionDao;
import com.example.jetty_jersey.dao.DAO;
import com.example.jetty_jersey.dao.dn.ActionDaoImpl;

public class ActionDaoImplTest {

	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		ActionDao actionDao = new ActionDaoImpl(pmf);

		Assert.assertEquals(0, actionDao.getActions("user1").size());

		Action action = new Action();
		action.setUsername("user1");
		action.setTitle("A title");
		action.setContent("A content");

		actionDao.addAction(action);

		Assert.assertEquals(1, actionDao.getActions("user1").size());

		DAO.getActionDao().getActions("user1");
	}

}
