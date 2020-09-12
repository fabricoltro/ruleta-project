package ar.com.utn.ruleta.modelo.dao.util.test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import org.junit.Test;
import ar.com.utn.ruleta.modelo.dao.util.ConnectionManager;


public class ConnectionManagerTest {

	@Test
	public void testConectar() {
		try {
			ConnectionManager.conectar();
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			assertTrue(false);
			e.printStackTrace();
		} catch (SQLException e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}

}
