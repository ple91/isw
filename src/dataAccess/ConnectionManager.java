// ConnectionManager class

package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	private String sourceURL;
	private Connection dbcon = null;

	public ConnectionManager(String dbname) throws ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");
		sourceURL = "jdbc:hsqldb:hsql://localhost/" + dbname;
	}

	public void connect() throws SQLException {
		if (dbcon == null)
			dbcon = DriverManager.getConnection(sourceURL);
	}

	public void close() throws SQLException {
		if (dbcon != null) {
			dbcon.close();
			dbcon = null;
		}
	}

	public void updateDB(String sql) throws SQLException {
		if (dbcon != null) {
			Statement sentencia = dbcon.createStatement();
			sentencia.executeUpdate(sql);
		}
	}

	public ResultSet queryDB(String sql) throws SQLException {
		if (dbcon != null) {
			Statement sentencia = dbcon.createStatement();
			return sentencia.executeQuery(sql);
		}
		return null;
	}
}
