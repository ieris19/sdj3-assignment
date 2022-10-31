package dk.via.sdj3.assignment.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private final String url = "postgres://";
    private final String username = "postgres";
    private final String password = "041199";

    private final String portNumber = "5432";
    private String dbms = "";
    private String dbName = "Animal";


    public Connection getConnection() throws SQLException {

        Connection connection = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.username);
        connectionProps.put("password", this.password);

        if (this.dbms.equals("postgresql")) {
            connection = DriverManager.getConnection(
                    "jdbc:" + this.dbms + "://" +
                            this.url +
                            ":" + this.portNumber + "/",
                    connectionProps);
        } else if (this.dbms.equals("derby")) {
            connection = DriverManager.getConnection(
                    "jdbc:" + this.dbms + ":" +
                            this.dbName +
                            ";create=true",
                    connectionProps);
        }
        System.out.println("Connected to database");
        return connection;
    }

}
