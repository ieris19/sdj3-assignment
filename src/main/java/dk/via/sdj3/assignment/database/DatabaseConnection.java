package dk.via.sdj3.assignment.database;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection connection;

	/**
	 * Creates connection for the driver manager
	 *
	 * @return A connection to our database
	 *
	 * @throws SQLException if an error occurs on the database
	 */
	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			try {
				DatabaseCredentials credentials = DatabaseCredentials.parseFile();
				connection = DriverManager.getConnection(credentials.getURL(), credentials.getUsername(),
																								 credentials.getPassword());
			} catch (FileNotFoundException e) {
				throw new IllegalStateException("No database credentials found", e);
			}
		}
		return connection;
	}
}
