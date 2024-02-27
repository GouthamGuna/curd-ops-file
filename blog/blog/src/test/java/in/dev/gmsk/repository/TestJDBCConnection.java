package in.dev.gmsk.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import in.dev.gmsk.model.JDBCModel;

public class TestJDBCConnection {

	@Test
	void test() throws SQLException {
		Connection conn = JDBCConnection.getConnection(JDBCModel.getJDBCModel());

		assertNotNull(conn);

		assertTrue(conn.isValid(0));

		conn.close();
	}
}
