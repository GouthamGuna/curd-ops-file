package in.dev.gmsk.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import in.dev.gmsk.model.JDBCModel;

public class JDBCConnection {

	public static Connection getConnection(JDBCModel jdbcModel) {
		Connection conn = null;
		try {
			Class.forName(jdbcModel.getDriver());
			conn = DriverManager.getConnection(jdbcModel.getURL(), jdbcModel.getDbUserName(),
					jdbcModel.getDbPassword());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
