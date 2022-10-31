package dk.via.sdj3.assignment.database;

import com.google.gson.Gson;

import java.io.*;

public class DatabaseCredentials {
	private final String username;
	private final String password;
	private final String connectivity;
	private final String dbms;
	private final String hostName;
	private final String portNumber;
	private final String schema;
	private final String dbName;

	private DatabaseCredentials(String username, String password, String connectivity, String dbms,
															String hostName, String portNumber, String schema, String dbName) {
		this.username 		= username;
		this.password 		= password;
		this.connectivity = connectivity;
		this.dbms 				= dbms;
		this.hostName 		= hostName;
		this.portNumber 	= portNumber;
		this.schema 			= schema;
		this.dbName 			= dbName;
	}

	public static DatabaseCredentials parseFile() throws FileNotFoundException {
		try (Reader jsonFile = new FileReader("dbaccess.json")) {
			Gson parser = new Gson();
			return parser.fromJson(jsonFile, DatabaseCredentials.class);
		} catch(FileNotFoundException e) {
			throw new FileNotFoundException("dbaccess.json not found");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getURL() {
		return "jdbc:postgresql://" + hostName + ":" + portNumber + "/" + dbName + "?currentSchema=" + schema;
	}

	@Override public String toString() {
		String[] propertiesNames = {"username", "password", "connectivity", "dbms", "hostName", "portNumber", "schema", "dbName"};
		String[] propertiesValue = {username, password, connectivity, dbms, hostName, portNumber, schema, dbName};
		StringBuilder sb = new StringBuilder("{\n");
		for (int i = 0; i < propertiesNames.length; i++) {
			sb.append("\t\"").append(propertiesNames[i]).append("\":\"").append(propertiesValue[i]).append("\",\n");
		}
		sb.deleteCharAt(sb.length() - 2).append("}");
		return sb.toString();
	}
}
